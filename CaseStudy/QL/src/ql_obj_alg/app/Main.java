package ql_obj_alg.app;

import static ql_obj_alg.parse.TheParser.parse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import noa.Builder;
import noa.NoOp;
import noa.Union;
import ql_obj_alg.box.IFormat;
import ql_obj_alg.check.CollectTypeEnv;
import ql_obj_alg.check.ErrorReporting;
import ql_obj_alg.check.ICollect;
import ql_obj_alg.check.ITypeCheck;
import ql_obj_alg.check.TypeChecker;
import ql_obj_alg.check.TypeEnvironment;
import ql_obj_alg.cycles.ExprDependencies;
import ql_obj_alg.cycles.FormDependencies;
import ql_obj_alg.cycles.IDependencyGraph;
import ql_obj_alg.cycles.IDetectCycle;
import ql_obj_alg.cycles.IExpDependency;
import ql_obj_alg.cycles.StmtDependencies;
import ql_obj_alg.eval.ValueEnvironment;
import ql_obj_alg.format.Format;
import ql_obj_alg.parse.TheParser;
import ql_obj_alg.render.IRenderForm;
import ql_obj_alg.render.Registry;
import ql_obj_alg.render.Render;
import ql_obj_alg.syntax.IAllAlg;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IFormAlg;
import ql_obj_alg.syntax.IStmtAlg;
public class Main {
	
    public static void main(String[] args) throws Exception {
    	Main ql = new Main();
    	ql.load(args[0]);
    	ql.execute();
    }

	private Builder builder;
    

	protected Builder getBuilder() {
		return builder;
	}

	protected void setBuilder(Builder builder) {
		this.builder = builder;
	}
	
	public void execute(){
    	ErrorReporting errorReport = new ErrorReporting();
    	if(!typeCheckerForm(errorReport)){
    		errorReport.printErrors();
    		errorReport.printWarnings();
    	}
    	else{
    		printForm();
    		runUI(errorReport);
    	}
	}
    
	protected void load(String inputFile){
		try {
			StringWriter w = new StringWriter();
			prettyPrint(new FileInputStream(inputFile), w);
			System.out.println(w);
			setBuilder(TheParser.parse(new FileInputStream(inputFile)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

   
	private void printForm() {
		IFormat printingForm = builder.build(new Format());
		StringWriter w = new StringWriter();
		printingForm.format(0, false, w);
		System.out.println(w);
	}
	
	static <T> T recorder(Class<T> c) {
		return Builder.builderBuilder(c);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	void prettyPrint(InputStream input, StringWriter output) throws IOException {
		IAllAlg recorder = recorder(IAllAlg.class);
		Builder builder = (Builder) parse(input, recorder);
		IFormat printableForm = builder.build(new Format());
		printableForm.format(0, false, output);
	}

	protected <T> T buildUsing(Object ...algebras) {
		return getBuilder().build(Union.union(IAllAlg.class, algebras));
	}

	protected void printForm(StringWriter w, Object ...algebras) {
		IFormat printingForm = buildUsing(algebras);
		printingForm.format(0, false, w);
        System.out.println(w);
	}
	
	private boolean typeCheckerForm(ErrorReporting report) {
		TypeEnvironment typeEnv = new TypeEnvironment();
		collectQuestions(report, typeEnv, new CollectTypeEnv(), NoOp.noOp(IExpAlg.class));
		checkTypes(report, typeEnv);
		checkCyclicDependencies(report);
		return report.numberOfErrors() == 0;
	}

	private void checkCyclicDependencies(ErrorReporting report) {
		IFormAlg<IExpDependency,IDependencyGraph,IDetectCycle> formDependencies = new FormDependencies();
		IStmtAlg<IExpDependency,IDependencyGraph> stmtDependencies = new StmtDependencies();
		IExpAlg<IExpDependency> expDependencies = new ExprDependencies();
		checkCyclicDependencies(report, formDependencies, stmtDependencies, expDependencies);
	}

	protected void checkCyclicDependencies(ErrorReporting report, Object ...algebras) {
		IDetectCycle cyclesDetection = buildUsing(algebras);
		cyclesDetection.detect(report);
	}

	private void checkTypes(ErrorReporting report,
			TypeEnvironment typeEnv) {
		checkTypes(report, typeEnv, new TypeChecker());
	}

	protected void checkTypes(ErrorReporting report,
			TypeEnvironment typeEnv, Object ...algebras) {
		ITypeCheck checkTypes = buildUsing(algebras);
		checkTypes.check(typeEnv, report);
	}

	protected void collectQuestions(ErrorReporting report,
			TypeEnvironment typeEnv, Object ... algebras) {
		ICollect collectTypes = buildUsing(algebras);
		collectTypes.collect(typeEnv,report);
	}
	
	private void runUI(ErrorReporting errorReport){
		ValueEnvironment valEnv = new ValueEnvironment();
		Registry registry = new Registry();
		createUI(valEnv, registry, new Render());
	}

	protected void createUI(ValueEnvironment valEnv, Registry registry, Render render) {
		this.<IRenderForm>buildUsing(render).render(valEnv, registry);
	}

	
}

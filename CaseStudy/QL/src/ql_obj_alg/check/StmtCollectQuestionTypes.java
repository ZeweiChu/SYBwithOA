package ql_obj_alg.check;

import java.util.List;

import ql_obj_alg.check.errors.DuplicateQuestionError;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.check.warnings.DuplicateLabelWarning;
import ql_obj_alg.syntax.IStmtAlg;

public interface StmtCollectQuestionTypes<E> extends IStmtAlg<E,ICollect> {
	
	@Override
	default ICollect block(List<ICollect> stats) {
		return new ICollect(){
			public void collect(TypeEnvironment typeEnv, ErrorReporting report){
				for(ICollect stmt : stats)
					stmt.collect(typeEnv,report);
			}
		};
	}
	
	@Override
	default ICollect iff(final E cond, final ICollect then) {
		return (tenv, report) -> then.collect(tenv, report);
	}

	@Override
	default ICollect iffelse(final E cond, final ICollect statementsIf,
			final ICollect statementsElse) {
		return (tenv, report) -> { statementsIf.collect(tenv,report); statementsElse.collect(tenv, report); };
	}

	@Override
	default ICollect question(final String id, final String label, final Type type) {
		return new ICollect(){
			public void collect(TypeEnvironment typeEnv, ErrorReporting report){
				if(typeEnv.isDefined(id)){
					report.addError(new DuplicateQuestionError(id));
				}
				else{
					typeEnv.define(id, type);
				}
				if(typeEnv.containsLabel(label)){
					report.addWarning(new DuplicateLabelWarning(label));
				}
				else
					typeEnv.addLabel(label);
			}
		};
	}

	@Override
	default ICollect question(final String id, final String label, final Type type,
			final E exp) {
		return new ICollect(){
			public void collect(TypeEnvironment typeEnv,ErrorReporting report){
				question(id,label,type).collect(typeEnv, report);
			}
		};
	}

}

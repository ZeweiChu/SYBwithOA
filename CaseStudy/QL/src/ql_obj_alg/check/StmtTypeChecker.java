package ql_obj_alg.check;


import java.util.List;

import ql_obj_alg.check.errors.ConflictingTypeInAssignmentError;
import ql_obj_alg.check.errors.UnexpectedTypeError;
import ql_obj_alg.check.types.TBoolean;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.syntax.IStmtAlg;

public interface StmtTypeChecker extends IStmtAlg<IExpType, ITypeCheck> {

	@Override
	default ITypeCheck block(List<ITypeCheck> stats) {
		return (tenv, report) -> {
			for (ITypeCheck stmt : stats) {
				stmt.check(tenv,report);
			}
		};
	}
	
	@Override
	default ITypeCheck iff(final IExpType cond, final ITypeCheck then) {
		return new ITypeCheck(){
			public void check(TypeEnvironment typeEnv, ErrorReporting report){
				Type type = cond.type(typeEnv,report); 
				if(!type.isBoolean()){
					report.addError(new UnexpectedTypeError(new TBoolean(), type, "if-then"));
				}
				then.check(typeEnv, report);;
			}
		};
	}

	@Override
	default ITypeCheck iffelse(final IExpType cond, final ITypeCheck statementsIf,
			final ITypeCheck statementsElse) {
		return new ITypeCheck(){
			public void check(TypeEnvironment typeEnv, ErrorReporting report){
				Type type = cond.type(typeEnv,report); 
				if(!type.isBoolean()){
					report.addError(new UnexpectedTypeError(new TBoolean(), type, "if-then-else"));
				}
				statementsIf.check(typeEnv,report);
				statementsElse.check(typeEnv,report);
			}
		};
	}

	@Override
	default ITypeCheck question(final String id, final String label, final Type type) {
		return new ITypeCheck(){
			public void check(TypeEnvironment typeEnv, ErrorReporting report){
				Type type = typeEnv.getType(id);
				if(type == null) 
					assert(false) : "Missing question with id "+id+" from memory.";
			}
		};
	}

	@Override
	default ITypeCheck question(final String id, final String label, final Type type,
			final IExpType exp) {
		return new ITypeCheck(){
			public void check(TypeEnvironment typeEnv, ErrorReporting report){

				ITypeCheck ordQuestion = question(id,label,type);
				ordQuestion.check(typeEnv,report);

				Type exprType = exp.type(typeEnv,report); 
				if(!exprType.equals(type)){
					report.addError(new ConflictingTypeInAssignmentError(type, exprType,id));
				}

			}
		};
	}

}

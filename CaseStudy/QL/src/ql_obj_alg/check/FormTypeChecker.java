package ql_obj_alg.check;

import java.util.List;

import ql_obj_alg.syntax.IFormAlg;

public interface FormTypeChecker extends IFormAlg<IExpType, ITypeCheck, ITypeCheck> {

	@Override
	default ITypeCheck form(final String id, final List<ITypeCheck> statements) {
		return new ITypeCheck(){
			public void check(TypeEnvironment typeEnv, ErrorReporting report){
				for(ITypeCheck stmt : statements)
					stmt.check(typeEnv,report);
			}
		};
	}

}

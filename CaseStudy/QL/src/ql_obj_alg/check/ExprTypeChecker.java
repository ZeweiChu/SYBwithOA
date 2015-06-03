package ql_obj_alg.check;


import ql_obj_alg.check.errors.ConflictingTypeError;
import ql_obj_alg.check.errors.UndefinedQuestionError;
import ql_obj_alg.check.errors.UnexpectedTypeError;
import ql_obj_alg.check.errors.UnexpectedTypeInBinaryOpError;
import ql_obj_alg.check.types.TBoolean;
import ql_obj_alg.check.types.TError;
import ql_obj_alg.check.types.TInteger;
import ql_obj_alg.check.types.TNumber;
import ql_obj_alg.check.types.TString;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.syntax.IExpAlg;

public interface ExprTypeChecker extends IExpAlg<IExpType>{

	@Override
	default IExpType lit(int x) {
		return new IExpType(){
			@Override
			public Type type(TypeEnvironment typeEnv, ErrorReporting report) {
				return new TInteger();
			}
		};
	}

	@Override
	default IExpType bool(boolean b) {
		return new IExpType(){
			@Override
			public Type type(TypeEnvironment typeEnv, ErrorReporting report) {
				return new TBoolean();
			}
		};
	}

	@Override
	default IExpType string(String s) {
		return new IExpType(){
			@Override
			public Type type(TypeEnvironment typeEnv, ErrorReporting report) {
				return new TString();
			}
		};
	}

	@Override
	default IExpType var(final String varName) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type t = typeEnv.getType(varName);
				if(t != null)
					return t;
				report.addError(new UndefinedQuestionError(varName));
				return new TError();
			}
		};
	}

	@Override
	default IExpType mul(final IExpType lhs,final IExpType rhs) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type typeLhs = lhs.type(typeEnv, report);
				Type typeRhs = rhs.type(typeEnv, report);
				if(!typeLhs.isNumber() || !typeRhs.isNumber()){
					report.addError(new UnexpectedTypeInBinaryOpError(new TNumber(), typeLhs, typeRhs, "/"));
					return new TError();
				}
				return typeLhs.merge(typeRhs);
			}
		};
	}

	@Override
	default IExpType div(final IExpType lhs, final IExpType rhs) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type typeLhs = lhs.type(typeEnv, report); 
				Type typeRhs = rhs.type(typeEnv, report);
				if(!typeLhs.isNumber() || !typeRhs.isNumber()){
					report.addError(new UnexpectedTypeInBinaryOpError(new TNumber(), typeLhs, typeRhs, "/"));
					return new TError();
				}
				return typeLhs.merge(typeRhs);
			}
		};
	}

	@Override
	default IExpType add(final IExpType lhs, final IExpType rhs) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type typeLhs = lhs.type(typeEnv, report); 
				Type typeRhs = rhs.type(typeEnv, report);
				if(!typeLhs.isNumber() || !typeRhs.isNumber()){
					report.addError(new UnexpectedTypeInBinaryOpError(new TNumber(), typeLhs, typeRhs, "+"));
					return new TError();
				}
				return typeLhs.merge(typeRhs);
			}
		};
	}

	@Override
	default IExpType sub(final IExpType lhs, final IExpType rhs) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type typeLhs = lhs.type(typeEnv, report); 
				Type typeRhs = rhs.type(typeEnv, report);
				if(!typeLhs.isNumber() || !typeRhs.isNumber()){
					report.addError(new UnexpectedTypeInBinaryOpError(new TNumber(), typeLhs, typeRhs, "-"));				
					return new TError();
				}
				return typeLhs.merge(typeRhs);
			}
		};
	}

	@Override
	default IExpType eq(final IExpType lhs, final IExpType rhs) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type typeLhs = lhs.type(typeEnv, report); 
				Type typeRhs = rhs.type(typeEnv, report);
				if(!typeLhs.equals(typeRhs)){
					report.addError(new ConflictingTypeError(typeLhs, typeRhs, "=="));
					return new TError();
				}
				return new TBoolean();
			}
		};
	}

	@Override
	default IExpType neq(final IExpType lhs, final IExpType rhs) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type typeLhs = lhs.type(typeEnv, report); 
				Type typeRhs = rhs.type(typeEnv, report);
				if(!typeLhs.equals(typeRhs)){
					report.addError(new ConflictingTypeError(typeLhs, typeRhs, "!="));	
					return new TError();
				}
				return new TBoolean();
			}
		};
	}

	@Override
	default IExpType lt(final IExpType lhs, final IExpType rhs) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type typeLhs = lhs.type(typeEnv, report); 
				Type typeRhs = rhs.type(typeEnv, report);
				if(!typeLhs.isComparable(typeRhs)){
					report.addError(new ConflictingTypeError(typeLhs, typeRhs, "<"));
					return new TError();
				}
				return new TBoolean();
			}
		};
	}

	@Override
	default IExpType leq(final IExpType lhs, final IExpType rhs) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type typeLhs = lhs.type(typeEnv, report); 
				Type typeRhs = rhs.type(typeEnv, report);
				if(!typeLhs.isComparable(typeRhs)){
					report.addError(new ConflictingTypeError(typeLhs, typeRhs, "<="));	
					return new TError();
				}
				return new TBoolean();
			}
		};
	}

	@Override
	default IExpType gt(final IExpType lhs, final IExpType rhs) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type typeLhs = lhs.type(typeEnv, report); 
				Type typeRhs = rhs.type(typeEnv, report);
				if(!typeLhs.isComparable(typeRhs)){
					report.addError(new ConflictingTypeError(typeLhs, typeRhs, ">"));
					return new TError();
				}
				return new TBoolean();
			}
		};
	}

	@Override
	default IExpType geq(final IExpType lhs, final IExpType rhs) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type typeLhs = lhs.type(typeEnv, report); 
				Type typeRhs = rhs.type(typeEnv, report);
				if(typeLhs.isComparable(typeRhs)){
					report.addError(new ConflictingTypeError(typeLhs, typeRhs, ">="));
					return new TError();
				}
				return new TBoolean();
			}
		};
	}


	@Override
	default IExpType not(final IExpType a) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type t = a.type(typeEnv, report); 
				if(!t.isBoolean()){
					report.addError(new UnexpectedTypeError(new TBoolean(), t, "!"));
					return new TError();
				}
				return t;
			}
		};
	}

	@Override
	default IExpType and(final IExpType lhs, final IExpType rhs) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type typeLhs = lhs.type(typeEnv, report); 
				Type typeRhs = rhs.type(typeEnv, report);
				if(!typeLhs.isBoolean() || !typeRhs.isBoolean()){
					report.addError(new UnexpectedTypeInBinaryOpError(new TBoolean(), typeLhs, typeRhs, "&&"));
					return new TError();
				}
				return typeLhs.merge(typeRhs);
			}
		};
	}

	@Override
	default IExpType or(final IExpType lhs, final IExpType rhs) {
		return new IExpType(){
			public Type type(TypeEnvironment typeEnv, ErrorReporting report){
				Type typeLhs = lhs.type(typeEnv, report); 
				Type typeRhs = rhs.type(typeEnv, report);
				if(!typeLhs.isBoolean() || !typeRhs.isBoolean()){
					report.addError(new UnexpectedTypeInBinaryOpError(new TBoolean(), typeLhs, typeRhs, "||"));
					return new TError();
				}
				return typeLhs.merge(typeRhs);
			}
		};
	}

	@Override
	default IExpType bracket(IExpType e) {
		return new IExpType() {
			
			@Override
			public Type type(TypeEnvironment typeEnv, ErrorReporting report) {
				return e.type(typeEnv, report);
			}
		};
	}
}

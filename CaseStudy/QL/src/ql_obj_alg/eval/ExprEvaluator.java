package ql_obj_alg.eval;

import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.eval.values.VBoolean;
import ql_obj_alg.eval.values.VInteger;
import ql_obj_alg.eval.values.VString;
import ql_obj_alg.eval.values.Value;
import ql_obj_alg.syntax.IExpAlg;

public interface ExprEvaluator extends IExpAlg<IDepsAndEvalE>{

	@Override
	default IDepsAndEvalE lit(final int x) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return new VInteger(x);
			}

			@Override
			public List<String> deps() {
				return new ArrayList<String>();
			}	
		};
	}

	@Override
	default IDepsAndEvalE bool(final boolean b) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return new VBoolean(b);
			}

			@Override
			public List<String> deps() {
				return new ArrayList<String>();
			}	
		};
	}

	@Override
	default IDepsAndEvalE string(final String s) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return new VString(s);
			}

			@Override
			public List<String> deps() {
				return new ArrayList<String>();
			}	
		};
	}

	@Override
	default IDepsAndEvalE var(final String varName) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return valEnv.getQuestionValue(varName);
			}

			@Override
			public List<String> deps() {
				List<String> list = new ArrayList<String>();
				list.add(varName);
				return list;
			}	
		};
	}

	@Override
	default IDepsAndEvalE mul(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = lhs.eval(valEnv);
				Value v2 = rhs.eval(valEnv);
				return v1.mul(v2);
			}

			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}	
		};
	}

	@Override
	default IDepsAndEvalE div(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = lhs.eval(valEnv);
				Value v2 = rhs.eval(valEnv);
				return v1.div(v2);
			}

			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}
		};
	}

	@Override
	default IDepsAndEvalE add(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = lhs.eval(valEnv);
				Value v2 = rhs.eval(valEnv);
				return v1.add(v2);
			}

			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}
		};
	}

	@Override
	default IDepsAndEvalE sub(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = lhs.eval(valEnv);
				Value v2 = rhs.eval(valEnv);
				return v1.min(v2);
			}

			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}
		};
	}

	@Override
	default IDepsAndEvalE eq(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = lhs.eval(valEnv);
				Value v2 = rhs.eval(valEnv);
				return v1.eq(v2);
			}

			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}
		};
	}

	@Override
	default IDepsAndEvalE neq(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = lhs.eval(valEnv);
				Value v2 = rhs.eval(valEnv);
				return v1.neq(v2);
			}

			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}
		};
	}

	@Override
	default IDepsAndEvalE lt(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = lhs.eval(valEnv);
				Value v2 = rhs.eval(valEnv);
				return v1.lt(v2);
			}

			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}
		};
	}

	@Override
	default IDepsAndEvalE leq(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = lhs.eval(valEnv);
				Value v2 = rhs.eval(valEnv);
				return v1.leq(v2);
			}

			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}
		};
	}

	@Override
	default IDepsAndEvalE gt(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = lhs.eval(valEnv);
				Value v2 = rhs.eval(valEnv);
				return v1.gt(v2);
			}

			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}
		};
	}

	@Override
	default IDepsAndEvalE geq(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = lhs.eval(valEnv);
				Value v2 = rhs.eval(valEnv);
				return v1.geq(v2);
			}

			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}
		};
	}

	@Override
	default IDepsAndEvalE not(final IDepsAndEvalE exp) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v = exp.eval(valEnv);
				return v.not();
			}

			@Override
			public List<String> deps() {
				return exp.deps();
			}
		};
	}

	@Override
	default IDepsAndEvalE and(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = lhs.eval(valEnv);
				Value v2 = rhs.eval(valEnv);
				return v1.and(v2);
			}

			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}
		};
	}

	@Override
	default IDepsAndEvalE or(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = lhs.eval(valEnv);
				Value v2 = rhs.eval(valEnv);
				return v1.or(v2);
			}

			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}
		};
	}

	static List<String> unionLists(List<String> list1, List<String> list2){
		List<String> newList = new ArrayList<String>();
		newList.addAll(list1);
		newList.addAll(list2);
		return newList;		
	}

	@Override
	default IDepsAndEvalE bracket(IDepsAndEvalE e) {
		return new IDepsAndEvalE() {
			
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return e.eval(valEnv);
			}
			
			@Override
			public List<String> deps() {
				return e.deps();
			}
		};
	}
}

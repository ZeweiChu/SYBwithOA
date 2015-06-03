package ql_obj_alg.syntax;

import com.zewei.annotation.processor.Algebra;

import noa.annos.Level;
import noa.annos.Syntax;

@Algebra
public interface IExpAlg<E>{

	@Syntax("exp = '(' exp ')'")
	E bracket(E e);
	
	@Syntax("exp = INTEGER")
	E lit(int x);
	
	@Syntax("exp = BOOL") 
	E bool(boolean b);
	
	@Syntax("exp = STRING")
	E string(String s);
	
	@Syntax("exp = ID")
	E var(String varName);
	
	@Syntax("exp = '!' exp") @Level(200)
	E not(E exp);
	
	@Syntax("exp = exp '*' exp") @Level(100)
	E mul(E lhs, E rhs);
	
	@Syntax("exp = exp '/' exp") @Level(100)
	E div(E lhs, E rhs);
	
	@Syntax("exp = exp '+' exp") @Level(90)
	E add(E lhs, E rhs);
	
	@Syntax("exp = exp '-' exp") @Level(90)
	E sub(E lhs, E rhs);
	
	@Syntax("exp = exp '==' exp") @Level(80)
	E eq(E lhs, E rhs);
	
	@Syntax("exp = exp '!=' exp") @Level(80)
	E neq(E lhs, E rhs);
	
	@Syntax("exp = exp '<' exp") @Level(80)
	E lt(E lhs, E rhs);
	
	@Syntax("exp = exp '<=' exp") @Level(80)
	E leq(E lhs, E rhs);
	
	@Syntax("exp = exp '>' exp") @Level(80)
	E gt(E lhs, E rhs);
	
	@Syntax("exp = exp '>=' exp") @Level(80)
	E geq(E lhs, E rhs);
	
	@Syntax("exp = exp '&&' exp") @Level(70)
	E and(E lhs, E rhs);
	
	@Syntax("exp = exp '||' exp") @Level(60)
	E or(E lhs, E rhs);
}

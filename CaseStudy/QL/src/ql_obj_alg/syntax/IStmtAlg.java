package ql_obj_alg.syntax;

import java.util.List;

import noa.annos.Level;
import noa.annos.Syntax;
import ql_obj_alg.check.types.Type;

import com.zewei.annotation.processor.Algebra;

@Algebra
public interface IStmtAlg<E, S>  {
	@Syntax("stmt = 'if' '(' exp ')' stmt") @Level(80)
	S iff(E cond, S then);
	
	@Syntax("stmt = 'if' '(' exp ')' stmt 'else' stmt") @Level(70)
	S iffelse(E cond, S then, S els);

	@Syntax("stmt = ID ':' STRING TYPE") 
	S question(String id, String label, Type type);
	
	@Syntax("stmt = ID ':' STRING TYPE '=' '(' exp ')'") 
	S question(String id, String label, Type type, E exp);
	
	@Syntax("stmt = '{' stmt* '}'")
	S block(List<S> stats);
}


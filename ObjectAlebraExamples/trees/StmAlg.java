package trees;

import java.util.List;
import com.zewei.annotation.processor.Algebra;

@Algebra
public interface StmAlg<Stm, Exp, Typ>{
	Stm SDecl(Typ t, String v);
	Stm SAss(String v, Exp e);
	Stm SBlock(List<Stm> ls);
	Stm SReturn(Exp e);
	Exp EStm(Stm s);
	Exp EAdd(Exp exp1, Exp exp2);
	Exp EVar(String v);
	Exp EInt(int i);
	Typ TInt();
	Typ TFloat();
}


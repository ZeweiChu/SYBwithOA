package example_StmAlg;

import java.util.ArrayList;
import java.util.List;
import trees.StmAlg;

public class StmTest {
	
	static <Stm, Exp, Var, Typ> Stm exp(StmAlg<Stm, Exp, Typ> alg){
		List<Stm> ar = new ArrayList<Stm>();
		ar.add(alg.SDecl(alg.TFloat(), "var1"));
		ar.add(alg.SDecl(alg.TFloat(), "var3"));
		ar.add(alg.SDecl(alg.TFloat(), "var4"));
		
		
		List<Stm> as = new ArrayList<Stm>();
		as.add(alg.SDecl(alg.TFloat(), "var2"));
		as.add(alg.SAss("var2", alg.EInt(2)));
		as.add(alg.SAss("var8", alg.EInt(3)));
		as.add(alg.SDecl(alg.TFloat(), "var8"));
		
		ar.add(alg.SAss("var4", alg.EStm(alg.SBlock(as))));
		ar.add(alg.SAss("var3", alg.EInt(3)));
		ar.add(alg.SAss("var1", alg.EAdd(alg.EVar("var2"), alg.EVar("var3"))));
		ar.add(alg.SAss("var5", alg.EAdd(alg.EVar("var6"), alg.EVar("var7"))));
		
		return alg.SBlock(ar);
	}

	public static void main(String[] args) {
		StringQuery sQuery = new StringQuery();
		Rename rename = new Rename(sQuery);
		System.out.println(exp(sQuery));
		System.out.println(exp(rename));
	}
	
}

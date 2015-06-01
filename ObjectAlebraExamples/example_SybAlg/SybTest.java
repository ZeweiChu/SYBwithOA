package example_SybAlg;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import java.util.List;

import trees.OneOhOneAlg;

public class SybTest {

//BEGIN_GEN_COM
<C,D,U,E,P,S> C makeCompany(OneOhOneAlg<C,D,U,E,P,S> alg) {
	E ralf  = alg.E(alg.P("Ralf", "Amsterdam"), alg.S(8000.0f));
	E joost = alg.E(alg.P("Joost", "Amsterdam"), alg.S(1000.0f));
	E simon = alg.E(alg.P("Simon", "Cambridge"), alg.S(2000.0f));
	E blair = alg.E(alg.P("Blair", "London"), alg.S(100000.0f));
	List<U> us = asList(alg.PU(joost), alg.PU(simon));
	List<D> ds = asList(alg.D("Research", ralf, us), 
                        alg.D("Strategy", blair, emptyList()));
	return alg.C(ds);
}
//END_GEN_COM

	void TestCom() {
		
//BEGIN_CLIENTCODE_COMPANY
SalaryBill salaryBill = new SalaryBill();
System.out.println(makeCompany(salaryBill));
IncreaseSalary<Float,Float,Float,Float,Float,Float> incSalary 
  = new IncreaseSalary<>(salaryBill);
System.out.println(makeCompany(incSalary));
//END_CLIENTCODE_COMPANY

	}
	
	public static void main(String[] args) {
		
		SybTest sybTest = new SybTest();
		sybTest.TestCom();
		
		/*
		StringQuery sQuery = new StringQuery();
		SalaryBill fQuery = new SalaryBill();
		
		System.out.println("Result 1: (All names)\n\n" + genCom(sQuery) + "\n");
		System.out.println("Result 2: (Total salary)\n\n" + genCom(fQuery) + "\n");
		
		Rename rename = new Rename(sQuery);
		IncreaseSalary incSalary = new IncreaseSalary(fQuery);
		
		System.out.println("Result 3: (Renaming)\n\n" + genCom(rename) + "\n");
		System.out.println("Result 4: (Increasing salary)\n\n" + genCom(incSalary) + "\n");
		
		StringFloatQuery combine1 = new StringFloatQuery(sQuery, fQuery);
		StringFloatQuery combine2 = new StringFloatQuery(rename, incSalary);
		Pair<String, Float> result1 = genCom(combine1);
		Pair<String, Float> result2 = genCom(combine2);
		
		System.out.println("Result 5: (All names, total salary)\n\nPair element1 = " + result1.a() + "\nPair element2 = " + result1.b() + "\n");
		System.out.println("Result 6: (Renaming, increasing salary)\n\nPair element1 = " + result2.a() + "\nPair element2 = " + result2.b() + "\n");
	
		Rename2 rename2 = new Rename2(sQuery);
		System.out.println("Result 7: (Renaming2)\n\n" + genCom(rename2).apply("-"));
		*/
		
	}
	
}

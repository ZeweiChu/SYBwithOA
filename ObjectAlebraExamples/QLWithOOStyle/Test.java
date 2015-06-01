package QLWithOOStyle;

import java.util.Arrays;

class Test {
	
	Form makeQL() {
		Stmt name = new Question("name", "What is your name?", "string");
		Stmt age = new Question("age", "What is your age?", "integer");
		Stmt license = new Question("license", "Do yu have a driver's license?", "boolean");
		Exp geq = new GEq(new Var("age"), new Lit(18));
		Stmt iff = new If(geq, license);
		return new Form("DriverLicense", Arrays.asList(name, age, iff));
	}
	
	void go() {
		Form f = makeQL();
		System.out.println(f.usedVars());
		f.rename();
		System.out.println(f.usedVars());
	}
	
	public static void main(String args[]) {
		Test t = new Test();
		t.go();
	}
}

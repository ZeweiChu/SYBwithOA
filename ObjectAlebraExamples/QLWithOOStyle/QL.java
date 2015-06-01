package QLWithOOStyle;

import static java.util.Collections.emptySet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//BEGIN_OO_APPROACH
class Form {
	String name;
	List<Stmt> body;
	Form(String id, List<Stmt> body) {
		this.name = id;
		this.body = new ArrayList<Stmt>(body);
	}
	Set<String> usedVars() {
		Set<String> vars = new HashSet<>();
		body.forEach(s -> vars.addAll(s.usedVars()));
		return vars;
	}
	Form rename() {
		List<Stmt> ss = new ArrayList<>();
		for (Stmt s: body) ss.add(s.rename());
		return new Form(name, ss);
	}
}

abstract class Stmt {
	abstract Set<String> usedVars();
	abstract Stmt rename();
}

class If extends Stmt {
	Exp cond;
	Stmt then;
	If(Exp cond, Stmt then) {
		this.cond = cond;
		this.then = then;
	}
	Set<String> usedVars() {
		Set<String> vars = new HashSet<>(cond.usedVars());
		vars.addAll(then.usedVars());
		return vars;
	}
	If rename() {
		return new If(cond.rename(), then.rename());
	}
}

class Question extends Stmt {
	String name, label, type;
	Question(String n, String l, String t) {
		this.name = n;
		this.label = l;
		this.type = t;
	}
	Set<String> usedVars() {
		return emptySet();
	}
	Question rename() {
		return new Question(name + "_", label, type);
	}
}


abstract class Exp {
	abstract Set<String> usedVars();
	abstract Exp rename();
}

class Lit extends Exp {
	int n;
	Lit(int n) { 
		this.n = n; 
	}
	Set<String> usedVars() {
		return emptySet();
	}
	Lit rename() { 
		return new Lit(n); 
	}
}

class Var extends Exp {
	String x;
	Var(String name) { 
		this.x = name; 
	}
	Set<String> usedVars() {
		return Collections.singleton(x);
	}
	Var rename() {
		return new Var(x + "_");
	}
}

class GEq extends Exp {
	Exp lhs, rhs;
	GEq(Exp lhs, Exp rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	Set<String> usedVars() {
		Set<String> vars = new HashSet<>(lhs.usedVars());
		vars.addAll(rhs.usedVars());
		return vars;
	}
	GEq rename() {
		return new GEq(lhs.rename(), rhs.rename());
	}
}
//END_OO_APPROACH

/*

//BEGIN_OO_APPROACH_SIMP
class Form {
	String name; List<Stmt> body;
	Set<String> usedVars() {
		Set<String> vars = new HashSet<>();
		body.forEach(s -> vars.addAll(s.usedVars()));
		return vars;
	}
}

class If extends Stmt {
	Exp cond; Stmt then;
	Set<String> usedVars() {
		Set<String> vars=new HashSet<>(cond.usedVars());
		vars.addAll(then.usedVars());
		return vars;
	}
}

class Question extends Stmt {
	String name, label, type;
	Set<String> usedVars() { return emptySet(); }
}

class Lit extends Exp {
	int n;
	Set<String> usedVars() { return emptySet(); }
}

class Var extends Exp {
	String x;
	Set<String> usedVars() { return singleton(x); }
}

class GEq extends Exp {
	Exp lhs, rhs;
	Set<String> usedVars() {
		Set<String> vars = new HashSet<>(lhs.usedVars());
		vars.addAll(rhs.usedVars());
		return vars;
	}
}
//END_OO_APPROACH_SIMP

*/

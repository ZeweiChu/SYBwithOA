package sybDemo2;

import trees.OneOhOneAlg;

public interface G_Person {
	<Company,Dept,SubUnit,Employee,Person,Salary> Person accept(OneOhOneAlg<Company,Dept,SubUnit,Employee,Person,Salary> alg);
}
package sybDemo2;

import trees.OneOhOneAlg;

public interface G_Employee {
	<Company,Dept,SubUnit,Employee,Person,Salary> Employee accept(OneOhOneAlg<Company,Dept,SubUnit,Employee,Person,Salary> alg);
}
package sybDemo2;

import trees.OneOhOneAlg;

public interface G_Dept {
	<Company,Dept,SubUnit,Employee,Person,Salary> Dept accept(OneOhOneAlg<Company,Dept,SubUnit,Employee,Person,Salary> alg);
}
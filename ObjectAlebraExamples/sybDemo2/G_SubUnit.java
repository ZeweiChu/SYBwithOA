package sybDemo2;

import trees.OneOhOneAlg;

public interface G_SubUnit {
	<Company,Dept,SubUnit,Employee,Person,Salary> SubUnit accept(OneOhOneAlg<Company,Dept,SubUnit,Employee,Person,Salary> alg);
}
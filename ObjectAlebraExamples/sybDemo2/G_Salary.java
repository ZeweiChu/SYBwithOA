package sybDemo2;

import trees.OneOhOneAlg;

//BEGIN_G_SALARY
public interface G_Salary {
	<Company,Dept,SubUnit,Employee,Person,Salary> Salary accept(OneOhOneAlg<Company,Dept,SubUnit,Employee,Person,Salary> alg);
}
//END_G_SALARY
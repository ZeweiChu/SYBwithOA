package sybDemo2;

import trees.OneOhOneAlg;

//BEGIN_G_COMPANY
public interface G_Company {
	<Company,Dept,SubUnit,Employee,Person,Salary> Company accept(OneOhOneAlg<Company,Dept,SubUnit,Employee,Person,Salary> alg);
}
//END_G_COMPANY
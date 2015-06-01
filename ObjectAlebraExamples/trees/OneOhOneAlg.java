package trees;

import java.util.List;

import com.zewei.annotation.processor.Algebra;

//BEGIN_SYB_TREE
@Algebra
public interface OneOhOneAlg<Company,Dept,Unit,Employee,Person,Salary> {
  Company C(List<Dept> depts);
  Dept D(String name, Employee manager, List<Unit> units);
  Unit PU(Employee employee);
  Unit DU(Dept dept);
  Employee E(Person p, Salary s);
  Person P(String name, String address);
  Salary S(float salary);
}
//END_SYB_TREE

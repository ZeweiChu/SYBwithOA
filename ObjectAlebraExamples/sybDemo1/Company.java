package sybDemo1;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

//BEGIN_OOP_COMPANY
class Company {
	private List<Department> depts;
	Company(List<Department> depts) { this.depts = depts; }
	Float salaryBill() {
		return depts.stream().reduce(0.0f, (s, x) -> s + x.salaryBill(), 
                                           (x, y) -> x + y);
	}
	Company increaseSalary() {
		return new Company(depts.stream().map(d -> d.increaseSalary())
                                         .collect(toList()));
	}
}
class Salary {
	private Float salary;
	public Salary(Float salary) { this.salary = salary; }
	public Float salaryBill() { return this.salary; }
	public Salary increaseSalary() { return new Salary(this.salary * 1.1f); }
}
//END_OOP_COMPANY
class Department {
	private String name;
	private Employee manager;
	private List<Employee> lEmployee;
	private List<Department> lDepartment;
	public Department(String name, Employee manager, List<Employee> lEmployee, List<Department> lDepartment){
		this.name = name;
		this.manager = manager;
		this.lEmployee = lEmployee;
		this.lDepartment = lDepartment;
	}
	public Float salaryBill(){
		Float r = 0f;
		for (Employee e: this.lEmployee) r += e.salaryBill();
		for (Department d: this.lDepartment) r += d.salaryBill();
		r += this.manager.salaryBill();
		return r;
	}
	public Department increaseSalary(){
		List<Employee> le = new ArrayList<Employee>();
		List<Department> ld = new ArrayList<Department>();
		for (Employee e: this.lEmployee) le.add(e.increaseSalary());
		for (Department d: this.lDepartment) ld.add(d.increaseSalary());
		return new Department(this.name, this.manager.increaseSalary(), le, ld);
	}
}
class Employee {
	private Person person;
	private Salary salary;
	public Employee(Person person, Salary salary){
		this.person = person;
		this.salary = salary;
	}
	public Float salaryBill(){
		return this.salary.salaryBill();
	}
	public Employee increaseSalary(){
		return new Employee(this.person.increaseSalary(), this.salary.increaseSalary());
	}
}
class Person {
	private String name;
	private String address;
	public Person(String name, String address){
		this.name = name;
		this.address = address;
	}
	public Float salaryBill(){return 0.0f;}
	public Person increaseSalary(){return new Person(this.name, this.address);}
}



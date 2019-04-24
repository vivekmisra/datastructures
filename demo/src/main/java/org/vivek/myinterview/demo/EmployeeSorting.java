package org.vivek.myinterview.demo;
import java.util.Arrays;
import java.util.Comparator;
public class EmployeeSorting {

	public static void main(String[] args) {
		//sorting object array
		Employee[] empArr = new Employee[4];
		empArr[0] = new Employee(10, "Mikey", 25, 10000);
		empArr[1] = new Employee(20, "Arun", 29, 20000);
		empArr[2] = new Employee(5, "Lisa", 35, 5000);
		empArr[3] = new Employee(1, "Pankaj", 32, 50000);
		Arrays.sort(empArr);
		for(Employee e:empArr) {
			System.out.println(e+",");
		}
	}

	static class Employee implements Comparable<Employee> {

		private int id;
		private String name;
		private int age;
		private long salary;

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public long getSalary() {
			return salary;
		}

		public Employee(int id, String name, int age, int salary) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.salary = salary;
		}

		@Override
		public int compareTo(Employee emp) {
			// let's sort the employee based on an id in ascending order
			// returns a negative integer, zero, or a positive integer as this employee id
			// is less than, equal to, or greater than the specified object.
			//return (this.id - emp.id);
		int result = Comparator.comparing(Employee::getId).thenComparing(Employee::getSalary).
				thenComparing(Employee::getAge).compare(this, emp);
		return result;
		}

		@Override
		// this is required to print the user-friendly information about the Employee
		public String toString() {
			return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" + this.salary + "]";
		}

	}

}

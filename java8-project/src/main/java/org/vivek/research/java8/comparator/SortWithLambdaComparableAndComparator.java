package org.vivek.research.java8.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortWithLambdaComparableAndComparator {

	public static void main(String[] args) {
		List<Developer> l = new ArrayList<Developer>();
		Developer d1 = new Developer("Vivek", 25000, 30);
		l.add(d1);
		Developer d2 = new Developer("Alok", 30000, 40);
		l.add(d2);
		Developer d3 = new Developer("Tim", 20000, 25);
		l.add(d3);
		Developer d4= new Developer("John", 45000, 50);
		l.add(d4);
		for (Developer d : l) {
			System.out.print(d + ",");
		}
		
		
		// Sort employees by Salary ( Here Comparator is used :seems we dont need Comparable)
        Collections.sort(l, Comparator.comparingInt(Developer::getAge));
        System.out.print("\nDeveloper (Sorted by Age) : " + l);
		
		// Sort employees by Name (Here Comparator is used :seems we dont need Comprable)
        Collections.sort(l, Comparator.comparing((Developer::getName)));
        System.out.print("\nDeveloper (Sorted by Name) : " + l);
        Collections.sort(l, Comparator.comparing((Developer::getName)));
		
		//lambda for string fields :indirectly using Comparable implemented by String
		l.sort((Developer o1, Developer o2)->o1.getName().compareTo(o2.getName()));		
		
		//More lambda
		l.sort((o1, o2)->o1.getName().compareTo(o2.getName()));
		
		
		//Dependent Comparisions
		
		l.sort(
			      Comparator.comparing(Developer::getName).thenComparing(Developer::getAge)
			    );
		 System.out.print("\nDeveloper (Sorted by Name And then age) : " + l);
		 
			l.sort(
				      Comparator.comparing(Developer::getAge).thenComparing(Developer::getName)
				    );
			 System.out.print("\nDeveloper (Sorted by Age And then Name) : " + l);
			 

				l.sort(
					      Comparator.comparing(Developer::getAge).thenComparing(Developer::getName).thenComparing(Developer::getSalary)
					    );
				 System.out.print("\nDeveloper (Sorted by Age And then Name and the salary) : " + l);
	}

	static class Developer  {
		private String name;
		private long salary;
		private int age;

		public Developer(String name, long salary, int age) {
			this.name = name;
			this.age = age;
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getSalary() {
			return salary;
		}

		public void setSalary(long salary) {
			this.salary = salary;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Developer [name=" + name + ", salary=" + salary + ", age=" + age + "]";
		}

	}

		/*
		 * Comparable vs Comparator
		 * 
		 * Comparable lets a class implement its own comparison:
		 * 
		 * it's in the same class (it is often an advantage) there can be only one
		 * implementation (so you can't use that if you want two different cases)
		 * 
		 * 
		 * By comparison, Comparator is an external comparison:it is typically in a
		 * unique instance (either in the same class or in another place) you name each
		 * implementation with the way you want to sort things
		 * 
		 * you can provide comparators for classes that you do not control i.e even
		 * third party libs the implementation is usable even if the first object is
		 * null
		 * 
		 * Comparable is for providing a default ordering on data objects, for example
		 * if the data objects have a natural order.
		 * 
		 * A Comparator represents the ordering itself for a specific use.
		 * 
		 * For same class comparison,Comparable is usually preferred. But sometimes a
		 * class already implements Comparable, but you want to sort on a different
		 * property. Then you're forced to use a Comparator.
		 */

		public static Comparator<Developer> DeveloperNameComparator = new Comparator<Developer>() {

			public int compare(Developer developer1, Developer developer2) {

				String developerName1 = developer1.getName().toUpperCase();
				String developerName2 = developer2.getName().toUpperCase();

				// ascending order
				return developerName1.compareTo(developerName2);

				// descending order
				// return developerName2.compareTo(developerName1);
			}

		};

	}



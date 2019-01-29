package org.vivek.research.java8.comparator.legacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortWithComparableAndComparator {

	public static void main(String[] args) {
		List<Developer> l = new ArrayList<Developer>();
		Developer d1 = new Developer("Vivek", 25000, 30);
		l.add(d1);
		Developer d2 = new Developer("John", 30000, 40);
		l.add(d2);
		Developer d3 = new Developer("Tim", 20000, 25);
		l.add(d3);
		Developer d4= new Developer("Alok", 45000, 50);
		l.add(d4);
		for (Developer d : l) {
			System.out.print(d + ",");
		}

		System.out.println("BEFORE SORT");
		Collections.sort(l);
		System.out.println();

		System.out.println("AFTER SORT BY COMPARABLE ON AGE");
		for (Developer d : l) {
			System.out.print(d + ",");
		}
		System.out.println();

		Collections.sort(l, Developer.DeveloperNameComparator);

		System.out.println("AFTER SORT BY COMPARTOR");
		for (Developer d : l) {
			System.out.print(d + ",");
		}

		// When the sorting requirement is changed, you just pass in another new
		// anonymous Comparator class :

		// sort by name using Comparator implementation
		Collections.sort(l, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println();

		System.out.println("AFTER SORT BY COMPARABLE ON NAME");
		for (Developer d : l) {
			System.out.print(d + ",");
		}
		System.out.println();

	}

	static class Developer implements Comparable<Developer> {
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

		@Override
		public int compareTo(Developer otherDeveloper) {
			int otherDeveloperAge = ((Developer) otherDeveloper).getAge();

			// ascending order
			return this.age - otherDeveloperAge;

			// descending order
			// return otherDeveloperAge - this.age;
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

}

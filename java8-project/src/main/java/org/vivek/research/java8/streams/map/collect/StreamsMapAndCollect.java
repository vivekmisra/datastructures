package org.vivek.research.java8.streams.map.collect;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsMapAndCollect {
	
	
	public static void main(String[] args) {
		
		List<String> alpha = Arrays.asList("a", "b", "c", "d");

        //Before Java8
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha) {
            alphaUpper.add(s.toUpperCase());
        }

        System.out.println(alpha); //[a, b, c, d]
        System.out.println(alphaUpper); //[A, B, C, D]

        //past list of charcters & return list of their uppercase
        List<String> collectedList = mapAndCollecIntoList(alpha);

        // Extra, streams apply to any data type.
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        //past list of numbers & return list of their squares
         num= mapAndCollectIntoList(num);
         
         
         
         List<Staff> staff = Arrays.asList(
                 new Staff("mkyong", 30, new BigDecimal(10000)),
                 new Staff("jack", 27, new BigDecimal(20000)),
                 new Staff("lawrence", 33, new BigDecimal(30000))
         );
         
         
         List<String> collectedNames = mapAndCollectStringFieldList(staff);
         System.out.println(collectedNames); //[mkyong, jack, lawrence]
         
         
         List<Integer> collectedAges = mapAndCollectIntFieldList(staff);
         System.out.println(collectedAges);

	}



	private static List<Integer> mapAndCollectIntoList(List<Integer> num) {
        List<Integer> collectedList = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collectedList); //[2, 4, 6, 8, 10]
        return collectedList;
	}

	private static List<String> mapAndCollecIntoList(List<String> alpha) {
		// Java 8
        List<String> collectedList = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collectedList); //[A, B, C, D]
        return collectedList;
	}
	
	
	private static List<String> mapAndCollectStringFieldList(List<Staff> staff) {
		List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
		return collect;
	}
	

	private static List<Integer> mapAndCollectIntFieldList(List<Staff> staff) {
		List<Integer> collect = staff.stream().map(x -> x.getAge()).collect(Collectors.toList());
		return collect;
	}
	
	
	
	
	
	
	static class Staff {

	    private String name;
	    private int age;
	    private BigDecimal salary;
	    
	    
		public Staff(String name, int age, BigDecimal salary) {
			super();
			this.name = name;
			this.age = age;
			this.salary = salary;
		}
		//...
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public BigDecimal getSalary() {
			return salary;
		}
		public void setSalary(BigDecimal salary) {
			this.salary = salary;
		}
		@Override
		public String toString() {
			return "Staff [name=" + name + ", age=" + age + ", salary=" + salary + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((salary == null) ? 0 : salary.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Staff other = (Staff) obj;
			if (age != other.age)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (salary == null) {
				if (other.salary != null)
					return false;
			} else if (!salary.equals(other.salary))
				return false;
			return true;
		}
	    
	}


}

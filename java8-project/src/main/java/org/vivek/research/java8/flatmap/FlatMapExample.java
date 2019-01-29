package org.vivek.research.java8.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 * <p>
 * In Java 8, Stream can hold different data types, for examples:
 *
 * Stream<String[]> -- Stream as String array Stream<Set<String>> -- Stream as
 * Set of String Stream<List<String>> -- Stream as List of String
 * Stream<List<Object>> -- Stream as List of Object
 * 
 * But, the Stream operations (filter, sum, distinct…) and collectors do not
 * support it, so, we need flatMap() to do the following conversion :
 * 
 * Stream<String[]> -> flatMap -> Stream<String> Stream<Set<String>> -> flatMap
 * -> Stream<String> Stream<List<String>> -> flatMap -> Stream<String>
 * Stream<List<Object>> -> flatMap -> Stream<Object>
 * 
 * How flatMap() works :
 * 
 * { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
 * 
 * { {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
 *
 * 
 *
 * @version 1.0
 * @author <a href="http://www.colloquial.com/carp">Bob Carpenter</a>
 */
public class FlatMapExample {
	 

	/**
	 * 
	 * 1. Stream + String[] + flatMap 1.1 The below example will print an empty
	 * result, because filter() has no idea how to filter a stream of String[].
	 */
	public static void main(String[] args) {
		FlatMapExample f = new FlatMapExample();
		filterStreamStringArrayWithoutFlapMap();
		filterStreamStringArrayWithFlapMap();
		
		
		setWithFlatMap(f);

	}


	
	
	private static void filterStreamStringArrayWithoutFlapMap() {
		System.out.println("***filterStreamStringArrayWithoutFlapMap()***");
		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		System.out.println("Input: "+ Arrays.deepToString(data));
		//Stream<String[]>
		System.out.println("Step:#1:get Stream<String[] from 2d array:");
        Stream<String[]> temp1= Arrays.stream(data);
      
        Arrays.stream(data).forEach(System.out::println);
       

        //filter a stream of string[], and return a string[]?
        Stream<String[]> stream = Arrays.stream(data).filter(x -> "a".equals(x.toString()));
        System.out.println(" output==>");
        stream.forEach(System.out::println);
       

	}
	private static void filterStreamStringArrayWithFlapMap() {
	    System.out.println(" \n");
        System.out.println("** Application of flatmap-filter on 2d array:");
		System.out.println("***filterStreamStringArrayWithtFlapMap()***");
		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		System.out.println("Input: "+ Arrays.deepToString(data));
		
		//Stream<String[]>
		System.out.println("Step:#1:create Stream<String[]> from 2d arrayString[][] input by applyiong flatmap");

        //Stream<String>, GOOD!
        Stream<String> stringStream = Arrays.stream(data).flatMap(x -> Arrays.stream(x));
        
        System.out.println(" output==>");
        //reconstruct a new stream as a stream closes as soon it is done
        Stream<String> stringStream2 = Arrays.stream(data).flatMap(x -> Arrays.stream(x));
        stringStream2.forEach(System.out::println);

        System.out.println("Step:#2:Apply filter method: filter by 'a'");
        Stream<String> stream = stringStream.filter(x -> "a".equals(x.toString()));
        System.out.println(" output==>");
        stream.forEach(System.out::println);

		/*Stream<String> stream = Arrays.stream(data)
                .flatMap(x -> Arrays.stream(x))
                .filter(x -> "a".equals(x.toString()));*/

	}
	
	private static void setWithFlatMap(FlatMapExample f) {
		Student obj1 = f.new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = f.new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        System.out.println(" \n");
        System.out.println("** Application of map-flatmap-distinct-collect on Students'books :");

        System.out.println("Step#1: create a new stream  Of Students:");
        Stream<FlatMapExample.Student> collect =list.stream();
        debug1(list);
        System.out.println(" \n");
        //apply map to create a new stream as set Of Strings
        System.out.println("Step#2:apply map to extract book field  & create a new stream as set Of Strings of books from stream of Students:");
        Stream<Set<String>> streamSetOfStrings = list.stream().map(x -> x.getBook()) ;
        
        debug2(list);
        System.out.println(" \n");
        //apply flatmap to create a new stream of Strings
        System.out.println("Step#2:apply flatmap   to create a new stream of Strings from Stream of :set Of Strings of books:");
        Stream<String> streamOfStrings =streamSetOfStrings.flatMap(x -> x.stream())  ; //Stream<String>
        
        debug3(list);
        
        System.out.println(" \n");
        System.out.println("Step#3:apply distinct after flatmap a new DISTINCT stream of Strings:");
        
        Stream<String> streamOfDistinctStrings = streamOfStrings.distinct();
        
        debug4(list);
        
        System.out.println(" \n");
        System.out.println("Step#4:apply collect after  DISTINCT to getlist of Strings from DISTNCT Stream of Strings:");
        streamOfDistinctStrings.collect(Collectors.toList());
   
        debug5(list);
	}


	private static void debug5(List<Student> list) {
		List<String> listOfStringsTemp =list.stream().map(x -> x.getBook()).flatMap(x -> x.stream()).distinct().collect(Collectors.toList());
        listOfStringsTemp.forEach(System.out::println);
	}
	private static void debug4(List<Student> list) {
		Stream<String> streamSetOfStringsTemp =list.stream().map(x -> x.getBook()).flatMap(x -> x.stream()).distinct() ;
        streamSetOfStringsTemp.forEach(System.out::println);//Stream<Set<String>>
	}

	private static void debug3(List<Student> list) {
		Stream<String> streamSetOfStringsTemp =list.stream().map(x -> x.getBook()).flatMap(x -> x.stream()) ;
        streamSetOfStringsTemp.forEach(System.out::println);//Stream<Set<String>>
	}




	private static void debug2(List<Student> list) {
		Stream<Set<String>> streamSetOfStringsTemp = list.stream().map(x -> x.getBook()) ;
        streamSetOfStringsTemp.forEach(System.out::println);//Stream<Set<String>>
	}
	
	private static void debug1(List<Student> list) {
		 Stream<FlatMapExample.Student> streamOfStudents = list.stream() ;
		 streamOfStudents.forEach(System.out::println);//Stream<Set<String>>
	}


	
	
	class Student {

	    private String name;
	    private Set<String> book;

	    public void addBook(String book) {
	        if (this.book == null) {
	            this.book = new HashSet<>();
	        }
	        this.book.add(book);
	    }
	    public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Set<String> getBook() {
			return book;
		}
		public void setBook(Set<String> book) {
			this.book = book;
		}
		@Override
		public String toString() {
			return "Student [name=" + name + ", book=" + book + "]";
		}
		
	}    

}
	


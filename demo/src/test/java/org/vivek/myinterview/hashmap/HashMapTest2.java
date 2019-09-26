/**
 * 
 */
package org.vivek.myinterview.hashmap;

import java.util.HashMap;

/**
 * @author Vivek
 *
 */
public class HashMapTest2 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    HashMap<Employee, String> hm = new HashMap<Employee, String>();
    hm.put(new Employee("a"), "emp1");
    hm.put(new Employee("b"), "emp2");
    hm.put(new Employee("a"), "emp1 OVERRIDDEN");

    System.out.println("HashMap's data> " + hm);
    System.out.println("HashMap's size> " + hm.size());
    System.out.println(hm.get(new Employee("a")));
    System.out.println(hm.get(new Employee("b")));
    /*
     * OUTPUT
     * 
     * HashMap's data> {Employee[ name=b] =emp2, Employee[ name=a] =emp1 OVERRIDDEN, Employee[
     * name=a] =emp1} HashMap's size> 3 null
     * 
     * 
     * Buckets= As hashCode() method is overridden perfectly, 2 bucket locations will be used.
     * 
     * Put As equals() method is not present, the same key "a" wont be updated and size will be 3,
     * 
     * get()=we won’t be able to get object.
     */


  }

  static class Employee {

    private String name;

    public Employee(String name) { // constructor
      this.name = name;
    }

    @Override
    public int hashCode() {
      return (this.name == null ? 0 : this.name.hashCode());
    }

    // no equals() method


    @Override
    public String toString() {
      return "Employee[ name=" + name + "] ";
    }

  }
}

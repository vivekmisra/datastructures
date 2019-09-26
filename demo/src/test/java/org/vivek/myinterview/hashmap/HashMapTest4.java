/**
 * 
 */
package org.vivek.myinterview.hashmap;

import java.util.HashMap;

/**
 * @author Vivek
 *
 */
public class HashMapTest4 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    HashMap<Employee, String> hm=new HashMap<Employee, String>();
    hm.put(new Employee("a"), "emp1");
    hm.put(new Employee("b"), "emp2");
    hm.put(new Employee("a"), "emp1 OVERRIDDEN");
    
    System.out.println("HashMap's data> "+hm);
    System.out.println("HashMap's size> "+hm.size());
    System.out.println(hm.get(new Employee("a")));
    System.out.println(hm.get(new Employee("b")));

  }
static class Employee {
    
    private String name;
    
    public Employee(String name) { // constructor
           this.name = name;
    }
    
    @Override
    public int hashCode(){
           return (this.name==null ? 0: this.name.hashCode() );       
    }
 
    @Override
    public boolean equals(Object obj){    
           Employee emp=(Employee)obj;
           return (emp.name==this.name || emp.name.equals(this.name));       
    }
 
    @Override
    public String toString() {
           return "Employee[ name=" + name + "] ";
    }
 
}
}

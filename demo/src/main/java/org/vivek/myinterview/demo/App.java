package org.vivek.myinterview.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class App {

	static class A {
		void printName() {
          System.out.println("A");
		}
	}

	static class B extends A {
		void printName() {
			System.out.println("B");
		}

	}

	static class C extends B {
		void printName() {
			System.out.println("C");
		}
	}

	public static void main(String[] args) {
		/*B b = new B();
		C c = new C();
		b = c;
		newPrint(b);*/
		int x =3&5;
		
		int y= 3|5;
		
		System.out.println("x="+x +",y="+ y);
		Set<Object> set = new HashSet();
		set.add(new String("test"));
		set.add("test");
		set.add(new A());
		set.add(new A());
		System.out.println("size of set="+set.size());
		A a1 = new B();
		A a2 = new A();
		B b = (B)a2;
		b.printName();
		
	}
	
	public static void newPrint(A a){
		a.printName();
	}

}

package org.vivek.myinterview.demo;

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

	}
	
	public static void newPrint(A a){
		a.printName();
	}

}

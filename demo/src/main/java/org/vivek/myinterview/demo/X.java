package org.vivek.myinterview.demo;

public class X {

	public static void main(String[] args) {
		try{
			bmethod();
			System.out.println("a");
		}catch(Exception e){
			System.out.println("b");
		}finally{
			System.out.println("c");
		}
		System.out.println("d");
	}
	
	public static void bmethod(){
		
	}

}

package org.vivek.myinterview.strings.problems;
public class PalindromeDeterminer {

	private String pal;
	static int size;

	  static int count;

	  static char[] charArray;
	public PalindromeDeterminer() {
		
	}

	
	public boolean isPalindrome(String s) {
		pal= s.toUpperCase();
		if (pal.length() <= 1) {
			return true;
		}

		char first = pal.charAt(0);//first
		
		char last = pal.charAt(s.length() - 1);//last
		
	
		if (Character.isLetter(first) && Character.isLetter(last)) {
			if (first != last) {
				
				return false;
			} else {
				String sub = pal.substring(1, pal.length() - 1);
			
				return isPalindrome(sub);
			} // if
		} else if (!Character.isLetter(first)) {
			String sub =s.substring(1);
			
			return isPalindrome(sub);
		} else {
			String sub =s.substring(0, s.length() - 1);
			System.out.println("**" );
			return isPalindrome(sub);
		}
		
		}
	
	
	public boolean checkPalindrome(String s,int leftSide,int rightSide) {
		
		if(rightSide <= leftSide){
			
			return true;
		}else if (s.charAt(leftSide) != s.charAt(rightSide)){
			return false;
		}else{
			return checkPalindrome( s,leftSide+1,rightSide+1);
		}
		
		
	
	}
	
	 public static boolean isPalindrome(int number) {
	        if(number == reverse(number)){
	            return true;
	        }
	        return false;
	    }
	 
	     
	    private static int reverse(int number){
	        int reverse = 0;
	     
	        while(number != 0){
	        	int a =  reverse*10;//Step1:multiply appended by 10 so that in step2 last digit( from step1)an be added to tenth place
	        	int b = number%10;//Get last digit Step 1
	          reverse = a + b;//append it Step2
	          number = number/10;
	        }
	             
	        return reverse;
	    }

	


	public String getPal() {
		return this.pal;
	}
	
	public static boolean isPalindromeIterative(String s){
		if(s==null||s.length()==0) return false;
 
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s);
 
		for(int i = 0; i < s.length() ; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
				return false;
			}
		}
 
		return true;
	}
 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeDeterminer p = new PalindromeDeterminer();
		//System.out.println(p.toString() + ":=:" + p.isPalindrome("Able was I ere I saw Elba"));
		String s = "abba";
		int rightSide = s.length()-1;
		boolean result = p.isPalindrome(s);
		System.out.println("result ="+ result );
		
		result = p.isPalindromeIterative(s);
		System.out.println("result ="+ result );
		//boolean result2 = p.isPalindrome(7447);
		boolean result2 = p.isPalindrome(127);
		System.out.println("result2 ="+ result2 );
		 size = s.length();
		
	}

	public String toString() {
		return this.pal;
	}
	

}

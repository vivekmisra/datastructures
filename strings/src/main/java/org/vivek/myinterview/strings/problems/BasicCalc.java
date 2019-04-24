package org.vivek.myinterview.strings.problems;

public class BasicCalc {

	public static void main(String[] args) {
		int res1= calculate("3+2*2");
		System.out.println(res1);;
	}
	
	public static int calculate(String s) {
        int ans = 0, tmp = 0, sign = 1;
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(Character.isDigit(c)) {
            	tmp = 10 * tmp + (c - '0');
            }
            else {
                if(c == '+' || c == '-') {
                    ans =ans+ tmp * sign;  //add it to answer
                    tmp = 0;
                    if(c=='-') {
                    	sign = -1 ;
                    }else {
                    	sign = 1 ;
                    }
                  //  sign = c == '-' ? -1 : 1;  //change sign if needed
                }
                else if(c == '*' || c == '/') {
                    int next = 0;
                    while(i + 1 < s.length() && (Character.isDigit(s.charAt(i + 1)) || s.charAt(i + 1) == ' ')) {
                        if(Character.isDigit(s.charAt(++i))) {
                        	next = 10 * next + (s.charAt(i) - '0'); //get next number
                        }
                    }
                    tmp = c == '*' ? tmp * next : tmp / next; //do the math
                }
            }
        }
        return ans + tmp * sign;
    }

}

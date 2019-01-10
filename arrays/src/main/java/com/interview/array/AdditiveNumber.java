package com.interview.array;

import java.math.BigInteger;

/**
 * Date 04/24/2016
 * @author Tushar Roy
 *
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers.
 * Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 *
 * https://leetcode.com/problems/additive-number/
 */
public class AdditiveNumber {
	
	public static void main(String args[]) {
		boolean flag = isAdditiveNumber2("199100199");
		System.out.println("flag="+flag);
	}

    public static boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 0; i <= num.length()/2; i++) {
            if (num.charAt(0) == '0' && i > 0) {
                break;
            }
            BigInteger x1 = new BigInteger(num.substring(0, i + 1));
            //make sure remaining size is at least size of first and second integer.
            for (int j = i + 1; Math.max(i, j - (i + 1)) + 1 <= num.length() - j - 1 ; j++) {
                if (num.charAt(i + 1) == '0' && j > i + 1) {
                    break;
                }
                BigInteger x2 = new BigInteger(num.substring(i + 1, j + 1));
                if (isValid(num, j + 1, x1, x2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(String num, int start, BigInteger x1, BigInteger x2) {
        if (start == num.length()) {
            return true;
        }
        BigInteger x3 = x1.add(x2);
        //if num starts with x3 from offset start means x3 is found. So look for next number.
        return num.startsWith(x3.toString(), start) && isValid(num, start + x3.toString().length(), x2, x3);
    }
    
    public static boolean isAdditiveNumber2(String s) {
        int n = s.length();
        for (int i=1; i<n; i++) {
            for (int j=i+1; j<n; j++) {
            	 System.out.println("*******************************");
                System.out.println("i=" +i + ",j="+j);
                System.out.println("a=\"199100199.\"substring(0,"+ i+")");
                long a = parse(s.substring(0, i));
                System.out.println("a=" +a);
                long b = parse(s.substring(i, j));
                System.out.println("a=\"199100199.\"substring("+i+","+ j+")");
                System.out.println("b=" +b);
                if (a == -1 || b == -1) continue;
                if (dfs(s.substring(j), a, b))   return true;
            }
        }
        return false;
    }
    
    static boolean dfs(String s, long a, long b) {
        if (s.length() == 0)    return true;
        System.out.println("Inside dfs(String "+ s+", long "+ a+", long "+ b+")");
        for (int i=1; i<=s.length(); i++) {
            long c = parse(s.substring(0, i));
            System.out.println("a=" +a +",b="+b +",c="+c);
            System.out.println("c-a=" +(c-a) + ", diff="+ (c-a == b));
            if (c == -1)    continue;
            if (c-a == b && dfs(s.substring(i), b, c)) {
                return true;
            }
        }
        return false;
    }
    
    static long parse(String s) {
        if (!s.equals("0") && s.startsWith("0"))    return -1;
        long result = 0;
        try {
            result = Long.parseLong(s);
        } catch (NumberFormatException e) {
            return -1;
        }
        return result;
    }
}

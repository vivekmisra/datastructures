package org.vivek.myinterview.strings.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public ValidParentheses() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		//key as opening and value as closing
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	   // String s  ="()[]{}";
	    String s  ="{[]}";
		boolean valid = isValid(map, s);
		System.out.println("valid="+valid);

	}

	private static boolean isValid(Map<Character, Character> map, String s) {
		Stack<Character> stack = new Stack<Character>();
	 
		for (int i = 0; i < s.length(); i++) {
			//extract each char from input string 
			char curr = s.charAt(i);
	        //check if that char exists as key in map-
			//only opening brackets are stored as key in map
			if (map.keySet().contains(curr)) {
				stack.push(curr);
				//check if that  char exists as value
				//only closing brackets are stored as value in map
			} else if (map.values().contains(curr)) {
				//if exist-get value of map with key as peeking stack
				//the value it should match cuurrent closing 
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();//pop its coreesponding opening
				} else {
					//if u still see values,it means brackey string is unbalanced
					return false;
				}
			}
		}
	 
		return stack.empty();
	}

}

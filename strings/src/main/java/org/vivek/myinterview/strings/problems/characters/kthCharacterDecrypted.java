package org.vivek.myinterview.strings.problems.characters;

import java.util.HashMap;
import java.util.Map;

public class kthCharacterDecrypted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input= "ab4c12ed3";
		 int k = 21;
		 char c = findKthCharacter(input,k);
				

	}

	private static char findKthCharacter(String input,int k) {
		char c = Character.MIN_VALUE;
		int indx=0;
		int val = 0;
		int sum =0;
		Map<Integer,String> m = new HashMap<Integer,String>();
		String substr = new String();
		int key =0;
		String freq = null;
		for(int i=0;i<input.length();i++){
			c = input.charAt(i);
			if(Character.isDigit(c)){
				System.out.println("numeric char="+Character.getNumericValue(c));
				 freq = freq +c;
			}else{
				 if(freq !=null){
						
					 Integer rcount = Integer.valueOf(freq);
				 }
				freq=null;
			}
			indx++;
			
		     System.out.println("indx="+indx);
			
				
			
		     if(freq !=null){
				
			 Integer rcount = Integer.valueOf(freq);
				
				val = (indx-1)*rcount;
				System.out.println("val="+val);
				sum =sum +val;
				System.out.println("sum="+sum);
				if(sum>=k){
					System.out.println("sum>=k="+sum);
					
					  String s = m.get((key));
					 int index = k-key;
					System.out.println("s="+s);
				
					m.put(key ,substr+c);
				
				indx=0;
				rcount=0;
				}
			}
		}
		
		return c;
	}

}

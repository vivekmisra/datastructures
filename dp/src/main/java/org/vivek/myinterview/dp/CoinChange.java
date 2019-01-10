package org.vivek.myinterview.dp;

public class CoinChange {

	public CoinChange() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static int change(int amount,int[] coinvalues){
		
		int[] amountCombinations = new int[amount+1];
		
		for(int coinValue : coinvalues){
			amountCombinations[0]=1;
			//loop theu  amountCombinations
			for(int i=1; i< amountCombinations.length;i++){
				if (i >=coinValue){
					amountCombinations[i] = amountCombinations[i]+amountCombinations[i-coinValue];
				}
			}
			
		}
		
		return amountCombinations[amount];
		
	}
	
	public static void main(String [] args){
		int[] coinvalues = new int[] {1,2,5};
		 System.out.println(change(12, coinvalues));
	}

}

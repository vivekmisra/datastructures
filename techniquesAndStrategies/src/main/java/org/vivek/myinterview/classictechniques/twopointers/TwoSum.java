package org.vivek.myinterview.classictechniques.twopointers;

public class TwoSum {

	public TwoSum() {
		// TODO Auto-generated constructor stub
	
	}
	
	public static void main(String[] args) {
		int [] numbers = {2,7,11,15};
		int target =9;
		int [] nums = twoSum2( numbers,  target);
		printArray(nums);

	}
	
	public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length -1;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[left] + numbers[right] > target){
                right--;
            } else if(numbers[left] + numbers[right] < target){
               left++;
            } else {
                result[0] = ++left;
                result[1] = ++right;
                break;
            }
        }
        return result;
    }
	
	
	private static void printArray(int[] anArray) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < anArray.length; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(anArray[i]);
		}
		System.out.println(sb.toString());
	}

}

package org.vivek.myinterview.arrays.general.problems.slidingwindow;

public class FindMaxAverageInContiguousKSubArray {

	public static void main(String[] args) {
		FindMaxAverageInContiguousKSubArray fa = new FindMaxAverageInContiguousKSubArray();
		int nums[] = {1,12,-5,-6,50,3};
				
		double avg = fa.findMaxAverage(nums, 4);
		System.out.println("Max avg in subarray of length k="+ avg);

	}
	
	 public double findMaxAverage(int[] nums, int k) {
	        double sum=0;
	        for(int i=0;i<k;i++){
	            sum+=nums[i];
	        }
	        double res=sum;
	        for(int i=k;i<nums.length;i++){
	            sum=sum + nums[i]-nums[i-k];
	            res=Math.max(res,sum);
	        }
	        return res/k;
	    }

}

package org.vivek.myinterview.arrays.general.problems.slidingwindow;

public class SlidingWindowSum {

	public SlidingWindowSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int arr[] = {100, 200, 300, 400};
		System.out.println(bruteforce_maxSum(arr));
		System.out.println(maxSum(arr));


	}

	private static int bruteforce_maxSum(int[] arr) {
		int n= arr.length;
		int max_sum=0;
		int k=2;
		for(int i = 0; i < n-k+1; i++){    
		    int current_sum = 0;
		     
		    for(int j = 0; j < k; j++){        
		        current_sum = current_sum + arr[i+j];         
		    }
		    max_sum = Math.max(current_sum, max_sum);    // pick maximum sum 
		}
		return max_sum;
	}
	
	private static int maxSum(int[] arr) {
		int max_sum = 0, window_sum = 0; 
		int n= arr.length;
		int k=2;
		/* calculate sum of 1st window */
		for (int i = 0; i < k; i++)  window_sum += arr[i]; 
		/* slide window from start to end in array. */
		 
		for (int i = k; i < n; i++){ 
		    window_sum += arr[i] - arr[i-k];    // saving re-computation
		    max_sum = Math.max(max_sum, window_sum);
		}
		return max_sum;
	}

}

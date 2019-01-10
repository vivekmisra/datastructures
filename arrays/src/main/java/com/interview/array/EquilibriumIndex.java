package com.interview.array;

public class EquilibriumIndex {
	/*
	 * A[0] = -1 A[1] = 3 A[2] = -4 A[3] = 5 A[4] = 1 A[5] = -6 A[6] = 2 A[7] =
	 * 1
	 */
	// static int[] A = new int[] { -1,3,-4,5,1,-6,2,1};
	static int[] A = new int[] { 0, -2, 3, 2, -7, 5, -6, 2 };

	// static int[] A = new int[] { -7,1,5,2,-4,3,0};
	public EquilibriumIndex() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int ind = equilibrium(A);
		//int ind1 = findEquilibriumIndex(A);
		int ind3=getEquilibrium(A);

	}
	
	public static int getEquilibrium(int[] A) {
        long[] sums = generateSums(A);
        long lowSum = 0L;
        int res = -1;
        for (int i = 0; i < A.length; i++) {
            if (lowSum == sums[i+1]) {
                res = i;
                break;
            }
            lowSum += A[i];
        }
        return res;
    }

    // I used long to handle sums greater than 32 bits
    public static long[] generateSums(int[] A) {
        // I added another index (default value is 0) to handle the last value (E.G. the sum of previous elements is 0, so the equilibrium index should be the last value because there are no other items after it. I used the newly added index to handle it.)
        long[] res = new long[A.length+1];
        for (int i = A.length-1; i >= 0; i--) {
            res[i] = i+1 == A.length ? A[i] : res[i+1]+A[i];
        }
        return res;
    }

	static int equilibrium(int arr[]) {
		int n = arr.length;
		int sum = 0; // initialize sum of whole array
		int leftsum = 0; // initialize leftsum

		/* Find sum of the whole array */
		for (int i = 0; i < n; ++i){
			sum += arr[i];
		}

		for (int i = 0; i < n; ++i) {
			sum -= arr[i]; // sum is now right sum for index i

			if (leftsum == sum){
				return i;
			}

			leftsum += arr[i];
		}

		/* If no equilibrium index found, then return 0 */
		return -1;
	}

	
}

package org.vivek.myinterview.arrays.numbers;

public class ProductArray {
	public static int[] findProduct(int[] arr) {
		int n = arr.length;
		int i, temp = 1;

		/* Allocate memory for the product array */
		int product[] = new int[n];

		/* Initialize the product array as 1 */
		for (int j = 0; j < n; j++) {
			product[j] = 1;
		}

		/*
		 * In this loop, temp variable contains product of elements on left side
		 * excluding arr[i]
		 */
		for (i = 0; i < n; i++) {
			product[i] = temp;
			temp = temp*arr[i];
		}

		/* Initialize temp to 1 for product on right side */
		temp = 1;

		/*
		 * In this loop, temp variable contains product of elements on right side
		 * excluding arr[i]
		 */
		for (i = n - 1; i >= 0; i--) {
			System.out.println("product["+i+"]="+product[i]);
			product[i] =product[i]* temp;
			temp = temp*arr[i];
		}

		return product;
	}

	public static void main(String args[]) {

		//int[] arr = { -1, 2, -3, 4, -5 };
		int[] arr = { 5,2,3 };
		System.out.print("Array before product: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		int[] prodArray = findProduct(arr);

		System.out.print("Array after product: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(prodArray[i] + " ");
		}
		System.out.println();
	}
}

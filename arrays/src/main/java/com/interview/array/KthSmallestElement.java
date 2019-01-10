package com.interview.array;

public class KthSmallestElement {

	public int findkthSmallestElement(int[] arrA, int k) {
		k = k - 1; // since array index starts with 0
		//return kSmall(arrA, 0, arrA.length - 1, k);
		return kSmallest2(arrA, 0, arrA.length - 1, k);
	}

	public int kSmall(int[] arrA, int start, int end, int k) {
		int left = start;
		int right = end;
		int pivot = start;
		while (left <= right) {
			while (left <= right && arrA[left] <= arrA[pivot])
				left++;
			while (left <= right && arrA[right] >= arrA[pivot])
				right--;
			if (left < right) {
				swap(arrA, left, right);
				left++;
				right--;
			}
		}
		swap(arrA, pivot, right);
		if (pivot == k)
			return arrA[pivot];// if pivot is kth element , return
		else if (pivot < k)
			// if pivot is less than k, then kth element will be on the right
			return kSmall(arrA, pivot + 1, end, k);
		else
			// if pivot is greater than k, then kth element will be on the right
			return kSmall(arrA, start, pivot - 1, k);
	}

	/*public void swap(int[] arrA, int a, int b) {
		int x = arrA[a];
		arrA[a] = arrA[b];
		arrA[b] = x;
	}*/
	
	
	
	
	public  int kSmallest2(int a[], int start, int end,int k) {
		int leftCursor=start;
		int rightCursor = end;
		int pivotIndex = start;
		int maxIndex = a.length-1;
		System.out.println("*** pivot="+ a[pivotIndex]+" *****");
		while (leftCursor < rightCursor) {
			System.out.println("*** start*****");
			while (a[leftCursor] < a[pivotIndex]) {
				System.out.println("*** a[leftCursor] < a[pivotIndex]) => "+  a[leftCursor] +"<" + a[pivotIndex]+" *****");
				leftCursor++;
				System.out.println("*** leftCursor++ =>  a[leftCursor]= "+  a[leftCursor] );
				System.out.println("*** Is a[leftCursor] < a[pivotIndex]) => "+  (a[leftCursor] <  a[pivotIndex]) +" *****");
				
			}
			while (a[rightCursor] > a[pivotIndex]) {
				System.out.println("*** a[rightCursor] >a[pivotIndex]) => "+  a[rightCursor] +">" +  a[pivotIndex]+" *****");
				rightCursor--;
				System.out.println("*** rightCursor-- =>  a[rightCursor]= "+  a[rightCursor] );
				System.out.println("*** Is a[rightCursor] >a[pivotIndex]) => "+  (a[rightCursor] >  a[pivotIndex]) +" *****");
				
			}
		
			System.out.println("Before swapping...");
			printArray(a, leftCursor, rightCursor, pivotIndex);
			swap(a, leftCursor, rightCursor);
			System.out.println("After swapping...");
			printArray(a, leftCursor, rightCursor, pivotIndex);
			System.out.println("*** end*****");
		
		}
		System.out.println("*** k="+k+" *****and pivotIndex="+pivotIndex);
		
		if (pivotIndex == k){
			return  a[pivotIndex];// if pivot is kth element , return
		}else if (pivotIndex < k){
			System.out.println("***pivotIndex < k==>*****"+ pivotIndex + "<" + k +"");
			System.out.println("*** partition(a,"+(pivotIndex + 1)+", "+end+", "+k+")");
			return kSmallest2(a, pivotIndex + 1,end, k);
		}else{
			// if pivot is greater than k, then kth element will be on the right
			System.out.println("***pivotIndex > k==>*****"+ pivotIndex + ">" + k +"");
			System.out.println("*** partition(a,"+ start+", "+(pivotIndex - 1)+", "+k+")");
			return kSmallest2(a, start, pivotIndex - 1, k);		
		}
	}
	
	public  void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	public static void main(String args[]) {
		int[] arrA = { 2, 3, 11, 16, 27, 4, 15, 9, 8 };
		KthSmallestElement k = new KthSmallestElement();
		int n=3;
		int a =( arrA.length - n) +1;
		printArray(arrA);
		int x = k.findkthSmallestElement(arrA, a);
		
		System.out.print("The " + n + "th largest element is : " + x);
	}
	
	public  void printArray(int[] a, int leftCursor, int rightCursor, int pivotIndex) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		if (leftCursor >= 0) {
			System.out.print("leftCursor=" + leftCursor + " ,a[" + leftCursor + "]=" + a[leftCursor]);
		}
		if (rightCursor >= 0) {
			System.out.print(" ,rightCursor=" + rightCursor + " ,a[" + rightCursor + "]=" + a[rightCursor]);
		}
		System.out.print(" ,pivotIndex=" + rightCursor + " ,a[" + pivotIndex + "]=" + a[pivotIndex]);
	}
	public static void printArray(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}

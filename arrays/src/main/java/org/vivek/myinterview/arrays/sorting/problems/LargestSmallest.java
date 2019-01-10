package org.vivek.myinterview.arrays.sorting.problems;

public class LargestSmallest {
	static Integer[] a = new Integer[] { 1, 5, 7, 8, 11,13 };
	public LargestSmallest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kthLargest(a);
	}

	static int kthLargest(Integer a[] ){
		int count =0;
		for (int i = 0; i < a.length; i++) {
			++count;
			System.out.println("i="+ i +",count="+ count);
		}
		return count;
	}
			
}

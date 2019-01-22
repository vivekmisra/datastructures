package org.vivek.myinterview.priorityqueues.problems;

import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {

	public KthSmallestElementSortedMatrix() {

	}

	public static void main(String[] args) {
		int[][] matrix = fillMatrix(3);
		System.out.println(kSmallest(matrix, 8));
	}

	public static int kSmallest(int[][] matrix, int k) {
		// 1-create the result container
		int res = 0;

		// 3-construct PQ with comparator implemented
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		int n = matrix.length;

		// 4-insert in PQ ,apply filter if any
		for (int j = 0; j <= n - 1; j++) {

			int x = 0;
			int y = j;
			int val = matrix[x][y];
			Tuple t = new Tuple(x, y, val);
			System.out.println("Added :" + t);
			pq.offer(t);
		}

		// 5-poll PQ in result container,apply filter if any
		for (int i = 0; i < k - 1; i++) {
			Tuple t = pq.poll();
			System.out.println("Polled :" + t);

			if (t.x == n - 1) {
				continue;
			}

			int x = t.x + 1;
			int y = t.y;
			int val = matrix[x][y];
			t = new Tuple(x, y, val);
			pq.offer(t);
			System.out.println("Added :" + t);
		}
		res = pq.poll().val;
		return res;
	}

	// 2-create a ds container to store inputs
	static class Tuple implements Comparable<Tuple> {
		int x, y, val;

		public Tuple(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Tuple [x=" + x + ", y=" + y + ", sum=" + val + "]";
		}

		@Override
		public int compareTo(Tuple that) {

			return this.val - that.val;
		}

	}

	/*
	 * [ 1, 5, 9], [10, 11, 13], [12, 13, 15]
	 */
	private static int[][] fillMatrix(int n) {
		int[][] arr = new int[n][n];
		arr[0][0] = 1;
		arr[0][1] = 5;
		arr[0][2] = 9;

		arr[1][0] = 10;
		arr[1][1] = 11;
		arr[1][2] = 13;

		arr[2][0] = 12;
		arr[2][1] = 13;
		arr[2][2] = 151;

		return arr;
	}
}

package org.vivek.myinterview.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TreeNode;

public class AverageOfLevels {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
	
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		BTreePrinter.printNode(root);
		AverageOfLevels aol = new AverageOfLevels();
		List<Double> aolBybfsList = aol.findAverageOfLevelsByBFS(root);
		System.out.print("aolByBFS:");
		for(double aolByBFS : aolBybfsList){
			System.out.print(aolByBFS);
			System.out.print(",");
		}
		System.out.println();;
		List<Double> aolBydfsList = aol.findAverageOfLevelsByDFS(root);
		System.out.print("aolByDFS:");
		for(double aolByDFS : aolBydfsList){
			System.out.print(aolByDFS);
			System.out.print(",");
		}
		System.out.println();;
	}

	public List<Double> findAverageOfLevelsByBFS(TreeNode root) {
		List<Double> list = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			double sum = 0;
			for (int i = 0; i < count; i++) {
				TreeNode cur = queue.poll();
				sum += cur.val;
				if (cur.left != null)
					queue.offer(cur.left);
				if (cur.right != null)
					queue.offer(cur.right);
			}
			list.add(sum / count);
		}
		return list;
	}

	class Node {
		double sum;
		int count;

		Node(double d, int c) {
			sum = d;
			count = c;
		}
	}

	public List<Double> findAverageOfLevelsByDFS(TreeNode root) {
		List<Node> temp = new ArrayList<>();
		helper(root, temp, 0);
		List<Double> result = new LinkedList<>();
		for (int i = 0; i < temp.size(); i++) {
			result.add(temp.get(i).sum / temp.get(i).count);
		}
		return result;
	}

	public void helper(TreeNode root, List<Node> temp, int level) {
		if (root == null)
			return;
		if (level == temp.size()) {
			Node node = new Node((double) root.val, 1);
			temp.add(node);
		} else {
			temp.get(level).sum += root.val;
			temp.get(level).count++;
		}
		helper(root.left, temp, level + 1);
		helper(root.right, temp, level + 1);
	}

}

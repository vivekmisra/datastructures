package org.vivek.myinterview.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayProblemsUsingDFSBacktracking {
//@formatter:off
	public static void main(String[] args) {
		ArrayProblemsUsingDFSBacktracking dfs = new ArrayProblemsUsingDFSBacktracking();
		
		int [] nums = {1,2,3};
		List<List<Integer>> subSetList =dfs.subsets(nums);
		System.out.print("subSetList[");	
		subSetList.forEach(subSet->System.out.print(subSet+","));	
		System.out.println("]");
		//////////////////////////////////////////////
		int [] dupNums = {1,2,2};
		List<List<Integer>> subSetListUnique =dfs.subsetsWithDup(dupNums);
		System.out.print("subSetListUnique[");	
		 subSetListUnique.forEach(subSet->System.out.print(subSet+","));	
		System.out.println("]");
		//////////////////////////////////////////////
		List<List<Integer>> permutedList =dfs.permute(nums);
		System.out.print("permutedList[");	
		permutedList.forEach(permuted->System.out.print(permuted+","));	
		System.out.println("]");
		///////////////////////////////////////////
		List<List<Integer>>permutedUniqueList =dfs.permuteUnique(dupNums);
		System.out.print("permutedUniqueList[");	
		permutedUniqueList.forEach(permuted->System.out.print(permuted+","));	
		System.out.println("]");
		/////////////////////////////////////////

	}
	
	
	/*
	 * Subsets : https://leetcode.com/problems/subsets/
	 * 78. Subsets
		Medium
		
		Given a set of distinct integers, nums, return all possible subsets (the power set).
		
		Note: The solution set must not contain duplicate subsets.
		
		Example:
		
		Input: nums = [1,2,3]
		Output:
		[
		  [3],
		  [1],
		  [2],
		  [1,2,3],
		  [1,3],
		  [2,3],
		  [1,2],
		  []
		]
	 */

		public List<List<Integer>> subsets(int[] nums) {
		    List<List<Integer>> list = new ArrayList<>();
		    Arrays.sort(nums);
		    backtrack_subsets(list, new ArrayList<>(), nums, 0);
		    return list;
		}

		private void backtrack_subsets(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
		    list.add(new ArrayList<>(tempList));
		    for(int i = start; i < nums.length; i++){
		        tempList.add(nums[i]);
		        backtrack_subsets(list, tempList, nums, i + 1);
		        tempList.remove(tempList.size() - 1);
		    }
		}
		
		/*
		 * Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/
		 * Given a collection of integers that might contain duplicates, nums, 
		 * return all possible subsets (the power set).
			
			Note: The solution set must not contain duplicate subsets.
			
			Example:
			
			Input: [1,2,2]
			Output:
			[
			  [2],
			  [1],
			  [1,2,2],
			  [2,2],
			  [1,2],
			  []
			]
		 */

		public List<List<Integer>> subsetsWithDup(int[] nums) {
		    List<List<Integer>> list = new ArrayList<>();
		    Arrays.sort(nums);
		    backtrack_subsetsWithDup(list, new ArrayList<>(), nums, 0);
		    return list;
		}

		private void backtrack_subsetsWithDup(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
		    list.add(new ArrayList<>(tempList));
		    for(int i = start; i < nums.length; i++){
		        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
		        tempList.add(nums[i]);
		        backtrack_subsetsWithDup(list, tempList, nums, i + 1);
		        tempList.remove(tempList.size() - 1);
		    }
		} 
		
		/*Subsets I passed with out sorting nums. Subsets II can be used exactly as subsets 1
		if we sort and use a hashset of lists instead of a list of lists.
		Below code is for Subsets II:
		*/

		   public List<List<Integer>> subsetsWithDup2(int[] nums) {
		           Set<List<Integer>> result = new HashSet<>();
		           Arrays.sort(nums);
		           backTrack_subsetsWithDup2(result,new ArrayList<Integer>(),nums,0);
		           return new ArrayList<List<Integer>>(result);
		    }

		    public void backTrack_subsetsWithDup2(Set<List<Integer>> result,List<Integer> temp,int[] nums,int start){

		          result.add(new ArrayList<>(temp));
		           for(int i=start;i<nums.length;i++){
		               temp.add(nums[i]);
		               backTrack_subsetsWithDup2(result,temp,nums,i+1);
		               temp.remove(temp.size()-1);
		           }
		    }
		
		
		
		/*
		 * Permutations : https://leetcode.com/problems/permutations/
		 * Given a collection of distinct integers, return all possible permutations.

			Example:
			
			Input: [1,2,3]
			Output:
			[
			  [1,2,3],
			  [1,3,2],
			  [2,1,3],
			  [2,3,1],
			  [3,1,2],
			  [3,2,1]
			]
		 */

		public List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrack_permute(list, new ArrayList<>(), nums);
		   return list;
		}

		private void backtrack_permute(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		   if(tempList.size() == nums.length){
		      list.add(new ArrayList<>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) continue; // element already exists, skip
		         tempList.add(nums[i]);
		         backtrack_permute(list, tempList, nums);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		} 
		
		/*
		 * Permutations II (contains duplicates) : https://leetcode.com/problems/permutations-ii/
		 * 47. Permutations II
			Medium
			
			Given a collection of numbers that might contain duplicates, return all possible unique permutations.
			
			Example:
			
			Input: [1,1,2]
			Output:
			[
			  [1,1,2],
			  [1,2,1],
			  [2,1,1]
			]
		 */

		public List<List<Integer>> permuteUnique(int[] nums) {
		    List<List<Integer>> list = new ArrayList<>();
		    Arrays.sort(nums);
		    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		    return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
		    if(tempList.size() == nums.length){
		        list.add(new ArrayList<>(tempList));
		    } else{
		        for(int i = 0; i < nums.length; i++){
		        	/*
		        	 * used flag list is a "static" variable in a recursive path from root to leaf. and the repeated num shouldn't appear in the child node of same direct parent. SO
						if used[i] == true, we skip it, and choose the later num in nums;
						if i > 0 && nums[i] == nums[i -1] represent we encounter repeat num, OK, attention please: we now visiting nums[i]
						when nums[i - 1] is the parent node of the current node nums[i] in the recursive path, then used[i - 1] should be "true", see tips 0.
						when nums[i - 1] not in the recursive path, and i - 1 < i, 
						==>it only can be the "brother node" of current node nums[i - 1],i.e used[i - 1] == false. 
						when used[i - 1] == false, that means nums[i-1] and nums[i] are the brother with same parent. 
						if a parent has two children same, this will make the permutation result repeat. eg. nums = [1, 2, 2].
						1
						/ \
						2 2
						/ /
						2 2
						above:for the second path 1->2->2, is repeated!
		        	 */
		            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
		            used[i] = true; 
		            tempList.add(nums[i]);
		            backtrack(list, tempList, nums, used);
		            used[i] = false; 
		            tempList.remove(tempList.size() - 1);
		        }
		    }
		}
		/*
		 * Combination Sum : https://leetcode.com/problems/combination-sum/
		 * 39. Combination Sum
			Medium
			
			Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
			
			The same repeated number may be chosen from candidates unlimited number of times.
			
			Note:
			
			All numbers (including target) will be positive integers.
			The solution set must not contain duplicate combinations.
			Example 1:
			
			Input: candidates = [2,3,6,7], target = 7,
			A solution set is:
			[
			  [7],
			  [2,2,3]
			]
			Example 2:
			
			Input: candidates = [2,3,5], target = 8,
			A solution set is:
			[
			  [2,2,2,2],
			  [2,3,3],
			  [3,5]
			]
		 */

		public List<List<Integer>> combinationSum(int[] nums, int target) {
		    List<List<Integer>> list = new ArrayList<>();
		    Arrays.sort(nums);
		    backtrack_combinationSum(list, new ArrayList<>(), nums, target, 0);
		    return list;
		}

		private void backtrack_combinationSum(List<List<Integer>> list, List<Integer> tempList, int [] nums, int target, int start){
		    if(target < 0) return;
		    else if(target == 0) list.add(new ArrayList<>(tempList));
		    else{ 
		        for(int i = start; i < nums.length; i++){
		            tempList.add(nums[i]);
		            backtrack_combinationSum(list, tempList, nums, target - nums[i], i); // not i + 1 because we can reuse same elements
		            tempList.remove(tempList.size() - 1);
		        }
		    }
		}
		/*
		 * Combination Sum II (can't reuse same element) : https://leetcode.com/problems/combination-sum-ii/
		 * 40. Combination Sum II
			Medium

			Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
			
			Each number in candidates may only be used once in the combination.
			
			Note:
			
			All numbers (including target) will be positive integers.
			The solution set must not contain duplicate combinations.
			Example 1:
			
			Input: candidates = [10,1,2,7,6,1,5], target = 8,
			A solution set is:
			[
			  [1, 7],
			  [1, 2, 5],
			  [2, 6],
			  [1, 1, 6]
			]
			Example 2:
			
			Input: candidates = [2,5,2,1,2], target = 5,
			A solution set is:
			[
			  [1,2,2],
			  [5]
			]
		 */

		public List<List<Integer>> combinationSum2(int[] nums, int target) {
		    List<List<Integer>> list = new ArrayList<>();
		    Arrays.sort(nums);
		    backtrack_combinationSum2(list, new ArrayList<>(), nums, target, 0);
		    return list;
		    
		}

		private void backtrack_combinationSum2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
		    if(remain < 0) return;
		    else if(remain == 0) list.add(new ArrayList<>(tempList));
		    else{
		        for(int i = start; i < nums.length; i++){
		            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
		            tempList.add(nums[i]);
		            backtrack_combinationSum2(list, tempList, nums, remain - nums[i], i + 1);
		            tempList.remove(tempList.size() - 1); 
		        }
		    }
		} 
		
		/*
		 * Palindrome Partitioning : https://leetcode.com/problems/palindrome-partitioning/
		 * 131. Palindrome Partitioning
			Medium
			
			Given a string s, partition s such that every substring of the partition is a palindrome.
			
			Return all possible palindrome partitioning of s.
			
			Example:
			
			Input: "aab"
			Output:
			[
			  ["aa","b"],
			  ["a","a","b"]
			]
		 */

		public List<List<String>> partition(String s) {
		   List<List<String>> list = new ArrayList<>();
		   backtrack_partition(list, new ArrayList<>(), s, 0);
		   return list;
		}

		public void backtrack_partition(List<List<String>> list, List<String> tempList, String s, int start){
		   if(start == s.length())
		      list.add(new ArrayList<>(tempList));
		   else{
		      for(int i = start; i < s.length(); i++){
		         if(isPalindrome(s, start, i)){
		            tempList.add(s.substring(start, i + 1));
		            backtrack_partition(list, tempList, s, i + 1);
		            tempList.remove(tempList.size() - 1);
		         }
		      }
		   }
		}

		public boolean isPalindrome(String s, int low, int high){
		   while(low < high)
		      if(s.charAt(low++) != s.charAt(high--)) return false;
		   return true;
		} 

}

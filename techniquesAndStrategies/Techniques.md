    
# TWO-POINTER SEARCH  
## Same-directional Two pointer ##
###26. Remove Duplicates from Sorted Array
<pre>

	public static int[] removeDuplicates(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		int i = 0, j = 1;
		list.add(nums[0]);
		while (j < len) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
				list.add(nums[i]);
			}	 
	                j++;
		}
	 
		if (list.isEmpty())
			return null;
		int[] prunednums = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			prunednums[k] = list.get(k);
		}
		return prunednums;
	}
    Alternatively:
    public static int[] removeDuplicates(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		int i = 1, j = 1;
		list.add(nums[0]);
		while (j < len) {
			 //check if the element at the position current index - 1(previous) is the same as new arriving element
			//            if same then skip 
			//            if not,copy current at current index &move forward
			  if(nums[i-1]!=nums[j]) {
	            	nums[i]=nums[j];
	            	list.add(nums[i]);
	            	i++;
	          }
			 ++j;
		}
		if (list.isEmpty())
			return null;
		int[] prunednums = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			prunednums[k] = list.get(k);
		}
		return prunednums;
	}


</pre>
Generic :
<code>
<pre>

public static int removeDuplicates(int nums[], int k) {
		/*
		 * approach is to remain first k elements as it is . Now start from k'th index
		 * and check if the element at the position current index - k is the same as new
		 * arriving element then skip this element and continue with next element . here
		 * the condition nums[i-k]!=nums[j] is very important  because we
		 * have to look k steps backward in new updated array.
		 */
   int len = nums.length;
   if (len < k)
	 return len; // if array size is less than k then return the same
	int i=k,j=k;
    while(j<len){
      if(nums[i-k]!=nums[j]) {
          nums[i]=nums[j];
          i++;
      }
    ++j;
        }
     return i;
}

</pre>
</code>
###80. Remove Duplicates from Sorted Array II ###
[https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/ "80. Remove Duplicates from Sorted Array II")


## Opposite-directional Two pointer ##
Two pointer is usually used for searching a pair in the array. There are
cases the data is organized in a way that we can search all the result space
by placing two pointers each at the start and rear of the array and move
them to each other and eventually meet and terminate the search process.
The search target should help us decide which pointer to move at that step.
This way, each item in the array is guaranteed to be visited at most one
time by one of the two pointers, thus making the time complexity to be
O(n). 
Binary search used the technique of two pointers too, the left and
right pointer together decides the current searching space, but it erase of
half searching space at each step instead.

### 167. Two Sum II - Input array is sorted 
 Given an array of integers that is
already sorted in ascending order, find two numbers such that they add up
to a specific target number. 
The function twoSum should return indices ofthe two numbers such that they 
add up to the target, where index1 must
be less than index2. 
(LeetCode problem: 167. Two Sum II - Input array is sorted (easy).)[https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/ "167. Two Sum II - Input array is sorted")
Input : numbers = [ 2 , 7 , 1 1 , 1 5 ] , t a r g e t = 9
Output : [ 1 , 2 ]

Explanation : The sum o f 2 and 7 i s 9 . 

The r e for e index1 = 1 ,
index2 = 2 .
\n
Due to the fact that the array is sorted which means in the array [s,s1
..., e1, e], the sum of any two integer is in range of [s+s1, e1+e]. By placing
two pointers each start from s and e, we started the search space from the
middle of the possible range. [s+s1, s+e, e1+e]. Compare the target t with
the sum of the two pointers v1 and v2:
    1. t == v1 + v2: found
    2. v1 + v2 < t: we need to move to the right side of the space, then we
    increase v1 to get larger value.
    3. v1 + v2 > t: we need to move to the left side of the space, then we
    decrease v2 to get smaller value.
1 de f twoS
<pre>

	public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
		int left = 0;
		int right = numbers.length - 1;
        if (numbers == null || numbers.length < 2)
			return new int[] { 0, 0 };		
		while (left<right) {
			if (numbers[left] + numbers[right] > target) {
				right--;		
			} else if (numbers[left] + numbers[right] < target) {
				left++;
			} else {
				result[0] = left+1;
				result[1] = right+1;
				break;
			}
		}
		return result;
</pre>
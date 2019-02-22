package org.vivek.myinterview.strings.problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

;

public class BoldTag {

	public static void main(String[] args) {
		String s = "aaabbcc";
		String[] dict = { "aaa", "aab", "bc" };
		BoldTag bt = new BoldTag();
		s =bt.addBoldTag(s, dict);
		System.out.println(s);;

	}
	public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<>();
        for (String d : dict) {
        	int indx = -1;
        	//search d in s starting from index indx and get starting index
        	indx = s.indexOf(d, indx);
        	while (indx != -1) {//found in indx >-1
        		intervals.add(new Interval(indx, indx + d.length()));//add to bag
        		indx +=1;//increment and continue to check  if exists in next index
        		indx = s.indexOf(d, indx);//if indx >0,continue to add in bag
        	}
        }
        System.out.println(Arrays.toString(intervals.toArray()));
        intervals = merge(intervals);
        System.out.println(Arrays.toString(intervals.toArray()));
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervals) {
        	sb.append(s.substring(prev, interval.left));
        	sb.append("<b>");
        	sb.append(s.substring(interval.left, interval.right));
        	sb.append("</b>");
        	prev = interval.right;
        }
        if (prev < s.length()) {
        	sb.append(s.substring(prev));
        }
        return sb.toString();
    }
	//comparable
	static class Interval implements Comparable<Interval>{
		int left, right;
		public Interval(int s, int e) {
			left = s;
			right = e;
		}
		
		public String toString() {
			return "[" + left + ", " + right + "]" ;
		}

		@Override
		public int compareTo(Interval o) {
			// TODO Auto-generated method stub
			 return this.left -o.left;
		}

	
	}
	
	public  List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        //sort the comparable range object list
        Collections.sort(intervals);
        //get 
        int previousLeft = intervals.get(0).left;
        int previousRight = intervals.get(0).right;
        List<Interval> res = new ArrayList<>();
        //loop thru interval list
        for (Interval i : intervals) {
            if (i.left <= previousRight) {//if current left index is less  than previous right:
            	//then update previous right ie. extend it  (by updating previousright) by taking max of current & previousRight (previousLeft value is retained)
            	previousRight = Math.max(previousRight, i.right);//keep on extending right,by updating previpsright with max of current & previous
            } else {//mutually exclusive interval gets added in list
                res.add(new Interval(previousLeft, previousRight));
                previousLeft = i.left;//update /reset the previousRight
                previousRight = i.right;//update/reset the previousLeft
            }
        }
        res.add(new Interval(previousLeft, previousRight));//the residual left & right
        return res;
    }

}

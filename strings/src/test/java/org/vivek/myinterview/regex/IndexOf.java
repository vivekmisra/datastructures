package org.vivek.myinterview.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class IndexOf {

	public static void main(String[] args) {
		
		String s = "aaabbcc";
		String[] dict = { "aaa", "aab", "bc" };
		String bold = addBoldTag( s,  dict) ;
		System.out.println(bold);
      
	}
	
	public static String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<>();
        for (String str : dict) {
        	int index = -1;
        	index = s.indexOf(str, index);
        	while (index != -1) {
        		intervals.add(new Interval(index, index + str.length()));
        		index +=1;
        		index = s.indexOf(str, index);
        	}
        }
        System.out.println(Arrays.toString(intervals.toArray()));
        intervals = merge(intervals);
        System.out.println(Arrays.toString(intervals.toArray()));
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervals) {
        	sb.append(s.substring(prev, interval.start));
        	sb.append("<b>");
        	sb.append(s.substring(interval.start, interval.end));
        	sb.append("</b>");
        	prev = interval.end;
        }
        if (prev < s.length()) {
        	sb.append(s.substring(prev));
        }
        return sb.toString();
    }
	
	static class Interval implements Comparable<Interval>{
		int start, end;
		public Interval(int s, int e) {
			start = s;
			end = e;
		}
		
		public String toString() {
			return "[" + start + ", " + end + "]" ;
		}

		@Override
		public int compareTo(Interval o) {
			// TODO Auto-generated method stub
			 return this.start -o.start;
		}

	
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals);
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for (Interval i : intervals) {
            if (i.start <= end) {
                end = Math.max(end, i.end);
            } else {
                res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

}

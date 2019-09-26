package org.vivek.myinterview.classictechniques.intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Interval> merge(List<Interval> intervals) {

		List<Interval> result = new ArrayList<>();
		if (intervals == null || intervals.size() == 0 || intervals.isEmpty()) {
			return result;
		}
		java.util.Collections.sort(intervals, new IntervalComparator());
		Interval t = intervals.get(0);
		for (int i = 0; i < intervals.size(); i++) {
			Interval c = intervals.get(i);
			if (c.start <= t.end) {
				t.end = Math.max(t.end, c.end);
			} else {
				result.add(t);
				t = c;
			}
		}
		result.add(t);
		return result;

	}

	static class IntervalComparator implements Comparator<Interval> {

		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}

	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}

package org.vivek.myinterview.priorityqueues;

import java.util.Comparator;
import java.util.PriorityQueue;


public class PQTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(10);
		q.offer(4);
		q.offer(2);
		q.offer(8);
		q.offer(6);

		System.out.print(q);
		System.out.println("**********");

		PriorityQueue<DoubleWrapper> r = new PriorityQueue<DoubleWrapper>();

		r.add(new DoubleWrapper(4545.45));
		r.add(new DoubleWrapper(45.4));
		r.add(new DoubleWrapper(1235.45));
		while (!r.isEmpty())
			System.out.println(r.poll());

		/*PriorityQueue<DoubleWrapper2> r2 = new PriorityQueue<DoubleWrapper2>();

		r2.add(new DoubleWrapper2(4545.45));
		r2.add(new DoubleWrapper2(45.4));
		r2.add(new DoubleWrapper2(1235.45));
		while (!r2.isEmpty())
			System.out.println(r2.poll());*/

	}

}

class DoubleWrapper implements Comparable<DoubleWrapper> {
	double time = 909.909;
	double d;

	public DoubleWrapper(double a) {
		this.d = a;
	}

	@Override
	public String toString() {
		return "DoubleWrapper [time=" + time + ", d=" + d + "]";
	}

	@Override
	public int compareTo(DoubleWrapper o) {
		// TODO Auto-generated method stub
		return Double.compare(this.d, this.time) - Double.compare(o.d, o.time);
	}
}
/*
class DoubleWrapper2 implements Comparator<DoubleWrapper2> {
	double time = 909.909;
	double d;

	public DoubleWrapper2(double a) {
		this.d = a;
	}

	@Override
	public String toString() {
		return "DoubleWrapper [time=" + time + ", d=" + d + "]";
	}

	@Override
	public int compare(DoubleWrapper2 o1, DoubleWrapper2 o2) {
		return Double.compare(o1.d, o2.d);
	}

}*/

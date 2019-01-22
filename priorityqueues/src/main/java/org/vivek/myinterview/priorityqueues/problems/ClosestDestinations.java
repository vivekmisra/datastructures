package org.vivek.myinterview.priorityqueues.problems;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

//CLASS BEGINS, THIS CLASS IS REQUIRED
public class ClosestDestinations {

  public static void main(String [] args){
	  ClosestDestinations sol = new ClosestDestinations();
	  Point p1  = sol.new Point(1,-3);
	  Point p2  = sol.new Point(1,2);
	  Point p3  = sol.new Point(3,4);
	  List<Integer> list1 = new ArrayList<Integer>();
	  list1.add(1);
	  list1.add(-3);
	  List<Integer> list2 = new ArrayList<Integer>();
	  list2.add(1);
	  list2.add(2);
	  List<Integer> list3 = new ArrayList<Integer>();
	  list3.add(3);
	  list3.add(4);
	  List<List<Integer>> allLocations = new ArrayList<List<Integer>>();
	  allLocations.add(list1);
	  allLocations.add(list2);
	  allLocations.add(list3);
	  //1 2
	  List<List<Integer>> closestL= sol.ClosestXdestinations(3, allLocations,
				1) ;
	  System.out.println("closestL= "+closestL);
	  for (List<Integer> l : closestL){
		  System.out.print(l+",");
	  }
   }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
   class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
   }
		// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
		List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations,
				int numDeliveries) {

			final PriorityQueue<Point> priorityQueue = new PriorityQueue<Point>(numDestinations, new Comparator<Point>() {
				@Override
				public int compare(Point p1, Point p2) {
					return (p1.x * p1.x  + p1.y * p1.y) - (p2.x * p2.x + p2.y * p2.y);
				}
			});
			for (List<Integer> points : allLocations) {

				Point point = new Point(points.get(0), points.get(1));
				priorityQueue.add(point);

			}

			final List<List<Integer>> answer = new ArrayList<List<Integer>>();

			while (!priorityQueue.isEmpty()) {
				if (numDeliveries == 0)
					break;
				Point point = priorityQueue.poll();
				List<Integer> list = new ArrayList<Integer>();
				list.add(point.x);
				list.add(point.y);
			    answer.add(list);
				numDeliveries--;
			}
			return answer;

		}
	}

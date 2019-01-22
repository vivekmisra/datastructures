package org.vivek.myinterview.priorityqueues.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class OptimalFlightDistant {

	public static List<List<Integer>> calculateOptimalRoute(final int capacity, final List<List<Integer>> forwardRouteList,
			final List<List<Integer>> returnRouteList) {

		// sort forward list
		Collections.sort(forwardRouteList, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o1.get(1) - o2.get(1);
			}
		});

		// sort return list
		Collections.sort(returnRouteList, new Comparator<List<Integer>>() {
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o1.get(1) - o2.get(1);
			}
		});

		int max = 0;
		int i = 0;
		int j = returnRouteList.size() - 1;

		List<List<Integer>> result = null;
		while (i < forwardRouteList.size() && j >= 0) {
			if (forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1) > max
					&& forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1) <= capacity) {
				max = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
				result = new LinkedList<List<Integer>>();
				result.add(new ArrayList<Integer>(Arrays.asList(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0))));
				i++;
			} else if (forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1) == max) {
				// no need to reset result list
				result.add(new ArrayList<Integer>(Arrays.asList(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0))));
				i++;
			} else {
				j--;
			}
		}
		return result;
	}

	List<List<Integer>> optimalUtilization(int maxTravelDist, List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRouteList) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		forwardRouteList = forwardRouteList.stream().sorted((x1, x2) -> Integer.compare(x2.get(1), x1.get(1)))
				.collect(Collectors.toList());
		returnRouteList = returnRouteList.stream().sorted((x1, x2) -> Integer.compare(x1.get(1), x2.get(1)))
				.collect(Collectors.toList());
		int maxDist = maxTravelDist;
		while (true) {
			for (List<Integer> l : forwardRouteList) {
				for (List<Integer> b : returnRouteList) {
					int forward = l.get(1);
					int backward = b.get(1);
					int tot = (forward + backward);
					if (tot > maxDist) {
						break;
					}
					if (tot == maxDist) {
						// print the pair of Id and optimum distance
						result.add(Arrays.asList(l.get(0), b.get(0), maxDist));
						break;
					}

				}
			}
			if (result.size() > 0) {
				break;
			}
			maxDist--;
		}
		return result;
	}

}
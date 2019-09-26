package org.vivek.myinterview.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//@formatter:off
/*32. Reconstruct Itinerary

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
 * https://leetcode.com/problems/reconstruct-itinerary/discuss/138641/Logical-Thinking-with-Clear-Java-Code
 * It is intuitive to model the problem as a graph, such that airports are nodes, and tickets are directed edges.
We ought to take two factors into consideration when reconstruct the itinerary:

all tickets are used up; [comments on code 1.]
the smaller lexical order is preferred;
We simply DFS the graph, and backtrack if the path can not use up all tickets.[comments on code 2.]
To ensure smallest lexical order, for a departure airport, we sort its arrival airports in the lexical order before DFS.[comments on code 3.]
Then, the first path uses up all tickets should be the final answer. [comments on code 4.]

For DFS,
the start point is the airport "JFK",
for each departure airport {
it can get an access to any one of its arrival airports, i.e., map.get(start),
and move forward to the next step..
}
the end point is the first path that ensures all tickets to be used up, i.e., result.size() > 0,

The clear code in Java is as below:
 */
public class Iternary {
	List<String> result;

	public List<String> findItinerary(String[][] tickets) {
	    result = new ArrayList<>();
	    Map<String, List<String>> map = new HashMap<>();
	    for (String[] ticket : tickets) {
	        if (!map.containsKey(ticket[0])) {
	            map.put(ticket[0], new ArrayList<>());
	        }
	        map.get(ticket[0]).add(ticket[1]);
	    }
	    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
	        Collections.sort(entry.getValue()); // 3.
	    }
	    findItineraryFrom("JFK", map, new ArrayList<>(), tickets.length);
	    result.add(0, "JFK");
	    return result;
	}

	private void findItineraryFrom(String start, Map<String, List<String>> map, List<String> curRes, int numTickets) {
	    if (curRes.size() == numTickets) { // 1.all tickets are used up
	        result.addAll(curRes);
	        return;
	    }
	    if (map.get(start) == null) { // 2.the path can not use up all tickets
	        return;
	    }
	    for (int i = 0; i < map.get(start).size(); i++) {
	        String dest = map.get(start).get(i);
	        map.get(start).remove(dest);
	        curRes.add(dest);
	        findItineraryFrom(dest, map, curRes, numTickets);
	        if (result.size() > 0) { // 4.the first valid path is the final answer
	            return;
	        }
	        map.get(start).add(i, dest);
	        curRes.remove(curRes.size() - 1);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

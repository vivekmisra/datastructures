package org.vivek.research.java8.streams.sorted;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsSorted {
	static class Item {

	    private String name;
	    private int qty;
	    private BigDecimal price;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public Item(String name, int qty, BigDecimal price) {
			super();
			this.name = name;
			this.qty = qty;
			this.price = price;
		}
		@Override
		public String toString() {
			return "Item [name=" + name + ", qty=" + qty + ", price=" + price + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((price == null) ? 0 : price.hashCode());
			result = prime * result + qty;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Item other = (Item) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (price == null) {
				if (other.price != null)
					return false;
			} else if (!price.equals(other.price))
				return false;
			if (qty != other.qty)
				return false;
			return true;
		}

	   

	}

	public static void main(String[] args) {
		//3 apple, 2 banana, others 1
        List<String> l =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long>  results=getInputMapOfCounts(l);
        
        
        
      //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
        
        
        Map<String, Long> finalMapsortedMap= sortItemCounts(results);
        
        Map<String, Long> finalMapsortedMap2= sortItemCountsInReverse(results);


        
        
	}


/*Give a list of Strings-group and count
 * list->.stream-->.collect(Collectors.groupingBy(each item of listi.e Function.identity()),Collectors,counting())
 */

	private static Map<String, Long> getInputMapOfCounts(List<String> items) {
		Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result);
       
		return result;
	}
	
	private static  Map<String, Long> sortItemCounts(Map<String, Long> results) {
		Map<String, Long> finalMap = new LinkedHashMap<>();

        //generate stream of entrySet of map ,reverse sort on each of its entrySet and add to finalMap
		//map --entrySet---Stream of entySet --sorted (entrySet).revesed()
        results.entrySet().stream()
                .sorted(Map.Entry.<String, Long> comparingByValue()
                       ).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
        return finalMap;
	}

	
	/*
	 * Given a Map grouped by counts, sort by counts it in reverse order
	 */
	private static  Map<String, Long> sortItemCountsInReverse(Map<String, Long> results) {
		Map<String, Long> finalMap = new LinkedHashMap<>();

        //generate stream of entrySet of map ,reverse sort on each of its entrySet and add to finalMap
		//map --entrySet---Stream of entySet --sorted (entrySet).revesed()
        results.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
        return finalMap;
	}

	

}

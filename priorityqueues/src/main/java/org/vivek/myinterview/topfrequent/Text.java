package org.vivek.myinterview.topfrequent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Text  implements Comparator<Text>{
	enum SortingOrder {
		ASCENDING, DESCENDING
	}

	enum CaseSensitive {
		CASESENSITIVE, CASEINSENSITIVE
	};

	private SortingOrder sortingOrder;
	private CaseSensitive caseSensitive;
	private String text;
	private String[] parts;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getParts() {
		return parts;
	}

	public void setParts(String[] parts) {
		this.parts = parts;
	}

	Text(String text, SortingOrder sortingOrder) {
		this.text = text;
		this.sortingOrder = sortingOrder;
	}
    Text(){
    	
    }
	Text(String[] parts, SortingOrder sortingOrder) {
		this.parts = parts;
		this.sortingOrder = sortingOrder;
	}

	public String[] topKFrequent(String[] words, int k,SortingOrder sortingOrder) {
		Text text = new Text(words, sortingOrder);
		List<String[]> wordPerSentenceList = new ArrayList<>();
		for(int i =0 ; i < text.getParts().length;i++) {
			String sentence = text.getParts()[i];
			String[] wordsPerSentence = sentence.split("\\s+");
			wordPerSentenceList.add(wordsPerSentence);
		}
		List<String> allwords = new ArrayList<>();
		for(String[] wordsPerSentence : wordPerSentenceList) {
			for(String s :wordsPerSentence ) {
			 allwords.add(s);
		   }
		}
	    String [] wordsArray = new String[allwords.size()];
	    for (int i = 0 ; i <allwords.size();i++) {
	    	wordsArray[i] = allwords.get(i);
	    }	
		Map<String, Integer> countMap = new HashMap();
		for (String word : wordsArray) {
			if (countMap.containsKey(word)) {
				countMap.put(word, countMap.get(word) + 1);
			} else {
				countMap.put(word, 1);
			}

		}
		List<String> candidates = new ArrayList(countMap.keySet());
		  Collections.sort(candidates , new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					String s1 = o1.toUpperCase();
					String s2 = o2.toUpperCase();
					int result = -1;
					switch (sortingOrder) {
					case ASCENDING:
						return s1.compareTo(s2);

					case DESCENDING:
						return (-1) * s1.compareTo(s2);
					default:
						return 0;

					}
				}
			});

		List<String> list = candidates.subList(0, k);
		String[] arr = new String[list.size()];

		// ArrayList to Array Conversion
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	
	public int compare(Text text1, Text text2) {

		String s1 = text1.getText().toUpperCase();
		String s2 = text2.getText().toUpperCase();
		int result = -1;
		switch (sortingOrder) {
		case ASCENDING:
			return s1.compareTo(s2);

		case DESCENDING:
			return (-1) * s1.compareTo(s2);
		default:
			return 0;

		}

		// descending order
		// return developerName2.compareTo(developerName1);
	}

	public static void main(String[] args) {
		String[] strings = { "the east is Monday", "The is  Monday", "Monday is the holiday" };
		
	    String[] wordsArray1 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
	    Text text = new Text();
		String[] top3 = text.topKFrequent(strings, 4,SortingOrder.DESCENDING);
		for (String s : top3) {

			System.out.println(s);
		}
	}

}

package org.vivek.myinterview.strings.problems;


/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a re arrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * <p>
 * Input: Tact Coa
 * Output: True (permutations: "taco cat". "atco cta". etc.)
 */
public class PalindromePermutation {

    private static boolean isPalindromePermutation(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    private static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int index = getCharacterIndex(c);
            if (index != -1) {
                table[index]++;
            }
        }
        return table;
    }

    private static int getCharacterIndex(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int value = Character.getNumericValue(c);
        if (a <= value && value <= z) {
            return value - a;
        }
        return -1;
    }

    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac",
                "asda"};
        for (String str : strings) {
            System.out.println(str + " is palindrome permutation: " + isPalindromePermutation(str));
        }
    }
}

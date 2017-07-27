package main.java;
/**
 * Palindromes
 * 
 * @version 1.0
 * @author Miguel J. Monasor
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Palindrome {

    public static void main(String[] args) {
        String[] names = {"Gimli", "Fili", "Ilif", "Ilmig", "Mark"};
        ArrayList<String> palindromes=getPalindromes(names);
        System.out.println(Arrays.toString(palindromes.toArray()));
    }
    
    /**
     * Get palindromes for a list of given names.
     *
     * @param names elements to be checked.
     * @return list of palindromes.
     */
    public static ArrayList<String> getPalindromes(String[] names) {
    	ArrayList<String> palindromes = new ArrayList<String>();
    	Stream<String> namesPermutations = getPermutations(names);
        namesPermutations.forEach((String concatName) -> {
            StringBuilder sb = new StringBuilder(concatName);
            boolean isPalindrome = sb.reverse().toString().equalsIgnoreCase(concatName);
            if (isPalindrome) {
            	palindromes.add(concatName);
            }
        });
        return palindromes;
    }
    
    /**
     * Get all permutations of names.
     * 
     * @param names elements to be checked.
     * @return list of combination.
     */
    public static Stream<String> getPermutations(String[] names) {
        List<String> subBranches = new ArrayList<>(Arrays.asList(names));
        int index = names.length;
        while (index > 1) {
            List<String> subSet = Arrays.asList(names);
            subSet = getSubBranch(names, subSet, index--);
            subBranches.addAll(subSet);
        }
        return subBranches.stream();
    }
    
    /**
     * Get the sub branch of permutations
     *
     * @param names list of names.
     * @param tempSubBranch partial combination.
     * @param subBranchLength length of list elements used for the combination.
     * @return the list of permutations for the given length.
     */
    public static List<String> getSubBranch(String[] names, List<String> tempSubBranch, int subBranchLength) {
        if (subBranchLength == 1) {
            return new ArrayList<>(Arrays.asList(names));
        }
        List<String> allSubBranch = getSubBranch(names, tempSubBranch, subBranchLength - 1);
        List<String> subSet = new ArrayList<>();
        for (String name : names) {
            Stream<String> stream = allSubBranch.stream();
            
            //filter duplicate names
            stream = stream.filter((sub) -> {return !sub.contains(name);});
            
            subSet.addAll(stream.map(sub -> name + sub).collect(Collectors.toList()));
        }
        return subSet;
    }
}
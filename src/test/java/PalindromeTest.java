package test.java;
/**
 * Palindromes
 * 
 * @version 1.0
 * @author Miguel J. Monasor
 */

import main.java.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void testGetPalindromes() {
		String[] names = {"Gimli", "Fili", "Ilif", "Ilmig", "Mark"};
		Palindrome p= new Palindrome();
		ArrayList<String> palindromes=p.getPalindromes(names);
		
		String[] expectedArray = {"GimliFiliIlifIlmig", "GimliIlifFiliIlmig", "FiliGimliIlmigIlif", "FiliIlmigGimliIlif", "IlifGimliIlmigFili", "IlifIlmigGimliFili", "IlmigFiliIlifGimli", "IlmigIlifFiliGimli", "GimliIlmig", "FiliIlif", "IlifFili", "IlmigGimli"};
		assertArrayEquals(expectedArray, palindromes.toArray());
	}

	@Test
	public void testGetPermutations() {
		String[] names = {"a", "b", "c"};
		Palindrome p= new Palindrome();
		Stream<String> namesPermutations = p.getPermutations(names);
		
		String[] expectedArray = {"a", "b", "c", "abc", "acb", "bac", "bca", "cab", "cba", "ab", "ac", "ba", "bc", "ca", "cb"};
		assertArrayEquals(expectedArray, namesPermutations.toArray());
	}

	@Test
	public void testGetSubBranch() {
		String[] names = {"a", "b", "c"};
		Palindrome p= new Palindrome();
		List<String> subSet = Arrays.asList(names);
		
		subSet = p.getSubBranch(names, subSet, 1);
		String[] expectedArray1 = {"a", "b", "c"};
		assertArrayEquals(expectedArray1, subSet.toArray());
		
		subSet = p.getSubBranch(names, subSet, 2);
		String[] expectedArray2 = {"ab", "ac", "ba", "bc", "ca", "cb"};
		assertArrayEquals(expectedArray2, subSet.toArray());
		
		subSet = p.getSubBranch(names, subSet, 3);
		String[] expectedArray3 = {"abc", "acb", "bac", "bca", "cab", "cba"};
		assertArrayEquals(expectedArray3, subSet.toArray());
	}

}

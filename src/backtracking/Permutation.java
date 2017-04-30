package backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author berrytchaks
 * 
 * Permutation problem
 * Find all the permutations of a string. For each permutation, print the index of the corresponding
 * character in the string. 
 *
 */
public class Permutation
{
	private Map<Character,Integer> indexes = new HashMap<>();
//	private char[] indexes2;
	public Permutation(String str){
//		indexes2 = new char[str.length()];
		for (int i =0; i < str.length(); i++){
        	indexes.put(str.charAt(i),i);
//        	indexes2[i] = str.charAt(i);
        }
	}
    public static void main(String[] args)
    {
        String str = "ABCD";
        int n = str.length();
        Permutation permutation = new Permutation(str);
        permutation.permute(str, 0, n-1);
    }
 
    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r){
        	System.out.print(str +" ");
        	for (int i =0;i < str.length();i++){
        		System.out.print(indexes.get(str.charAt(i)));
        	}
//        	System.out.print(" ");
//        	for (int i =0;i < str.length();i++){
//        		for(int j =0; j< str.length();j++){
//        			if (str.charAt(i) == indexes2[j]){
//        				System.out.print(j);
//        			}
//        		}
//        	}
        	System.out.println();
        }
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
//                System.out.println("str1 ="+str+" l="+l+" i="+i);
                permute(str, l+1, r);
//                str = swap(str,l,i);
            }
        }
    }
 
    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
 
}
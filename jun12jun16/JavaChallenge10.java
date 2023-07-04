package jun12jun16;

import java.util.HashMap;
import java.util.Map;

//Given a string s consisting of lowercase English letters, return the first letter to appear twice.
//
//Note:
//
//A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
//s will contain at least one letter that appears twice.
//
//Example 1:
//
//Input: s = "abccbaacz"
//Output: "c"
//Explanation:
//The letter 'a' appears on the indexes 0, 5 and 6.
//The letter 'b' appears on the indexes 1 and 4.
//The letter 'c' appears on the indexes 2, 3 and 7.
//The letter 'z' appears on the index 8.
//The letter 'c' is the first letter to appear twice, because out of all the letters the index of its second occurrence is the smallest.
//Example 2:
//
//Input: s = "abcdd"
//Output: "d"
//Explanation:
//The only letter that
public class JavaChallenge10 {

	public static char findRepeatedChar(String s) {
		char output= '\0';
		Map<Character,Integer> map =new HashMap<Character,Integer>();
		for (int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				Integer value = map.get(s.charAt(i));
				map.put(s.charAt(i), value+1);
			
				return s.charAt(i);
			
			}else {
				map.put(s.charAt(i), 1);
				
			}
			
		}
		
		return output;
		
		
	}
	public static void main(String[] args) {
		String s="aabecdfghhkhj";
		System.out.println("output:"+findRepeatedChar(s));

	}

}

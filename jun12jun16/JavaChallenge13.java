package jun12jun16;
//A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.
//
//A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.
//
//For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
//Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.
//
//Example 1:
//
//Input: s = "is2 sentence4 This1 a3"
//Output: "This is a sentence"
//Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
//Example 2:

//Input: s = "Myself2 Me1 �


public class JavaChallenge13 {

	public static void main(String[] args) {

           String s="is2 sentence4 This1 a3";
           String[] split = s.split(" ");
           String[] output = new String[split.length];
           
           for (int i = 0; i < split.length; i++) {
        	   int index = Integer.parseInt(split[i].substring(split[i].length()-1));
        	   String substring = split[i].substring(0, split[i].length()-1);
        	   output[index-1]= substring;
        	  
		}
           for (int i = 0; i < output.length; i++) {
        	   System.out.print(output[i]+" ");
			
		}

	}

}

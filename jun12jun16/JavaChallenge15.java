package jun12jun16;
//Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.
//
//Return the largest lucky integer in the array. If there is no lucky integer return -1. 
//
//Example 1:
//
//Input: arr = [2,2,3,4]
//Output: 2
//Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
//Example 2:
//
//Input: arr = [1,2,2,3,3,3]
//Output: 3
//Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
//Example 3:
//
//Input: arr = [2,2,2,3,3]
//Output: -1
//Explanation: There are no lucky numbers in the array.

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaChallenge15 {
	public static int findLuckyNum(int[] arr) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < arr.length; i++) {
			
			if(map.containsKey(arr[i])){
				Integer value = map.get(arr[i]);
				map.put(arr[i], value +1);
				
			}else {
				
				map.put(arr[i], 1);
			}
			
		}
		for(Map.Entry<Integer, Integer> entrySet:map.entrySet()) {
			if(entrySet.getKey()==entrySet.getValue()) {
				return entrySet.getKey();
				
			}
			
		}
		
		return -1;
		
	}

	public static void main(String[] args) {
		
		int[] arr= {2,3,3,4};
		
		System.out.println("output:"+findLuckyNum(arr));
	}

}

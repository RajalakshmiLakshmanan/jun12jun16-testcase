package jun12jun16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

/*Java Problem (7/20)

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
*/
public class JavaChallenge7 {
	public static boolean isduplicate(int[] arr) {
		Set<Integer> set= new HashSet<Integer>();
		Set<Integer> dupset= new HashSet<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			if(!set.add(arr[i])) {
				dupset.add(arr[i]);
				
			}
		}
		if(dupset.isEmpty()) {
			return false;
		}
		return true;
	}
	public static boolean isrepeated(int[] arr) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])) {
				Integer value = map.get(arr[i]);
				System.out.println(value);
				map.put(arr[i], value+1);
				
			}else {
				map.put(arr[i], 1);
				
			}
			
			
		}
		System.out.println(map);
		
		for(int i=0; i<map.size();i++) {
			Integer value = map.get(arr[i]);
			if(value>1) {
				return true;
				
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		int [] num= {1,2,3,3,4,4};
		System.out.println("Output:"+isduplicate(num));
		System.out.println("Output:"+isrepeated(num));
	}

}

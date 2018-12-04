
public class Finder {
	
	public int findMaximumValueTag(int[] input) {
		int maxElement = -100;
		for(int tags : input) {
			if(tags > maxElement)
				maxElement = tags;
		}
		return maxElement;
	}
}

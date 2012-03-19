import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
public class IntegerSort {

	public static void main(String args[])
	{
		int[] arr = {1,1,2,2,2,2,3,4,4,4,5,5,5,5,5,5,6,6,6,6,6,33,33,33,33,33,33,33,33,33,33,33};
		int[] arr2 = sort(arr);
		for(int i:arr2)
			System.out.print(i+" ");
	}
	public static int[] sort(int[] arr)
	{
		if(arr.length <= 1 || arr == null)
		{
			int[] empty = {};
			return empty;
		}
		else
		{
			Hashtable<Integer,Integer> countsTable = createHashtable(arr);
			Object[] countsArray= integerCount(countsTable);
			return sortCountArray(countsArray);
		}
			
	}
	
	private static Hashtable<Integer,Integer> createHashtable(int[] arr)
	{		
		Hashtable<Integer, Integer> counts = new Hashtable<Integer, Integer>();
		int currentCount;
		for(int value:arr)
		{
			if (counts.containsKey(value))
			{
				currentCount = counts.get(value);
				counts.put(value, ++currentCount);
			}
			else
				counts.put(value, 1);
		}		
		return counts;
	}
	
	private static Object[] integerCount(Hashtable<Integer, Integer> countsTable)
	{
		int intCount;
		ArrayList<IntCount> intCountArrayList= new ArrayList<IntCount>();
		if(countsTable.size()>0)
		{
			Object[] keys = countsTable.keySet().toArray();
			for(Object key:keys)
			{
				intCount = countsTable.get(key);
				if(intCount > 1)
					intCountArrayList.add(new IntCount((Integer)key,intCount));
			}
		}
		Object[] intCountArr = intCountArrayList.toArray();
		return intCountArr;
	}
	
	private static int[] sortCountArray(Object[] countsArray)
	{		
		int[] sortedArray = new int[countsArray.length];
		Arrays.sort(countsArray, new ItemComparator());
		for(int index=0; index<countsArray.length; index++)
			sortedArray[index] = ((IntCount)countsArray[index]).getValue();
		return sortedArray;
	}
	
	private static class ItemComparator implements Comparator<Object>{
		public int compare(Object valueCount1, Object valueCount2)
		{
			int count1 = ((IntCount)valueCount1).getCount();
			int count2 = ((IntCount)valueCount2).getCount();
			
			if(count1 < count2)
				return 1;
			else if (count1 > count2)
				return -1;
			return 0;
		}	
	}
	
	private static class IntCount{
		private int count;
		private int value;
		
		private IntCount(int value, int count)
		{
			this.setValue(value);
			this.setCount(count);
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
	}
}

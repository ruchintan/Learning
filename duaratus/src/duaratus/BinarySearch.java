package duaratus;

public class BinarySearch {
	static int[] data = {4, 7, 11, 13, 21, 29, 30,31,55};
	
	//rekursif
	public static void search(int left,int right,int val)
	{
		int mid = (left+right)/2;
		if (left> right)
		{
			System.out.println("not found");
		}
		else {
		if (data[mid]==val)
		{
			System.out.println(mid+1);
		}
		else if (data[mid]<val)
		{
			search(mid+1, right,val);
		}
		else if (data[mid]>val)
		{
			search(left,mid-1,val);
		}
		}
	}
	//not rekursif
	public static int search2(int target) {
		int left = 0;
		int right = data.length-1;
		while (left <= right) {
		int mid = (left + right) / 2;
		if (target == data[mid]) {
		return mid+1;
		} 
		else if (target < data[mid]) {
		right = mid-1;
		}
		else {
		left = mid + 1;
		}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		search(0,data.length-1,11);
		System.out.println(search2(99));
	}

}

package duaratus;

public class enhancedfor {
	public int[] data = {1,15,147,100};
	public static StringBuilder word= new StringBuilder();
	//public StringBuilder word= new StringBuilder();
	public void enhanced()
	{
		for (int item : data)
		{
			if (item < 100)
			{
				System.out.println(item);
			}
		}
	}
	public static void copy(String sentence)
	{
		for(String substring : sentence.split("\n"))
		{
			word.append(substring+ "-");
		}
	}
	
	//main java
	public static void main(String[] args)
	{
		//without static
		enhancedfor e = new enhancedfor();
		e.enhanced();
		
		// with static
		//copy("aku mau makan bakso dua mangkok");
		copy("aku minum soda dua botol"
				+ "\n" + "haha");
		System.out.println(word);
		word.delete(0, word.length());
	}
}


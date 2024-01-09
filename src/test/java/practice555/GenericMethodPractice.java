package practice555;

public class GenericMethodPractice {

	public static void main(String[] args) {
	/*hard coded
	 * parametrtized & returned 
	 * if multiple data types use object*/
		
	//int a = 10;
	//int b=20;
	
	//int c =a+b;
	//System.out.println(c);
		
		
		int sum = add(30,40);//calling method 
		System.out.println(sum);
		
		int sum1 = add(50,90);
				//System.out.println(sum1);
	}
		public static int add(int a, int b)// called method, generic method
		{
		int c= a+b;
		return c;
		}
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
}

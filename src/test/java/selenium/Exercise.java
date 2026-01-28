package selenium;

public class Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Create an Array:

Create a new array called numbers to store 5 numerical values of your choice (they can be whole numbers or decimals).

Access and Print:

Print the following:

The first element of the numbers array.

The last element of the numbers array.

Reverse Order:

Using a loop, print the elements of the numbers array in reverse order.

Bonus: Element Count:

Calculate the total number of elements within the numbers array.  */
		
		int[] a = {1,4,5,8,9};
		
		//System.out.println(a[0]);
		//System.out.println(a[4]);
		
		for (int i=a.length-1; i>=0;i--)
		{
			
			System.out.println(a[i]);
		
			
		}
		
		System.out.println("total number of elements" + " " + a.length);
	 	
		
		
	}

}

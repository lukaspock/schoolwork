
package at.htlpinkafeld.utils.MathUtil;

public class MathUtil{

	public static void main(String[] args){
		int[][] pascTr;
        
        pascTr = MathUtil.createPascalsTriangle(10);
        
        System.out.println("Depth: "+pascTr.length);
        System.out.println("Common for:");
        MathUtil.showPascalsTriangle1(pascTr);
        System.out.println();
        System.out.println("for-each:");
        MathUtil.showPascalsTriangle12(pascTr);
	}
	
	
	public static int[][] createPascalsTriangle(int depth)
	{
		int[][] triangle = new int[depth][];
			
		for (int i = 0; i < depth; i++) {
			triangle[i] = new int[i + 1];  
		}

		for (int i = 0; i < depth; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (j == 0 || j == triangle[i].length - 1) {
					triangle[i][j] = 1;  
				}
			}
		}

		for (int i = 2; i < depth; i++) {
			for (int j = 1; j < triangle[i].length - 1; j++) {
				triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
			}
		}
		
		return triangle;
		
		
	}
	public static void showPascalsTriangle1(int[][] arr)
	{
		int help = arr.length;
		
		for(int i = 0; i < arr.length ; i++)
		{
			for(int help2 = 0; help2 < help; help2++)
				System.out.print("  ");
			help--;
			for(int j = 0; j < arr[i].length; j++)
			{
				if(arr[i][j] > 100)
					System.out.print(" ");
				if(arr[i][j] < 100 && arr[i][j] >= 10 )
					System.out.print(" ");
				if(arr[i][j] < 10)
					System.out.print("  ");
				System.out.print(arr[i][j]);
				
				if(arr[i][j] < 100 && arr[i][j] >= 10 )
					System.out.print(" ");
				if(arr[i][j] < 10)
					System.out.print(" ");
			}
			System.out.println("");
		}
	}

	public static void showPascalsTriangle12(int[][] arr)
	{
		int help = arr.length;
		
		for(int[] ele1 : arr)
		{
			for(int help2 = 0; help2 < help; help2++)
				System.out.print("  ");
			help--;
			for(int ele2 : ele1)
			{
				if(ele2 > 100)
					System.out.print(" ");
				if(ele2 < 100 && ele2 >= 10 )
					System.out.print(" ");
				if(ele2 < 10)
					System.out.print("  ");
				System.out.print(ele2);
				
				if(ele2 < 100 && ele2 >= 10 )
					System.out.print(" ");
				if(ele2 < 10)
					System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
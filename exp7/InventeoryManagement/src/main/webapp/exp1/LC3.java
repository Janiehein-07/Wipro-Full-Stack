package lb;
import java.util.*;

public class LC3 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int sum=0, count=0;
		int arr[]=new int[10];
		System.out.println("Fill the array with 10 values");
		for(int i=0; i<arr.length;i++) {
			arr[i]=s.nextInt();
			sum+=arr[i];
			}
		double avg=(double)sum/arr.length;
		for(int i=0; i<arr.length;i++) {
			if (arr[i]>avg){
				count++;
			}
		}
		
		System.out.print("Sum: "+ sum);
		System.out.print("\nGreater than average: "+ count);
			

	}

}


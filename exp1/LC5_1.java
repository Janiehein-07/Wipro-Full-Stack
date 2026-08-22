package lb;
import java.util.*;

public class LC5_1 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n1, n2;
		System.out.print("Number of elements in Arr1: ");
		n1=s.nextInt();
		System.out.print("Number of elements in Arr2: ");
		n2=s.nextInt();
		int arr1[]=new int[n1];
		int arr2[]=new int[n2];
		for(int i=0; i<n1;i++) {
			arr1[i]=s.nextInt();
		}
		for(int j=0; j<n2;j++) {
			arr2[j]=s.nextInt();
		}
		
		int ans[]=new int[n1+n2];
		for(int i=0; i<n1;i++) {
			ans[i]=arr1[i];
		}
		for(int j=0; j<n2;j++) {
			ans[n1+j]=arr2[j];
		}
		Arrays.sort(ans);
		System.out.print("The sorted and merged array: "+Arrays.toString(ans));
	}
}


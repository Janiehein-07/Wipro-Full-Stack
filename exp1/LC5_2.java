package lb;
import java.util.Scanner;

public class LC5_2 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int arr[]=new int[5];
		System.out.print("Enter the array: ");
		for (int i=0; i<5;i++) {
			arr[i]=s.nextInt();
		}
		for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.print("Sorted array: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}


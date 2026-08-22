package lb;
import java.util.Scanner;

public class LC4 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str=s.nextLine();
		str=str.replace(" ", "");
		System.out.println("Length of the string is "+str.length());

	}

}


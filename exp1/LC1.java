package lb;
import java.util.*;

public class LC1 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int a, b, t;

        System.out.print("Enter the value of A: ");
        a = s.nextInt();

        System.out.print("Enter the value of B: ");
        b = s.nextInt();

        t = a;
        a = b;
        b = t;

        System.out.println("After the swap:");
        System.out.println("A = " + a);
        System.out.println("B = " + b);
    }
}



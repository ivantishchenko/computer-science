import java.util.Scanner;

// Time O(log(a))
public class Main {
	public static void main(String[] args) {
		int Num1, Num2, Temp, GCD = 0;
		var sc = new Scanner(System.in);
		
		System.out.print(" Please Enter the First Integer Value : ");
		Num1 = sc.nextInt();	
		
		System.out.print(" Please Enter the Second Integer Value : ");
		Num2 = sc.nextInt();
		
		// gcd(a, b) = gcd(b, a % b)
		// gcd(a, b) = gcd(a - b, b)
		while(Num2 != 0) {
			Temp = Num2;
			Num2 = Num1 % Num2;
			Num1 = Temp;
			// without temp
			// if(Num1 > Num2) Num1 = Num1 - Num2;
			// else Num2 = Num2 - Num1;
	    }
		GCD = Num1;
		System.out.println("\n GCD  =  " + GCD);
	}
}
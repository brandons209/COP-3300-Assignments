package silva_p1;
import java.util.Scanner; 

public class Decrypt {

	public static void main(String[] args) {
		// declarations, store input and each digit of input
		Scanner scnr = new Scanner(System.in);
		int input, d1, d2, d3, d4;
		
		// get encrypted number
		System.out.println("Enter number to decrypt:");
		input = scnr.nextInt();
		scnr.close();
		
		// get digits of encrypted number
		d4 = input % 10;
		d3 = (input / 10) % 10;
		d2 = (input / 100) % 10;
		d1 = (input / 1000) % 10;
		
		// if the digit is between [7, 9], then it was either 0, 1, 2: subtract 7
		if (d4 >= 7 && d4 <=9)
		{
			d4 -= 7;
		}
		// if the digit is <7, then it was originally in [3, 9] and the encrypted
		// digit is in [0, 6], so adding 3 to the digit get its to the original digit
		else
		{
			d4 += 3;
		}
		
		if (d3 >= 7 && d3 <=9)
		{
			d3 -= 7;
		}
		else
		{
			d3 += 3;
		}
		
		if (d2 >= 7 && d2 <=9)
		{
			d2 -= 7;
		}
		else
		{
			d2 += 3;
		}
		
		if (d1 >= 7 && d1 <=9)
		{
			d1 -= 7;
		}
		else
		{
			d1 += 3;
		}
		
		System.out.printf("Decrypted number: %d%d%d%d\n", d3, d4, d1, d2);
		
	}

}

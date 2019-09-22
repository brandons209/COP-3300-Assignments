package silva_p3;
import java.util.Scanner; 
import java.lang.String;

public class silva_p3 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String topics[] = new String[]{"Global Warming", "Memes", "Flat Earthers", "Universal Healthcare", "Mental Health"};
		int responses[][] = new int[5][10];
		int total_counts[] = new int[5];
		int input = 0, digit_len, num_entries = 0, max = 0, min = Integer.MAX_VALUE, min_i = 0, max_i = 0;
		
		// init arrays to 0
		for (int i = 0; i < 5; i++)
		{
			total_counts[i] = 0;
			for (int j = 0; j < 10; j++)
			{
				responses[i][j] = 0;
			}
		}
		
		System.out.println("Please rate the following topics 1-10.");
		
		// runs till user enters -1 at the end of each survey entry
		while (input != -1) 
		{
			// add one to number of entries for averaging
			num_entries += 1;
			for (int i = 0; i < 5; i++)
			{
				System.out.printf("%s\n", topics[i]);
				input = scnr.nextInt();
				
				// waits until user enters valid input
				while (input < 1 || input > 10)
				{
					System.out.println("Invalid input, please enter a number between 1-10");
					input = scnr.nextInt();
				}
				// adds 1 to count of the rating that was given
				responses[i][input - 1] += 1;
				// addes input value to total count for this issue
				total_counts[i] += input;
			}
			System.out.println("Next person? (Enter -1 to stop entering ratings, 0 to continue)");
			input = scnr.nextInt();
		}
		
		scnr.close();
		// print table header
		System.out.println("|---------------------|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|-----------|");
		System.out.printf("| %s%16s %2d  |%3d  |%3d  |%3d  |%3d  |%3d  |%3d  |%3d  |%3d  |%4d  |%9s  |\n", "Topic", "|", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, "Average");
		System.out.println("|---------------------|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|-----------|");
		
		for (int i = 0; i < 5; i++)
		{	
			// prints topic
			System.out.printf("| %s%" + (21 - topics[i].length()) + "s", topics[i], "|");
			// iterates through until the rating 9 column
			for (int j = 0; j < 9; j++)
			{
				// gets how many digits are in the count array (responses)
				digit_len = String.valueOf(responses[i][j]).length();
				// based on length of digits, sets digit_len to the apporitate space format for printing number in the table
				if (digit_len == 1)
				{
					digit_len = 3;
				}
				else if (digit_len == 2)
				{
					digit_len = 3;
				}
				else if (digit_len == 3)
				{
					digit_len = 3;
				}
				else if (digit_len == 4)
				{
					digit_len = 2;
				}
				else
				{
					digit_len = 1;
				}
				// prints current count for rating for the current topic
				System.out.printf("%" + digit_len + "d%" + digit_len + "s", responses[i][j], "|");
			}
			digit_len = String.valueOf(responses[i][9]).length();
			if (digit_len == 1)
			{
				digit_len = 3;
			}
			else if (digit_len == 2)
			{
				digit_len = 3;
			}
			else if (digit_len == 3)
			{
				digit_len = 3;
			}
			else if (digit_len == 4)
			{
				digit_len = 2;
			}
			else
			{
				digit_len = 1;
			}
			// prints last column entry for rating 10 (needs an extra space) and prints average for the row
			System.out.printf("%" + digit_len + "d%" + (1 + digit_len) + "s", responses[i][9], "|");
			System.out.printf("%7.2f%5s", (double)total_counts[i] / (double)num_entries, "|");
			System.out.println();
		}
		
		// calculate min and max of the total_counts array
		for (int i = 0; i < 5; i++)
		{
			if (total_counts[i] < min)
			{
				min = total_counts[i];
				min_i = i;
			}
			else if (total_counts[i] > max)
			{
				max = total_counts[i];
				max_i = i;
			}
		}
		
		// output bottom to the table
		System.out.println("|---------------------|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|-----------|\n");
		// output min and max
		System.out.printf("%s had the most points, which was %d points.\n", topics[max_i], max);
		System.out.printf("%s had the least points, which was %d points.\n", topics[min_i], min);
		
	}

}

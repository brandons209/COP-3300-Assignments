package silva_p2;

public class Application {

	public static void main(String[] args) {
		DuplicateCounter count = new DuplicateCounter();

		count.count("problem2.txt");
		count.write("unique_word_counts.txt");
	}

}

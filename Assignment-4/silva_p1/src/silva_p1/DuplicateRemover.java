package silva_p1;
import java.io.*;
import java.util.*;

public class DuplicateRemover {
	private String[] uniqueWords;
	
	public DuplicateRemover() {
		
	}
	
	public void remove(String dataFile) {
		BufferedReader buff = null;
		try {
			buff = new BufferedReader(new FileReader(dataFile));
		} catch (Exception e) {
			System.out.printf("I/O Error in remove.\n");
			e.printStackTrace();
			System.exit(1); 
		}
		String text;
		Set<String> set = new HashSet<String>();
		
		try {
			while ( (text = buff.readLine()) != null) {
				String[] split = text.split(" ");
				for (int i = 0; i < split.length; i++) {
					set.add(split[i].toLowerCase());
				}
			}
			buff.close();
		} catch (IOException e) {
			System.out.printf("I/O Error in remove.\n");
			e.printStackTrace();
			System.exit(2);
		}
		
		uniqueWords = new String[set.size()];
		Iterator<String> i = set.iterator(); 
        int c = 0;
		while (i.hasNext()) {
			uniqueWords[c] = i.next();
			c++;
		}
		
	}
	
	public void write(String outputFile) {
		try {
			File f = new File(outputFile);
			if (!f.exists()) {
				f.createNewFile();
			}
			BufferedWriter buff = new BufferedWriter(new FileWriter(f));
			for (String word: uniqueWords) {
				buff.write(word + " ");
			}
			buff.close();
		} catch (Exception e) {
			System.out.printf("I/O Error in write.\n");
			e.printStackTrace();
			System.exit(1); 
		}
	}

}

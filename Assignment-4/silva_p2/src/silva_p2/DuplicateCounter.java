package silva_p2;
import java.util.*;
import java.io.*;

public class DuplicateCounter {
	Map<String, Integer> map;
	
	public DuplicateCounter() {
		map = new HashMap<String, Integer>();
	}

	
	public void count(String dataFile) {
		BufferedReader buff = null;
		try {
			buff = new BufferedReader(new FileReader(dataFile));
		} catch (Exception e) {
			System.out.printf("I/O Error in count.\n");
			e.printStackTrace();
			System.exit(1); 
		}
		
		String text;
		
		try {
			while ( (text = buff.readLine()) != null) {
				String[] split = text.split(" ");
				for (int i = 0; i < split.length; i++) {
					if (map.get(split[i]) == null)
						map.put(split[i], 1);
					else
						map.replace(split[i], map.get(split[i])+1);
				}
			}
			buff.close();
		} catch (IOException e) {
			System.out.printf("I/O Error in count.\n");
			e.printStackTrace();
			System.exit(2);
		}
	}
	
	public void write(String outputFile) {
		try {
			File f = new File(outputFile);
			if (!f.exists()) {
				f.createNewFile();
			}
			BufferedWriter buff = new BufferedWriter(new FileWriter(f));
			Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
			
			while (it.hasNext()) {
				Map.Entry<String,Integer> element = (Map.Entry<String,Integer>)it.next();
				buff.write(element.getKey() + ": " + element.getValue() + "\n");
			}
			
			buff.close();
		} catch (Exception e) {
			System.out.printf("I/O Error in write.\n");
			e.printStackTrace();
			System.exit(1); 
		}
	}
	
}

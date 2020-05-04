package roller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Table {

	private ArrayList<String> table = new ArrayList<String>();
	private String result;

	public String getRoll(int index) throws FileNotFoundException, IOException {
		StringBuilder r = new StringBuilder();
		if (table.size() == 0) {createList();}
		result = table.get(index);
		r.append("\nRoll [" + index++ + "]: ");
		r.append(result.substring(4));
		return r.toString();
		
	}
	void createList() throws FileNotFoundException, IOException {
		//Ladies and gentlemen, fasten your seatbelts
		try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("netlibramtable.txt")))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		      table.add(line);
		    }
		}
	}
	
}

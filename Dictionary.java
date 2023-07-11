import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary{

	private String fileName 	= "br-utf8.txt";
	private ArrayList<String> dict 	= new ArrayList<String>();

	Dictionary(){
		try{
			File dictFile 		= new File(fileName);
			Scanner fileReader 	= new Scanner(dictFile);
			while(fileReader.hasNextLine()){
				String lineContent = fileReader.nextLine();
				dict.add(lineContent);
			}
			fileReader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error, be sure the file 'br-utf8.txt' " +
					   "is on the same directory as the classes");
			e.printStackTrace();
		}
	}

	public String getRandomWord(){
		Random 	random 	= new Random();
		long 	seed	= System.currentTimeMillis();
		random.setSeed(seed);

		Integer randomIndex = random.nextInt(dict.size());
		return dict.get(randomIndex);
	}

	public Boolean contains(Word word){
		String wordStr = word.toString();
		return dict.contains(wordStr);
	}
}

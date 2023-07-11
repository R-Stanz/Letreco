import java.util.ArrayList;

public class Word{

	private String 	   	word;
	private Dictionary 	dict;

	Word(){}

	Word(Dictionary dict){
		this.dict 	= dict;
		this.word 	= dict.getRandomWord();
	}

	Word(Dictionary dict, String hint){
		this.dict	= dict;
		this.word 	= hint;
	}

	public Boolean evaluate(Word anotherWord){
		Interface messages 			= new Interface();
		ArrayList<Character> wordArr		= this.getCharArrayList();
		ArrayList<Character> otherWordArr	= anotherWord.getCharArrayList();

		messages.evaluateRecap(anotherWord.word);
		Boolean win = true;

		Integer iterations 	= wordArr.size();
		Integer removed		= 0;
		for(Integer index = 0; index < iterations; index++){
			Character wordChar	= wordArr.get(index-removed);
			Character otherWordChar	= otherWordArr.get(index);

			if(wordChar.equals(otherWordChar)){
				messages.rightPosition();
				wordArr.remove(wordChar);
				removed += 1;
			}
			else{
				win = false;
				if(wordArr.remove(wordChar)){
					removed += 1;
					messages.rightChar();
				}
				else
					messages.wrongChar();
			}
		}
		return win;
	}

	private ArrayList<Character> getCharArrayList(){
		ArrayList<Character> wordArrList = new ArrayList<Character>();
		for(Character c : this.word.toCharArray()){
			wordArrList.add(c);
		}
		return wordArrList;
	}

	public String toString(){
		return this.word;
	}
}


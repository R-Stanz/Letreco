import java.util.ArrayList;

public class Word{

	private String 	   	word;
	private Dictionary 	dict;

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
		ArrayList<Character> result 		= (ArrayList)wordArr.clone();

		String symbol = "+";
		Integer count = 0;
		for(Integer index = 0; index < wordArr.size(); index++){
			Character wordChar	= wordArr.get(index);
			Character otherWordChar	= otherWordArr.get(index);

			if(wordChar.equals(otherWordChar)){
				wordArr.set(index, symbol.charAt(0));
				otherWordArr.set(index, symbol.charAt(0));
				count += 1;
			}
		}

		ArrayList<Character> symbolsArr		= new ArrayList<Character>();

		symbolsArr.add(symbol.charAt(0));
		wordArr.removeAll(symbolsArr);

		if(wordArr.isEmpty()){
			messages.resultEvaluation(otherWordArr);
			return true;
		}

		symbol = "-";
		symbolsArr.add(symbol.charAt(0));
		symbol = "*";
		symbolsArr.add(symbol.charAt(0));

		for(Integer index = 0; index < otherWordArr.size(); index++){
			Character otherWordChar	= otherWordArr.get(index);

			if(!symbolsArr.contains(otherWordChar)){
				if(wordArr.isEmpty()) break;
				else if(wordArr.remove(otherWordChar)){
					symbol = "-";
					otherWordArr.set(index, symbol.charAt(0));
				}
				else{
					symbol = "*";
					otherWordArr.set(index, symbol.charAt(0));
				}
			}
		}
		messages.resultEvaluation(otherWordArr);
		return false;
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


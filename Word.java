public class Word{

	private Interface	messages; 
	private String 	   	word;
	private Dictionary 	dict;

	Word(Dictionary dict){
		this.dict 	= dict;
		this.word 	= dict.getRandomWord();
	}

	Word(Dictionary dict, Sting hint){
		this.dict	= dict;
		this.word 	= hint;
	}

	public Boolean evaluate(Word anotherWord){
		ArrayList<Character> wordArr		= this.getCharArrayList();
		ArrayList<Character> otherWordArr	= anotherWord.getCharArrayList();

		Boolean win = true;

		for(Integer index = 0; index < word.length; index++){
			wordChar.get(index)		= wordArr.get(index);
			otherWordChar.get(index)	= otherWordChar.get(index);

			if(wordChar.equals(otherWordChar)){
				messages.rightPosition();
				wordArr.remove(wordChar);
			}
			else{
				win = false;
				if(wordArr.remove(wordChar))
					messages.rightChar();
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


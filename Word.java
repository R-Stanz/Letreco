import java.util.

public class Word{

	private String 	   word;
	private Dictionary dict;

	Word(Dictionary dict){
		this.dict 	= dict;
		this.word 	= dict.getRandomWord();
	}

	Word(Dictionary dict, Sting hint){
		this.dict	= dict;
		this.word 	= hint;
	}

	public Boolean evaluate(Word anotherWord){
	}

	public String toString(){
		return this.word;
	}
}


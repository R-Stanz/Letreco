import java.util.ArrayList;

public class Game{

	private Messages message 	= new Messages();

	Game(){}

	public Boolean run(){
		Dictionary dict 	= new Dictionary();
		String answer 		= dict.getRandomWord();

		for(Integer i = 0; i < 6; i++){
			String hint 	= message.getNewHint(i+1, dict);
			if(this.evaluate(answer, hint)){
				message.win(answer);
				return true;
			}
		}
		message.loss(answer);
		return false;
	}

	private Boolean evaluate(String answer, String hint){
		ArrayList<Character> answerArr	= this.getCharArrayList(answer);
		ArrayList<Character> hintArr	= this.getCharArrayList(hint);

		message.evaluateRecap(hint);
		ArrayList<Character> result 	= (ArrayList)answerArr.clone();

		String symbol = "+";
		Integer count = 0;
		for(Integer index = 0; index < answerArr.size(); index++){
			Character answerChar	= answerArr.get(index);
			Character hintChar	= hintArr.get(index);

			if(answerChar.equals(hintChar)){
				answerArr.set(index, symbol.charAt(0));
				hintArr.set(index, symbol.charAt(0));
				count += 1;
			}
		}

		ArrayList<Character> symbolsArr	= new ArrayList<Character>();

		symbolsArr.add(symbol.charAt(0));
		answerArr.removeAll(symbolsArr);

		if(answerArr.isEmpty()){
			message.resultEvaluation(hintArr);
			return true;
		}

		symbol = "-";
		symbolsArr.add(symbol.charAt(0));
		symbol = "*";
		symbolsArr.add(symbol.charAt(0));

		for(Integer index = 0; index < hintArr.size(); index++){
			Character hintChar	= hintArr.get(index);

			if(!symbolsArr.contains(hintChar)){
				if(answerArr.isEmpty()) break;
				else if(answerArr.remove(hintChar)){
					symbol = "-";
					hintArr.set(index, symbol.charAt(0));
				}
				else{
					symbol = "*";
					hintArr.set(index, symbol.charAt(0));
				}
			}
		}
		message.resultEvaluation(hintArr);
		return false;
	}

	private ArrayList<Character> getCharArrayList(String word){
		ArrayList<Character> wordArrList = new ArrayList<Character>();
		for(Character c : word.toCharArray()){
			wordArrList.add(c);
		}
		return wordArrList;
	}
}

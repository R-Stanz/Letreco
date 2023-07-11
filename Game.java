import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Game{

	private Boolean win;
	private Word answer;
	private Dictionary dict;

	Game(Dictionary dict){
		Interface messages 	= new Interface();
		answer 			= new Word(dict);
		this.dict 		= dict;

		for(Integer i = 0; i < 6; i++){
			Word hint 	= this.getNewHint(i+1);
			win  		= answer.evaluate(hint);
			if(win){
				messages.win(answer);
				break;
			}
		}
		messages.loss(answer);
	}

	public String answerStr(){
		return answer.toString();
	}

	public Boolean getWin(){
		return this.win;
	}

	private Word getNewHint(Integer tryNumber){

		try{
			Word hint 		= new Word(dict, "");
			Scanner input		= new Scanner(System.in);
			Interface messages 	= new Interface();
			messages.getHint(tryNumber);

			while(true){
				String 	futureHint	= input.next().toLowerCase();
				Pattern pattern 	= Pattern.compile("^[a-z]{5}$");
				Matcher matcher 	= pattern.matcher(futureHint);
				hint 			= new Word(dict, futureHint);

				if((matcher.find()) && (dict.contains(hint))){
					System.out.println("(Tentativa valida)");
					break;
				}
			}
			input.close();
			return hint;
		}
		catch(Exception e){
			System.out.println("Invalid hint!");
			e.printStackTrace();
			return null;
		}	
	}
}

import java.util.Scanner;
import java.util.Pattern;
import java.util.Matcher;

public class Game{

	private Boolean win;

	Game(){
		Interface messages 	= new Interface();
		Dictionary dict 	= new Dictionary();
		Word answer 		= new Word(dict);

		for(Integer i = 0; i < 6; i++){
			Word hint 	= this.getNewHint(i+1);
			win  		= answer.evaluate(hint);
			if(win){
				messages.win(answer);
				break;
			}
		messages.loss(answer);
		}
	}

	public String answerStr(){
		return answer.toString();
	}

	public Boolean getWin(){
		return this.win;
	}

	private String getNewHint(Integer tryNumber){
		try{
			Word hint;
			Boolean gotAHint 	= false;
			Scanner input		= new Scanner(System.in);
			Interface messages 	= new Interface();
			messages.getHint(tryNumber);

			while(!gotAHint){
				String futureHint	= input.next().toLowerCase();
				Pattern pattern 	= Pattern.compile("^[a-z]{5}$");
				Matcher matcher 	= pattern.matcher(futureHint);
				Boolean gotAHint	= matcher.find();

				if(!gotAHint){
					hint = new Word(dict, futureHint);
					gotAHint = dict.contains(hint);
				}
			}
			System.out.println("(Tentativa vália)");
			return hint;
		}
		catch(Exception e){
			System.out.println("Invalid hint!");
		}	
		input.close();
	}
}

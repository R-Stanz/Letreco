import java.util.Scanner;
import java.util.Pattern;
import java.util.Matcher;

public class Game{

	private Word 		answer;
	private Word 		hint;
	private Interface 	messages;
	private Dictionary dict = new Dictionary();
	private Boolean win;
	Scanner input		= new Scanner(System.in);

	Game(){
		answer = new Word(dict);
		for(Integer i = 0; i < 6; i++){
			this.getNewHint(i+1);
			win = answer.evaluate(hint);
			if(win) break;
		}
	}

	public Boolean getWin(){
		return this.win;
	}

	private void getNewHint(Integer tryNumber){
		try{
			Boolean gotAHint = false;
			messages.getHint(tryNumber);
			while(!gotAHint){
				String futureHint	= input.nextLine().toLowerCase();
				Pattern pattern 	= Pattern.compile("^[a-z]{5}$");
				Matcher matcher 	= pattern.matcher(futureHint);
				Boolean gotAHint	= matcher.find();

				if(!gotAHint){
					hint = new Word(dict, futureHint);
					gotAHint = dict.contains(hint);
				}
			}
		}
		catch(Exception e){
			System.out.println("Invalid hint!");
		}	
	}
}

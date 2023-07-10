import java.util.Scanner;
import java.util.Pattern;
import java.util.Matcher;

public class Game{

	private Boolean win;

	Game(){
		Interface messages 	= new Interface();
		Dictionary dict 	= new Dictionary();
		Scanner input		= new Scanner(System.in);
		Word answer 		= new Word(dict);

		for(Integer i = 0; i < 6; i++){
			Word hint 	= this.getNewHint(i+1);
			win  	= answer.evaluate(hint);
			if(win) break;
		}
		input.close();
	}

	public Boolean getWin(){
		return this.win;
	}

	private String getNewHint(Integer tryNumber){
		try{
			Boolean gotAHint = false;
			messages.getHint(tryNumber);
			while(!gotAHint){
				String futureHint	= input.nextLine().toLowerCase();
				Pattern pattern 	= Pattern.compile("^[a-z]{5}$");
				Matcher matcher 	= pattern.matcher(futureHint);
				Boolean gotAHint	= matcher.find();

				if(!gotAHint){
					Word hint = new Word(dict, futureHint);
					gotAHint = dict.contains(hint);
				}
			}
			return hint;
		}
		catch(Exception e){
			System.out.println("Invalid hint!");
		}	
	}
}

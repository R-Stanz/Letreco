import java.util.Scanner;
public class Maestro{

	Maestro(){
		Game 		game;
		Score		score 	 = new Score();
		Interface	messages = new Interface(score);
		Dictionary 	dict 	 = new Dictionary();

		messages.initial();
		Scanner input = new Scanner(System.in);
		while(true){
			messages.recap();
			
			game 		= new Game(dict);

			if(game.getWin())
				score.addWin();
			else
				score.addLoss();
			
			if(messages.ending())
				break;	
		}
	}


	public static void main(String[] args){
		Maestro play = new Maestro();
	}
}

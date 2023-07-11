public class Maestro{

	Maestro(){
		Game 		game;
		Score		score 	 = new Score();
		Interface	messages = new Interface(score);
		Dictionary 	dict 	 = new Dictionary();

		messages.initial();
		while(true){
			messages.recap();
			game 		= new Game(dict);

			if(game.getWin())
				score.addWin();
			else
				score.addLoss();

			if(this.stop())
				break;	
		}
	}

	private Boolean stop(){
		Interface messages = new Interface();
		return messages.ending();
	}

	public static void main(String[] args){

		Maestro play = new Maestro();
	}
}

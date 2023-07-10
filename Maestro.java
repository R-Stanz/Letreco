public class Maestro{

	Maestro(){
		Game 		game;
		Score		score 	 = new Score();
		Interface	messages = new Interface(score);
		messages.initial();
		while(true){
			messages.recap();
			game = new Game();

			if(game.getWin()) 	score.addWin();
			else			score.addLoss();

			if(this.stop())
				break;	
		}
	}

	private Boolean stop(){
		return messages.ending(score);
	}
}

public class Maestro{

	private Interface 	messages;
	private Score		score = new Score();
	private Game		game;

	Maestro(){
		this.getNewAnswer(); 
	}

	public void begin(){
		messages.initial();
		while(true){
			messages.recap(score);
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

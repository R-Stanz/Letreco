public class Maestro{

	private Interface 	messages;
	private Score		score;
	private Game		game;

	Maestro(){
		this.getNewAnswer(); 
	}

	public void begin(){
		messages.initialMsg();
		while(true){
			messages.recapMsg(score);
			game = new Game();

			if(game.getWin()) 	score.addWin();
			else			score.addLoss();

			if(this.stop()) {
				return ;	
			}
		}
	}

	private Boolean stop(){
		return messages.endingMsg(score);
	}
}

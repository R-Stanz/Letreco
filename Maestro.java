public class Maestro{

	private Interface 	messages;
	private Score		score;
	private Game		game;

	Maestro(){
		this.getNewAnswer(); 
	}

	public void begin(){
		while(true){
			game = new Game();

			if(game.getWin()) 	score.addWin();
			else			score.addLoss();

			if(this.stop()) {
				return ;	
			}
		}
	}

	private Boolean stop(){
		messages.printFinalMsg();
	}
}

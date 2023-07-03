public class Maestro{

	private Word 		answer;
	private Interface 	messages;
	private Game		game;

	Maestro(){
		this.getNewAnswer(); 
	}

	public void begin(){
		while(true){
			game.play(answer);
			if(this.stop()) return ;	
		}
	}

	private void stop(){
		messages.printFinalMsg();
	}
}

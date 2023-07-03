public class Maestro{

	private Word 		answer;
	private Word 		hint;
	private Interface 	messages;

	Maestro(){
		this.getNewAnswer(); 
	}

	public void start(){
		while(true){
		}
	}

	private void play(){
		for(Integer i = 0; i < 6; i++){
			this.getNewHint();
			Boolean stopMarker = answer.evaluate(hint);
			if(stopMarker) break;
		}
		messages.printFinalMsg();
	}

	private void getNewHint(){
	}
}

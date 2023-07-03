public class Game{

	private Word 		hint;
	private Interface 	messages;

	Game(){}

	public void play(Word answer){
		for(Integer i = 0; i < 6; i++){
			this.getNewHint();
			Boolean isCorrect = answer.evaluate(hint);
			if(isCorrect) break;
		}
	}

	private void getNewHint(){
	}
}

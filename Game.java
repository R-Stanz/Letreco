public class Game{

	private Boolean win;
	private Word answer;

	Game(Dictionary dict){
		Interface messages 	= new Interface();
		answer 			= new Word(dict);

		for(Integer i = 0; i < 6; i++){
			Word hint 	= messages.getNewHint(i+1, dict);
			win  		= answer.evaluate(hint);
			if(win){
				messages.win(answer);
				return;
			}
		}
		messages.loss(answer);
	}

	public String answerStr(){
		return answer.toString();
	}

	public Boolean getWin(){
		return this.win;
	}
}

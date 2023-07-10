public class Score{

	private Integer wins;
	private Integer losses;

	Score(){
		wins 	= 0;
		losses 	= 0;
	}
	
	public Integer getWins(){
		return this.wins;
	}

	public Integer getLosses(){
		return this.losses;
	}

	public Integer getNumbOfMatches(){
		return (this.wins+this.losses);
	}

	public void addWin(){
		wins += 1;
	}

	public void addLoss(){
		losses += 1;
	}
}

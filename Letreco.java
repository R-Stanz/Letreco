public class Letreco{

	public static void main(String[] args){
		Messages	message = new Messages();
		Game		game 	= new Game();

		message.initial();
		while(true){
			message.recap();
			
			Boolean win = game.run();

			if(message.ending())
				break;	
		}
	}
}

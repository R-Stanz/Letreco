public class Letreco{

	public static void main(String[] args){
		Messages	message = new Messages();
		Game		game 	= new Game();

		message.initial();
		message.recap();

		game.run();
	}
}

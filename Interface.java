import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Interface{

	private Score score;

	Interface(Score score){
		this.score = score;
	}

	public void initial(){
		System.out.println("\t=====================");
		System.out.println("\tBEM-VINDO AO LETREXTO");
		System.out.println("\t=====================");
	}

	public void recap(){
		TimeUnit.SECONDS.sleep(5);
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("\tInstrucoes:");
		System.out.println("\t- O computador escolherá"+
			       	   "uma palavra aleatória de"+
				   "cinco letras.");
		System.out.println("\t- Você tem seis tentativa"+
				   " para adivinhar a palavra");
		System.out.println("\t- Após cada palpite, voc"+
				   " ê receberá feedback sobr"+
				   "e o seu pate:");
		System.out.println("\t\t- Um '+' indica uma letra"+
			       	   " correta na posição corret");
		System.out.println("\t\t- Um '-' indica uma letra"+
				   " correta na posição errad");
		System.out.println("\t\t- Um '*' indica uma letra"+
			           " incorreta.");
		System.out.println("\n\n===========================");
		System.out.println("Você já jou: " + 
				   score.getNumbOfMatches() +
				   " partidas");
		System.out.println("\n===========================");
		System.out.println("Voc� j� ganhou: " + 
				   score.getWins() +
				   " partidas");
		System.out.println("\n===========================");
		System.out.println("Vocêjáperdeu : " + 
				   score.getLosses() +
				   " partidas");
		System.out.println("\n===========================");
		System.out.println("\nVamos começar!"); 
	}

	public void getHint(Integer tryNumber){
		System.out.println("\nDigite palpite #" + tryNumber + 
				   ": ");
	}

	public void evaluateRecap(String answer){
	       System.out.println("\nPalpite:\t" + answer);
	       System.out.println("Resultado:\t");
	}

	public void rightPosition(){
		System.out.println("+");
	}

	public void rightChar(){
		System.out.println("-");
	}

	public void wrongChar(){
		System.out.println("*");
	}

	public void win(Word answer){
		System.out.println("Parabéns! Você adivinhou " +
			     "a palavra '" + answer.toString() + 
		             "' corretamente!");
	}

	public void loss(Word answer){
		System.out.println("Infelizmente não foi dessa ve" +
			     "! A palavra era '"+ answer.toString()+
			     "'.");
	}

	public Boolean ending(){
		Scanner input = new Scanner(System.in);
		try{
			System.out.println("Gostaria de parar (S/s) ? ");
			String answer = input.next().toLowerCase();
			if(answer.equals("s")){
				System.out.println("\nObrigado por jogar Letrexto!"); 
				return true;
			}
			else{
				System.out.println("\nIndo para mais uma rodada!");
				return false;
			}
		}
		catch(Exception e){
			System.out.println("Something went wrong at the ending!");
		}
	}
}

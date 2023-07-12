/* 
 * This class is mainly so it can be
 * easier to control to messages that
 *  appear to the users and also so
 *  the program can easily create a
 *   feature to implemt logging the
 *           whole gameplay
 */
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.util.ArrayList;


public class Interface{

	private Score score;

	Interface(Score score){
		this.score = score;
	}

	Interface(){}

	public void initial(){
		System.out.println("\t=====================");
		System.out.println("\tBEM-VINDO AO LETREXTO");
		System.out.println("\t=====================");
	}

	public void recap(){
		try{
			TimeUnit.SECONDS.sleep(2);
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("\tInstrucoes:");
			System.out.println("\t- O computador escolhera"+
					   "uma palavra aleatoria de"+
					   "cinco letras.");
			System.out.println("\t- Voce tem seis tentativas"+
					   " para adivinhar a palavra");
			System.out.println("\t- Apos cada palpite, voc"+
					   " e recebera feedback sobr"+
					   "e o seu pate:");
			System.out.println("\t\t- Um '+' indica uma letra"+
					   " correta na posicao correta.");
			System.out.println("\t\t- Um '-' indica uma letra"+
					   " correta na posicao errada");
			System.out.println("\t\t- Um '*' indica uma letra"+
					   " incorreta.");
			System.out.println("\n\n===========================");
			System.out.println("Voce ja jogou:   " + 
					   score.getNumbOfMatches() +
					   " partidas");
			System.out.println("\n===========================");
			System.out.println("Voce ja ganhou:  " + 
					   score.getWins() +
					   " partidas");
			System.out.println("\n===========================");
			System.out.println("Voce ja perdeu : " + 
					   score.getLosses() +
					   " partidas");
			System.out.println("\n===========================");
			System.out.println("\nVamos comecar!"); 
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public Word getNewHint(Integer tryNumber, Dictionary dict){
		try{
			Word hint 		= new Word(dict, "");
			Scanner input		= new Scanner(System.in);

			System.out.println("\n\nDigite palpite #" + tryNumber + ": ");

			while(true){
				String 	futureHint	= input.next().toLowerCase();
				Pattern pattern 	= Pattern.compile("^[a-z]{5}$");
				Matcher matcher 	= pattern.matcher(futureHint);
				hint 			= new Word(dict, futureHint);

				if((matcher.find()) && (dict.contains(hint))){
					System.out.println("(Tentativa valida)");
					break;
				}
				else
					System.out.println("(Tentativa invalida)");
			}
			input.close();
			return hint;
		}
		catch(Exception e){
			System.out.println("Invalid hint!");
			//e.printStackTrace();
			Word randomHint = new Word(dict);
			return randomHint;
		}	
	}

	public void evaluateRecap(String answer){
		String adjAnswer = "";
		for(Character c : answer.toCharArray()){
			adjAnswer += c.toString();
			adjAnswer += " ";
		}
	       	System.out.println("\nPalpite:\t" + adjAnswer);
	       	System.out.print("Resultado:\t");
	}

	public void resultEvaluation(ArrayList<Character> evaluationArr){
		for(Character c : evaluationArr){
			System.out.print(c.toString());
			System.out.print(" ");
		}
	}

	public void win(Word answer){
		System.out.println("\n\nParabens! Voce adivinhou " +
			     "a palavra '" + answer.toString() + 
		             "' corretamente!");
	}

	public void loss(Word answer){
		System.out.println("\n\nInfelizmente nao foi dessa vez" +
			     "! A palavra era '"+ answer.toString()+
			     "'.");
	}

	public Boolean ending(){
		Scanner input = new Scanner(System.in);
		try{
			System.out.println("Gostaria de parar? (S/s) ");
			String answer = input.next().toLowerCase();

			if(answer.equals("s")){
				System.out.println("\nObrigado por jogar Letrexto!"); 
				input.close();
				return true;
			}
			else{
				System.out.println("\nIndo para mais uma rodada!");
				input.close();
				return false;
			}
		}
		catch(Exception e){
			System.out.println("Something went wrong at the ending!");
			// e.printStackTrace();
			input.close();
			return true;
		}
	}
}

//import java.util.Scanner;
//import java.util.Random;
//
//public class headsORtails {
//
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//      	
//		System.out.print("Guess which will have more: heads or tails? ");
//	    String headsOrTailsGuess = sc.nextLine();
//	    System.out.println(headsOrTailsGuess);
//	    if (headsOrTailsGuess != "heads" || headsOrTailsGuess != "tails") {
//	    	System.out.println("******Please enter heads or tails spelled correctly********");
//	    	main(args); 			
//	    }
//	    
//	    System.out.print(" How many times shall we flip a coin? : ");
//	    int numberOfFlips = sc.nextInt();
//	
//	    
//	    Random random = new Random();
//        int coin_flip = random.nextInt(numberOfFlips);
//        
//        System.out.println(coin_flip);
//	    
//	    
//		
//	}
//
//}
//




import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class headsORtails {
   
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String headsOrTailsGuess = "";
		int  numberOfFlips =0;		
		int correctCount =0;

		
		String guessRight;
		int randomCoin;
		int userCoin = -1;
		final int HEADS = 0;
		final int TAILS = 1;
		double percentCorrect = 0.0;
		Random rand = new Random();
		
     // depends on response set userCoin value to 0 or 1 ---------------------
		do {
			System.out.println("Guess which will have more: heads or tails?");
			headsOrTailsGuess = sc.nextLine().toLowerCase();
			if (headsOrTailsGuess.equals("heads")) {
				userCoin = HEADS;
			} else if (headsOrTailsGuess.equals("tails")) {
				userCoin = TAILS;
			} else {
				headsOrTailsGuess = "";
			}		
		} while (headsOrTailsGuess == "");

	
	// 	check Frequency of Flip usewr wants to perform ---------------------------------
		do {
			System.out.println("How many times shall we flip a coin?");
			numberOfFlips = sc.nextInt();
  		} while (numberOfFlips <= 0);
		
		
	// run the loop and print entries of heads or tails based on random function --------   	
		for (int i = 1; i<=numberOfFlips; i++) {
			// prints random number between 0 and 1
			randomCoin = rand.nextInt(2);
			guessRight = "";
			
			
			switch(randomCoin) {
				case HEADS:	
					if (userCoin == HEADS) {
						correctCount += 1;
						guessRight = "*";
					}
					System.out.println(i+ " heads" + guessRight);
					break;
					
				case TAILS:	
					if (userCoin == TAILS) {
						correctCount += 1;
						guessRight = "*";
					}
					System.out.println(i+ " tails" + guessRight);
					break;
				default:
					System.out.println("Something went Wrong");
			}
			
		}
		
		System.out.println("\nYour guess, "+ headsOrTailsGuess+", came up "+ correctCount +
				" time" + (correctCount != 1 ? "s." : "."));
		
		percentCorrect = (double)correctCount/numberOfFlips*100.0;
	//	System.out.println("That's "+ percentCorrect +"%. ");
    //  round up figure using math.round ()		
		System.out.println("That's "+ Math.round(percentCorrect) +"%. ");

	}
}

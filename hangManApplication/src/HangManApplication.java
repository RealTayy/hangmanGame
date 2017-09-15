import java.util.Scanner;

public class HangManApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Print opening statement
        System.out.print("Hello! Welcome to the most intense game you'll ever play in your life!\n"
                + "Perhaps you've heard of it before... It's called HANGMAN!\n"
                + "The life of a innocent person hangs on your ability to guess a word...\n"
                + "\n"
                + "No Pressure! Here are the rules:\n"
                + " >A word will be chosen at random. It could be anything! Maybe even \"anything\"!\n"
                + " >You will be given a couple of blanks. Each blank represents a letter in the word\n"
                + " >You will guess a letter and if that letter is in the word it will be revealed!\n"
                + " >If the letter isn't in the word. Our friend will get one step closer to death...\n"
                + " >Guess all the letters correctly and you win! And our innocent friend is free!\n"
                + " >Guess enough letters word... and say goodbye to our guy :<\n"
                + "\n"
                + "You ready for this kind of responsibility? Let's start! GOOD LUCK! You'll need it\n"
        );

        boolean wantsToPlay = true;

        while (wantsToPlay) {
            // Game starts
            Hangman game = new Hangman();
            System.out.println("Lets go! I'm thinking of a word...");
            System.out.println();

            // If player hasn't lost or won yet do this stuff...
            boolean playerWonOrLost = false;
            while (!playerWonOrLost) {
                // Draw game area
                game.drawGameArea();
                // Player guesses
                System.out.println("Type a Letter you think is in the word...");
                char letterGuessed = in.next().toLowerCase().charAt(0);
                game.playerGuesses(letterGuessed);
                // Checks to see if you have won or lost
                playerWonOrLost = game.isGameOver();
            }

            // See if player still wants to play
            System.out.println("Would you like to play another round? Type \"Y\" if you would!");
            wantsToPlay = (in.next().toLowerCase().charAt(0) == 'y');
        }

        // Player does not want to play. Exit message
        System.out.println("Alright then... See you next time!");
    }
}

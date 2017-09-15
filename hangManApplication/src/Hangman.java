import java.util.*;

public class Hangman {

    boolean playerWon;
    boolean playerLost;
    int wordIndex;
    int wrongGuesses;
    String word;
    String wordHint;

    ArrayList<Character> lettersGuessed = new ArrayList<>();

    LinkedList<String[]> wordBank = new LinkedList<>();

    public Hangman() {
        playerWon = false;
        playerLost = false;
        wrongGuesses = 0;
        loadWords();
        loadRandomWord();

    }

    public void loadWords() {      //WORD       //HINT
        wordBank.add(new String[]{"anything", "Used to indicate a range"});
        wordBank.add(new String[]{"hello", "A greeting"});
        wordBank.add(new String[]{"world", "A very large place"});
        wordBank.add(new String[]{"sleepy", "Feeling you get at night"});
    }

    public void loadRandomWord() {
        int maxNum = wordBank.size();
        Random rand = new Random();
        wordIndex = Math.abs(rand.nextInt() % maxNum);
        word = wordBank.get(wordIndex)[0];      //Retrieves the WORD from loadWords
        wordHint = wordBank.get(wordIndex)[1];  //Retrieves the HINT from loadWords
    }

    public void drawGameArea() {
        switch (wrongGuesses) {
            case 0:
                drawZeroWrong();
                break;
            case 1:
                drawOneWrong();
                break;
            case 2:
                drawTwoWrong();
                break;
            case 3:
                drawThreeWrong();
                break;
            case 4:
                drawFourWrong();
                break;
            case 5:
                drawFiveWrong();
                break;
            case 6:
                drawSixWrong();
        }

        StringBuilder wordSB = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (hasLetterBeenGuessed(word.charAt(i))) wordSB.append(word.charAt(i) + " ");
            else wordSB.append("_ ");
        }
        System.out.println("    Word: " + wordSB.toString());
        System.out.println("    Hint: " + wordHint);
    }

    public boolean hasLetterBeenGuessed(char c) {
        for (char d : lettersGuessed) {
            if (c == d) return true;
        }
        return false;
    }

    public void drawZeroWrong() {
        System.out.print(" //:::::::::::::::::::::::   \n"
                + " ||                      |   \n"
                + " ||                          \n"
                + " ||                          \n"
                + " ||                          \n"
                + " ||                          \n"
                + " ||                          \n"
                + " ||========================= \n"
                + " || Wrong Guesses Left: 5 || \n"
                + " ||========================= \n"
        );
    }

    public void drawOneWrong() {
        System.out.print(" //:::::::::::::::::::::::   \n"
                + " ||                      |   \n"
                + " ||                      O   \n"
                + " ||                          \n"
                + " ||                          \n"
                + " ||                          \n"
                + " ||                          \n"
                + " ||========================= \n"
                + " || Wrong Guesses Left: 4 || \n"
                + " ||========================= \n"
        );
    }

    public void drawTwoWrong() {
        System.out.print(" //:::::::::::::::::::::::   \n"
                + " ||                      |   \n"
                + " ||                      O   \n"
                + " ||                      |   \n"
                + " ||                      |   \n"
                + " ||                          \n"
                + " ||                          \n"
                + " ||========================= \n"
                + " || Wrong Guesses Left: 3 || \n"
                + " ||========================= \n"
        );
    }

    public void drawThreeWrong() {
        System.out.print(" //:::::::::::::::::::::::   \n"
                + " ||                      |   \n"
                + " ||                      O   \n"
                + " ||                    --|   \n"
                + " ||                      |   \n"
                + " ||                          \n"
                + " ||                          \n"
                + " ||========================= \n"
                + " || Wrong Guesses Left: 2 || \n"
                + " ||========================= \n"
        );
    }

    public void drawFourWrong() {
        System.out.print(" //:::::::::::::::::::::::   \n"
                + " ||                      |   \n"
                + " ||                      O   \n"
                + " ||                    --|-- \n"
                + " ||                      |   \n"
                + " ||                          \n"
                + " ||                          \n"
                + " ||========================= \n"
                + " || Wrong Guesses Left: 1 || \n"
                + " ||========================= \n"
        );
    }

    public void drawFiveWrong() {
        System.out.print(" //:::::::::::::::::::::::   \n"
                + " ||                      |   \n"
                + " ||                      O   \n"
                + " ||                    --|-- \n"
                + " ||                      |   \n"
                + " ||                     /     \n"
                + " ||                          \n"
                + " ||========================= \n"
                + " || Wrong Guesses Left: 0 || \n"
                + " ||========================= \n"
        );
    }

    public void drawSixWrong() {
        System.out.print(" //:::::::::::::::::::::::   \n"
                + " ||                      |   \n"
                + " ||                      O   \n"
                + " ||                    --|-- \n"
                + " ||                      |   \n"
                + " ||                     / \\  \n"
                + " ||                          \n"
                + " ||========================= \n"
                + " ||                       || \n"
                + " ||========================= \n"
        );
    }

    public void playerGuesses(char c) {
        Scanner in = new Scanner(System.in);
        boolean charAlreadyGuessed = hasLetterBeenGuessed(c);

        // Keep redrawing and asking for another letter if letter has been guessed before.
        while (charAlreadyGuessed) {
            drawGameArea();
            System.out.println("The letter " + c + " has already been guessed. Try a different letter");
            c = in.next().toLowerCase().charAt(0);
            charAlreadyGuessed = hasLetterBeenGuessed(c);
        }

        // Add letter guessed to array whether its in word or not
        lettersGuessed.add(c);

        if (isCharInWord(c)) {
            System.out.println("_________________________________________________");
            System.out.println("Nice! The letter " + c + " is in the word!");
        } else {
            System.out.println("Uh oh! the letter " + c + " is not in the word...");
            wrongGuesses++;
        }
    }

    public boolean isCharInWord(char c) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    public boolean isGameOver() {
        if (wrongGuesses == 6) {
            // Player loses
            System.out.println("OH NO! You lost! This must be the saddest day of your");
            System.out.println("The word you were looking for is " + word + "!");
            System.out.println("Better luck next time...");
            System.out.println();
            return true;
        }
        if (hasPlayerWon()) {
            //Player wins!
            playerWon = true;
            System.out.println("Congrats! You've saved the innocent and guessed the word correctly!");
            System.out.println("The word you were looking for is " + word + "!");
            System.out.println("Next time won't be so easy...!");
            System.out.println();
            return true;
        }
        return false;
    }

    public boolean hasPlayerWon() {
        for (int i = 0; i < word.length(); i++) {
            if (!hasLetterBeenGuessed(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }


}

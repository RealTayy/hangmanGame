import java.util.*;

public class Hangman {

    boolean playerWonOrLost;
    int wordIndex;
    int wrongGuesses;
    String word;
    String wordHint;

    ArrayList<Character> lettersGuessed = new ArrayList<>();

    LinkedList<String[]> wordBank = new LinkedList<>();

    public Hangman() {
        playerWonOrLost = false;
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

        for (int i = 0; i < word.length(); i++){
            if (hasLetterBeenGuessed(word.charAt(i))) wordSB.append(word.charAt(i) + " ");
            else wordSB.append("_ ");
        }
        System.out.println("    Word: " + wordSB.toString());
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

    }

    public void isGameOver() {

    }


}

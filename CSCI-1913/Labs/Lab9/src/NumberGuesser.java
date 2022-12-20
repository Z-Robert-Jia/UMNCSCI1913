import java.util.Random;

/**
 * This game lets user guess a number between a given range!
 */
public class NumberGuesser extends Game{
    private Random rng;
    private int maxNumber;
    private int maxGuesses;
    private int secretNum;
    private int count;
    private boolean correctness;

    /**
     * Initilize all attributes except secretNum, count, correctness
     * @param rng
     * @param maxNumber
     * @param maxGuesses
     */
    public NumberGuesser(Random rng, int maxNumber, int maxGuesses){
        this.rng = rng;
        this.maxNumber = maxNumber;
        this.maxGuesses = maxGuesses;
    }


    @Override
    public String getName() {
        return "NumberGuesser";
    }

    /**
     * initialize attributes that haven't yet been initialized and return a message with those
     * attributes' values
     * @return
     */
    @Override
    protected String prepToPlay() {
        secretNum = rng.nextInt(maxNumber) + 1;
        count = 0;
        correctness = false;
        return "I've picked a number 1 to " + maxNumber + ". You get " + maxGuesses + " guesses to guess it";
    }


    /**
     * The ganme is only over when they used up their guesses or they guessed the correct answer
     * @return
     */
    @Override
    protected boolean isOver() {
        if (correctness || maxGuesses == count){
            return true;
        }
        return false;
    }


    /**
     * Accepts only POSITIVE integers
     * @param move
     * @return
     */
    @Override
    protected boolean isValid(String move) {
        if (move.length() == 0){
            return false;
        }
        for (int i = 0; i < move.length(); i++) {
            char c = move.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Process the users guess. Return
     * @param move
     * @return
     */
    @Override
    protected String processMove(String move) {
        count++;
        int guess = Integer.parseInt(move);
        if (guess<secretNum){
            return "Too Low";
        } else if (guess > secretNum) {
            return "Too High";
        }
        else{
            correctness = true;
            return "That's it!";
        }
    }

    @Override
    protected String finalMessage() {
        return "The number was: " + secretNum;
    }
}

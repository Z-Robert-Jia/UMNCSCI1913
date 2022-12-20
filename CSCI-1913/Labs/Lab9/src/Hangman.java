/**
 * This game is about guessing the correct words within the given chances. The alphabet you guess each time
 * would show out if they are correct.
 */
public class Hangman extends Game{
    private WordsList words;
    private int minWordLen;
    private int maxWordLen;
    private int maxGuesses;
    private String secretWord;
    private int count;
    private char[] clueString;

    public Hangman(WordsList words, int minWordLen, int maxWordLen, int maxGuesses){
        this.words = words;
        this.minWordLen = minWordLen;
        this.maxWordLen = maxWordLen;
        this.maxGuesses = maxGuesses;
    }

    /**
     * initialized not yet initialized variables. set all chars in clueString to '_'
     * @return
     */
    @Override
    protected String prepToPlay() {
        secretWord = words.getWord(minWordLen,maxWordLen);
        count = 0;
        clueString = new char[secretWord.length()];
        for (int i = 0; i < clueString.length; i++){
            clueString[i] = '_';
        }
        return "I've picked a " + secretWord.length() + " letter word. " +
                "Guess letters you think are in the word. You get " +
                maxGuesses + " guesses.";
    }

    /**
     * The game if over is they used up their chances or they guessed all the answers
     * @return
     */
    @Override
    protected boolean isOver() {
        if (maxGuesses==count){
            return true;
        }
        for (char ele : clueString){
            if (ele == '_'){
                return false;
            }
        }
        return true;
    }

    /**
     * Strictly 1 letter is allowed each time
     * @param move
     * @return
     */
    @Override
    protected boolean isValid(String move) {
        if (move.length()!=1){
            return false;
        }
        if (!Character.isAlphabetic(move.charAt(0))){
            return false;
        }
        return true;
    }

    /**
     * check if the guess is in the word return the words where the alphabet was guessed correctly
     * @param move
     * @return
     */
    @Override
    protected String processMove(String move) {
        String temp = "";
        count++;
        if (secretWord.contains(move)){
            for (int i = 0; i<secretWord.length();i++){
                if (secretWord.substring(i,i+1).equals(move)){
                    clueString[i] = move.charAt(0);
                }
            }
        }
        for (char ele : clueString){
            temp += ele;
        }
        return temp;

    }


    @Override
    protected String finalMessage() {
        return "The word was: " + secretWord;
    }

    @Override
    public String getName() {
        return "Hangman";
    }
}

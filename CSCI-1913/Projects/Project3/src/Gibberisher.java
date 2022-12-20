
public class Gibberisher {
    private Trie<CharBag> model;
    private int segmentSize;
    private int count;
    public Gibberisher(int segmentSize){
        this.segmentSize = segmentSize;
        count = 0;
        model = new Trie<>();
    }

    /**
     * Use the LetterSample class to generate LetterSamples, and then, for each resulting LetterSample:
     * ∗ add this sample into the model. This will mean using the string from the Letter sample
     * to get the appropriate CharBag, and then adding the char from the LetterSample to that CharBag.
     * @param args
     */
    public void train(String[] args){
        for (String arg : args){
            LetterSample[] samples = LetterSample.toSamples(arg,segmentSize);
            for (LetterSample sample : samples){
                count++;
                // For each sample, put nextLetter to the charBag in segment position down the Trie
                // if null,
                // Unpack the sample first
                String seg = sample.getSegment();
                char nLetter = sample.getNextLetter();
                // If the first sample for the given segment
                if (model.get(seg)==null) {
                    model.put(seg, new CharBag());
                }
                CharBag before = model.get(seg);
                model.get(seg).add(nLetter);

            }
        }

    }

    public int getSampleCount() {
        return count;
    }

    /**
     * The final function that generates a random English word based on the training data!!!
     * @return
     */
    public String generate(){
        String str = "";
        CharBag nextBag = model.get(str);
        char nextChar = nextBag.getRandomChar();
        str += nextChar;
        while (nextChar != LetterSample.STOP){
            nextBag = model.get(str.substring(Math.max(str.length()-segmentSize,0)));
            if (nextBag==null){
                return str;
            }
            nextChar = nextBag.getRandomChar();
            str += nextChar;
        }
        return str.substring(0,str.length()-1);
    }
}

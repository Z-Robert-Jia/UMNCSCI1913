import java.util.Random;

public class CharBag {
    private int[] bag;

    public CharBag(){
        // Automatically initializes to 0
        bag = new int[27];
    }

    /**
     * This function receives a char and returns it's corresponding position in the bag. 26 if not alphabet
     * @param c
     */
    public static int getPos(char c){
        if(Character.isAlphabetic(c)){
            return (int)Character.toLowerCase(c)-'a';
        }
        else{
            return 26;
        }
    }

    /**
     * This function should add a char to the charBag. If the char is an
     * uppercase letter, it should be converted to a lowercase letter before adding
     * @param c
     */
    public void add(char c){
        int pos = getPos(c);
        bag[pos]++;
    }

    /**
     * This function should remove a char from the charBag.
     * If the input letter is not in the charBag no change should happen.
     * @param c
     */
    public void remove(char c){
        int pos = getPos(c);
        if (bag[pos]>0){
            bag[pos]--;
        }
    }

    /**
     * gets how many times a given char is in the CharBag
     * @param c
     * @return
     */
    public int getCount(char c){
        int pos = getPos(c);
        return bag[pos];
    }


    /**
     * returns the total size of the charBag
     * @return
     */
    public int getSize(){
        int sum = 0;
        for (int ele : bag){
            sum += ele;
        }
        return sum;
    }


    /**
     * toString method
     * @return
     */
    @Override
    public String toString() {
        String ret = "CharBag{";
        for (int i = 0; i<26; i++){
            ret += (char)('a'+i);
            ret += ":" + bag[i] + ", ";
        }
        ret += ".:"+bag[26];
        ret += "}";
        return ret;
    }

    /**
     * This function should return a randomly chosen char from the chars in the char bag
     * @return
     */
    public char getRandomChar(){
        Random r = new Random();
        int count;
        if (getSize()==0){
            count = 0;
        }
        else{
            count = r.nextInt(getSize());
        }
        for (char alphabet = 'a'; alphabet<='z';alphabet++){
            count -= getCount(alphabet);
            if (count < 0){
                return alphabet;
            }
        }
        return '.';
    }


}

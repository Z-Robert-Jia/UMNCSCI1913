// Members: Zheng Robert Jia
// Daniyal Khan
public class CaesarCipher {
    private int key;


    /**
     * Constructor that initializes the key value
     * @param key
     */
    public CaesarCipher(int key){
        this.key = key;
    }

    /**
     *
     * @return if the key is valid
     */
    public boolean isValid(){
        if (key%26==0){
            return false;

        }
        else {
            return true;
        }
    }

    /**
     * Helper method to do alphabet rotations
     * @param alphabet
     * @param rotation
     * @return
     */
    private char rotate(char alphabet, int rotation){
        char intAlphabet;
        // +26 % 26 to prevent negative numbers
        intAlphabet = (char) (( ((alphabet - 'a' + rotation) % 26+26))%26 + 'a');
        return intAlphabet;
    }

    /**
     *
     * @param mes
     * @return the encrpted message
     */
    public String encrypt(String mes){
        //split the string
        //rotate each letter
        String encrptedMes = mes.toLowerCase();
        char[] lst = encrptedMes.toCharArray();
        String ret = "";
        for (char ele : lst){
            if (Character.isAlphabetic(ele)) {
                ret += rotate(ele, key);
            }
            else {
                ret += ele;
            }
        }
        return ret;
    }

    /**
     *
     * @param mes
     * @return the decrpted String
     */
    public String decrypt(String mes){
        String encrptedMes = mes.toLowerCase();
        char[] lst = encrptedMes.toCharArray();
        String ret = "";
        for (char ele : lst){
            if (Character.isAlphabetic(ele)) {
                ret += rotate(ele, -key);
            }
            else{
                ret += ele;
            }
        }
        return ret;
    }

    /**
     *
     * @return a string including the key value
     */
    @Override
    public String toString() {
        return "Caesar(" + key + ")";
    }
}

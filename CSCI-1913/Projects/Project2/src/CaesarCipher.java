// Members: Zheng Robert Jia
// Daniyal Khan
public class CaesarCipher extends BaseCipher{
    private int key;


    /**
     * Constructor that initializes the key value
     * @param key
     */
    public CaesarCipher(int key){
        super("CaesarCipher");
        this.key = key;
    }

    /**
     *
     * @return if the key is valid
     */
    public boolean isValid(){
        if (key>25 || key<1){
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
        mes = super.encrypt(mes);
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

    /**
     * Two CaesarCipher objects are the same if they have the same key value
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (obj instanceof CaesarCipher){
            CaesarCipher otherCC = (CaesarCipher) obj;
            return otherCC.key==this.key;
        }
        return false;
    }
}

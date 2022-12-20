import java.util.Arrays;

public class SuperCipher extends BaseCipher{

    private BaseCipher[] ciphers;

    public SuperCipher(BaseCipher[] ciphers){
        super("SuperCipher");
        this.ciphers = ciphers;
    }

    /**
     * A SuperCipher is valid if, and only if, each base cipher is valid.
     * @return
     */
    public boolean isValid(){
        for (BaseCipher ele : ciphers){
            if (ele instanceof CaesarCipher && !ele.isValid()){
                return false;
            }
        }
        return true;
    }

    /**
     * apply each cipher provided to the constructor, in the order provided
     * @param mes
     * @return
     */
    public String encrypt(String mes){
        for (BaseCipher ele : ciphers){
            mes = ele.encrypt(mes);
        }
        return mes;
    }

    /**
     * reverse each cipher provided to the constructor
     * @param mes
     * @return
     */
    public String decrypt(String mes){
        for (int i = ciphers.length-1; i >=0; i--){
            mes = ciphers[i].decrypt(mes);
        }
        return mes;
    }

    /**
     * To string method that joins each cipher
     * @return
     */
    @Override
    public String toString() {
        String ret = "SuperCipher(";
        for (BaseCipher ele : ciphers){
            ret += ele.toString();
            ret += " | ";
        }
        ret = ret.substring(0,ret.length()-3);
        ret += ")";
        return ret;
    }

    /**
     * A superCipher is equal to another SuperCipher if and only if it’s chain of ciphers match
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
        if (! (obj instanceof SuperCipher)){
            return false;
        }
        SuperCipher other = (SuperCipher) obj;
        if (Arrays.equals(this.ciphers,other.ciphers)){
            return true;
        }
        return false;
    }
}

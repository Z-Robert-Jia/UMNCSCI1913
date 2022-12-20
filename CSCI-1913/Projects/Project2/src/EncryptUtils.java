public class EncryptUtils {

    /**
     *  return a new array of strings that is the result of encrypting each String using the cipher
     * @param cipher
     * @param strArr
     * @return
     */
    public static String[] encryptMany(BaseCipher cipher, String[] strArr){
        String[] ret = new String[strArr.length];
        for (int i = 0; i<strArr.length; i++){
            ret[i] = cipher.encrypt(strArr[i]);
        }
        return ret;
    }

    /**
     * return a new array of strings that is the result of decrypting each String using the cipher.
     * @param cipher
     * @param strArr
     * @return
     */
    public static String[] decryptMany(BaseCipher cipher, String[] strArr){
        String[] ret = new String[strArr.length];
        for (int i = 0; i<strArr.length; i++){
            ret[i] = cipher.decrypt(strArr[i]);
        }
        return ret;
    }

}

// Members: Zheng Robert Jia
// Daniyal Khan
public class KnownSpy {
    String name;
    CaesarCipher decode;

    /**
     * Constructor
     * @param name
     * @param decode
     */
    public KnownSpy(String name,CaesarCipher decode){
        this.name = name;
        this.decode = decode;
    }

    /**
     *
     * @return the name of the name of the spy
     */
    public String getName(){
        return name;
    }

    /**
     * decrpt the message if it is sent to the correct spy
     * @param message
     */
    public void decrypt(Message message){
        if (message.getFrom().equals(name)){
            message.setMessage(decode.decrypt(message.getMessage()));
        } else {
            return;
        }
    }

    /***
     * If the sender of the message is one of the known spies the function should return true,
     * otherwise it should return false.
     * @param SpyArr array of know spies
     * @param message
     * @return
     */
    public static boolean isFromSpy(KnownSpy[] SpyArr, Message message){
        for (KnownSpy Spy : SpyArr){
            if (message.getFrom().equals(Spy.name)){
                return true;
            }
        }
        return false;
    }

    /**
     * try decrypting a message without the key
     * @param encryptedMessage
     * @param commonWords
     * @return
     */
    public String tryDecrypt(String encryptedMessage, String commonWords){
        // split commonwords
        // loop from 1-25
        // decrpt messgae, if the message in commonwords, return the correct word
        // finally return null
        String decryptedMessage;
        String[] commArr = commonWords.split(" ");
        for (int i = 1;i<=25;i++){
            decode = new CaesarCipher(i);
            decryptedMessage = decode.decrypt(encryptedMessage);
            for (String words : commArr){
                if (decryptedMessage.equals(words)){
                    return words;
                }
            }
        }
        return null;
    }

}

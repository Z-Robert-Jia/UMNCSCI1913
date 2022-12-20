public class EvenOddCipher extends BaseCipher{

    public EvenOddCipher(){
        super("EvenOddCipher");
    }
    /**
     * encrypt message by putting the even letters in front of the odd letters
     * @param mes
     * @return
     */
    public String encrypt(String mes){
        mes = super.encrypt(mes);
        String first = "";
        String second = "";
        for (int i = 0; i<mes.length();i++) {
            if (i % 2 == 0) {
                first += mes.charAt(i);
            } else {
                second += mes.charAt(i);
            }
        }
        return first.concat(second);
    }

    public String decrypt(String mes){
        int crossover = mes.length()/2 + mes.length()%2;
        char[] even,odd;
        even = mes.substring(0,crossover).toCharArray();
        odd = mes.substring(crossover).toCharArray();
        String temp = "";
        for (int i = 0; i<mes.length();i++) {
            if (i%2==0){
                temp+=even[i/2];
            }
            else{
                temp+=odd[i/2];
            }
        }
        return temp;
    }

    @Override
    public String toString() {
        return "EvenOddCipher";
    }


    /**
     * equal if two obejcts are all EvenOddCipher objects
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        return obj instanceof EvenOddCipher;
    }
}


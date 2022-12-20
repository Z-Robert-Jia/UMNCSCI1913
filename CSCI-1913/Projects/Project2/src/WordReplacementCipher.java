public class WordReplacementCipher extends BaseCipher{
    private String from;
    private String to;
    public WordReplacementCipher(String from, String to){
        super("CaesarCipher");
        this.from = from;
        this.to = to;
    }


    /**
     * Replace all letters with from into to
     * @param mes
     * @return
     */
    public String encrypt(String mes){
        mes = super.encrypt(mes);
        return mes.replace(from,to);
    }

    public String decrypt(String mes){
        return mes.replace(to,from);
    }

    @Override
    public String toString() {
        return String.format("WordReplacementCipher(%s, %s)",from,to);
    }

    /**
     * equal when two objects have same from and to
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
        if (! (obj instanceof WordReplacementCipher)){
            return false;
        }
        WordReplacementCipher other = (WordReplacementCipher) obj;
        if (this.from.equals(other.from)&&this.to.equals(other.to)){
            return true;
        }
        return false;
    }

}

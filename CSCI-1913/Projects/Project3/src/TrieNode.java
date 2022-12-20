public class TrieNode<T>{
    private T value;
    private TrieNode<T>[] nextNodes;

    public TrieNode(){
        value = null;
        nextNodes = new TrieNode[26];
    }

    public T getData(){
        return value;
    }

    public void setData(T value){
        this.value = value;
    }

    /**
     *  returns the TrieNode<T> asso-
     * ciated with the given letter.
     * @param letter
     * @return
     */
    public TrieNode<T> getChild(char letter){
        if (!Character.isLowerCase(letter)){
            return null;
        }
        TrieNode<T> child = nextNodes[CharBag.getPos(letter)];
        if(child == null){
            child = new TrieNode<>();
            nextNodes[CharBag.getPos(letter)] = child;
        }
        return child;
    }
}

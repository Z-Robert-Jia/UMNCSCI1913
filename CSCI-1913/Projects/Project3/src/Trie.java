public class Trie<T> {

    private TrieNode<T> root;

    public Trie(){
        root = new TrieNode<>();
    }

    /**
     * takes a string and returns the appropriate trieNode.
     * @param str
     * @return
     */
    private TrieNode getNode(String str){
        char[] word_split = str.toCharArray();
        TrieNode<T> ret = root;
        for (char character : word_split){
            ret = ret.getChild(character);
        };
        return ret;
    }

    public T get(String str){
        return (T) getNode(str).getData();
    }

    /**
     * sets the data currently stored on the TrieNode associated with the input string to the T value provided.
     * @param str
     * @param data
     * @return
     */
    public T put(String str, T data){
        TrieNode<T> child = getNode(str);
        T temp = get(str);
        child.setData(data);
        return temp;
    }
}

public class TrieTest {
    public static void main(String[] args) {
        // This class is a bit harder to test. There's a lot of how it behaves _internally_
        // that we care about, but which is hard to really expose for testing. I don't think
        // I have an easy way to help you test that unfortunately.

        Trie<Integer> numbers = new Trie<>();
        System.out.println(numbers.get("one") == null); // true

        numbers.put("one", 1);
        System.out.println(numbers.get("one")); // 1
        // (remember the root represents "", then it should have "o" as a child, then "on" etc.)

        System.out.println(numbers.get("two") == null); // true

        numbers.put("two", 2);
        System.out.println(numbers.get("two")); // 2
        numbers.put("two",3);
        System.out.println(numbers.get("two")); // 3


        System.out.println(numbers.get("ten") == null); // true

        numbers.put("ten", 10);
        System.out.println(numbers.get("ten")); // 10
        Trie<CharBag> strings = new Trie<>();
        if (strings.get("asd") == null) {
            System.out.println("NUll check is done. Put operation is done");
            strings.put("asd", new CharBag());

        }
//        System.out.println(strings.get("asd"));
//        strings.get("asd").add('c');
//        strings.put("sdc",new CharBag());
//        strings.get("sdc").add('.');
//        String str = "asd";
//        str += strings.get(str.substring(Math.max(0,str.length()-3))).getRandomChar();
//        str += strings.get(str.substring(Math.max(0,str.length()-3))).getRandomChar();
//        str += strings.get(str.substring(Math.max(0,str.length()-3))).getRandomChar();
//        System.out.println(str);
    }
}
/*

true
1
true
2
true
10

 */
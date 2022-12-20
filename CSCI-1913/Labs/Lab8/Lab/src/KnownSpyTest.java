public class KnownSpyTest {
    public static void main(String[] args) {
        // HOW TO USE THESE TESTS:
        // PLEASE UNCOMMENT AS YOU COMPLETE CODE
        // YOU WILL BE UNABLE TO RUN ANY CODE IF YOU UNCOMMENT A CALL TO A FUNCTION YOU HAVE YET TO WRITE

        CaesarCipher cipher = new CaesarCipher(10);
        KnownSpy kluver = new KnownSpy("Kluver", new CaesarCipher(10));
        KnownSpy mats = new KnownSpy("Mats", new CaesarCipher(4));
        KnownSpy shana = new KnownSpy("Shana", new CaesarCipher(20));

        System.out.println(kluver.getName()); // Kluver
        System.out.println(mats.getName()); // Mats
        System.out.println(shana.getName()); // Shana

        Message m1 = new Message("Kluver", "Mats", "yzobkdsyx sc bymui, led gsdrsx yzobkdsyxkv zkbkwodobc");
        Message m2 = new Message("Mats", "Kluver", "glerki mr tper, e qsvi hmkmxep stivexmsr qywx fi ehstxih, hixempw xs jsppsa");
        Message m3 = new Message("Shana", "Kluver", "nbolmxus'm ijyluncih cm jlyjulyx. jcwe oj siol julwyf vyzily xyjulncha");

        // ask wrong spy to decrypt
        kluver.decrypt(m2);
        mats.decrypt(m3);
        shana.decrypt(m1);

        // no change expected
        System.out.println(m1); // Message from: Kluver to: Mats Message: "yzobkdsyx sc bymui, led gsdrsx yzobkdsyxkv zkbkwodobc"
        System.out.println(m2); // Message from: Mats to: Kluver Message: "glerki mr tper, e qsvi hmkmxep stivexmsr qywx fi ehstxih, hixempw xs jsppsa"
        System.out.println(m3); // Message from: Shana to: Kluver Message: "nbolmxus'm ijyluncih cm jlyjulyx. jcwe oj siol julwyf vyzily xyjulncha"

        kluver.decrypt(m1);
        mats.decrypt(m2);
        shana.decrypt(m3);

        // should be decrypted
        System.out.println(m1); // Message from: Kluver to: Mats Message: "operation is rocky, but within operational parameters"
        System.out.println(m2); // Message from: Mats to: Kluver Message: "change in plan, a more digital operation must be adopted, details to follow"
        System.out.println(m3); // Message from: Shana to: Kluver Message: "thursday's operation is prepared. pick up your parcel before departing"

        KnownSpy[] spies = {kluver, mats, shana};
        Message m4 = new Message("Student", "Kluver", "Could you explain the NFA to DFA transformation again?");
        System.out.println(KnownSpy.isFromSpy(spies, m1)); // true
        System.out.println(KnownSpy.isFromSpy(spies, m2)); // true
        System.out.println(KnownSpy.isFromSpy(spies, m3)); // true
        System.out.println(KnownSpy.isFromSpy(spies, m4)); // false


        kluver = new KnownSpy("Kluver", new CaesarCipher(10));
        String stopwords = "i me my myself we our ours ourselves you your yours yourself yourselves he him his himself she her hers herself it its itself they them their theirs themselves what which who whom this that these those am is are was were be been being have has had having do does did doing a an the and but if or because as until while of at by for with about against between into through during before after above below to from up down in out on off over under again further then once here there when where why how all any both each few more most other some such no nor not only own same so than too very s t can will just don should must now";

        System.out.println(kluver.tryDecrypt("sc", stopwords));   // is
        System.out.println(kluver.tryDecrypt("qywx", stopwords)); // must
        System.out.println(kluver.tryDecrypt("aa", stopwords));   // null
    }

}


/*


Kluver
Mats
Shana
Message from: Kluver to: Mats Message: "yzobkdsyx sc bymui, led gsdrsx yzobkdsyxkv zkbkwodobc"
Message from: Mats to: Kluver Message: "glerki mr tper, e qsvi hmkmxep stivexmsr qywx fi ehstxih, hixempw xs jsppsa"
Message from: Shana to: Kluver Message: "nbolmxus'm ijyluncih cm jlyjulyx. jcwe oj siol julwyf vyzily xyjulncha"
Message from: Kluver to: Mats Message: "operation is rocky, but within operational parameters"
Message from: Mats to: Kluver Message: "change in plan, a more digital operation must be adopted, details to follow"
Message from: Shana to: Kluver Message: "thursday's operation is prepared. pick up your parcel before departing"
true
true
true
false
is
must
null


 */
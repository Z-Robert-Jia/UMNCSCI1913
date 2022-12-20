
import java.util.Arrays;
import java.util.Random;

public class GameScoreTester{

    public static void main(String[] args) {
        GameScore g1 = new GameScore("DAK", 15.2, true);
        // new String here is deliberately to catch a common error in your equals definition
        // remember you can't compare Strings with == use .equals instead!
        GameScore g2 = new GameScore(new String("DAK"), 15.2, true);

        System.out.println("Test basic method functions");
        System.out.println(g1.getName().equals("DAK"));
        System.out.println(g1.getScore()==15.2);
        System.out.println(g1.isHardMode()==true);
        System.out.println(g1.toString().equals("DAK 15.2*"));

        System.out.println(g1.equals(g2));

        // catching another way you can mis-program equals by making the parameter wrong.
        // don't be mistaken, the parameter to your .equals method is Object.
        // If you don't know why make sure to ask in lab or office hours so we can explain it!
        Object o = g2;
        System.out.println(g1.equals(o));


        System.out.println("Test comparator");

        g1 = new GameScore("DAK", 1000, false);
        g2 = new GameScore("DJK", 110, false);
        System.out.println(g1.compareTo(g2) > 0); // true
        System.out.println(g2.compareTo(g1) < 0); // true

        g1 = new GameScore("DJK", 1000, false);
        g2 = new GameScore("DAK", 1000, false);
        System.out.println(g1.compareTo(g2) == 0); // true
        System.out.println(g2.compareTo(g1) == 0); // true

        g1 = new GameScore("DAK", 110, true);
        g2 = new GameScore("DJK", 110, false);
        System.out.println(g1.compareTo(g2) > 0); // true
        System.out.println(g2.compareTo(g1) < 0); // true

        g1 = new GameScore("DJK", 100, true);
        g2 = new GameScore("DAK", 110, false);
        System.out.println(g1.compareTo(g2) > 0); // true
        System.out.println(g2.compareTo(g1) < 0); // true

        g1 = new GameScore("DAK", 110, true);
        g2 = new GameScore("DJK", 10, false);
        System.out.println(g1.compareTo(g2) > 0); // true
        System.out.println(g2.compareTo(g1) < 0); // true

        g1 = new GameScore("ABC", 1000, true);
        g2 = new GameScore("ABC", 110, true);
        System.out.println(g1.compareTo(g2) > 0); // true
        System.out.println(g2.compareTo(g1) < 0); // true

        g1 = new GameScore("ABC", 100, true);
        g2 = new GameScore("ABC", 100, true);
        System.out.println(g1.compareTo(g2) == 0); // true
        System.out.println(g2.compareTo(g1) == 0); // true

        // Another common issue here -- if you're casting scores to ints (intentially or not) these might fail.
        g1 = new GameScore("DAK", 10, true);
        g2 = new GameScore("DJK", 9.99, true);
        System.out.println(g1.compareTo(g2) > 0); // true
        System.out.println(g2.compareTo(g1) < 0); // true

        g1 = new GameScore("DAK", 10.01, false);
        g2 = new GameScore("DJK", 10, false);
        System.out.println(g1.compareTo(g2) > 0); // true
        System.out.println(g2.compareTo(g1) < 0); // true



        // I move the sorting to the end as the pressure test.
        GameScore[] scores = {
                new GameScore("DAK", 900, false),
                new GameScore("DAK", 999.9, false),
                new GameScore("DAK", 1000, false),
                new GameScore("DAK", 1000.1, false),
                new GameScore("DAK", 1100, false),
                new GameScore("DAK", 900, true),
                new GameScore("DAK", 999.9, true),
                new GameScore("DAK", 1000, true),
                new GameScore("DAK", 1000.1, true),
                new GameScore("DAK", 1100, true),
        }                                      ;
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            // shuffle
            for (int k = 0; k < scores.length-1; k++) {
                int swapPos = random.nextInt(scores.length-1-k)+k;
                GameScore tmp = scores[swapPos];
                scores[swapPos] = scores[k];
                scores[k] = tmp;
            }
            // sort -- this relies on you to implement Comparable correctly.
            // also note -- this will sort smallest-to-biggest.
            Arrays.sort(scores);
            // print
            System.out.println(Arrays.toString(scores));
        }

    }
}

/*

Test basic method functions
true
true
true
true
true
true
Test comparator
true
true
true
true
true
true
true
true
true
true
true
true
true
true
true
true
true
true
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]
[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]

 */

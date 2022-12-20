public class Quiz7A {
    public static int[] rose(String[] bud) {
        int[] retVal = new int[bud.length];
        for (int i = 0; i < bud.length; i++) {
            retVal[i] = bud[i].length();
        }
        return retVal;
    }

    public static int thorn(int[] stem) {
        int retVal = 0;
        for(int i = stem.length-1; i >= 0; i--) {
            retVal += stem[i];
        }
        return retVal;
    }

    public static int flower(String[] grow) {
        return thorn(rose(grow));
    }

    public static void main(String[] args) {
        String[] names = {"Daniel", "Kluver", "Prof", "Dr", "Mr"};
        System.out.println(flower(names));
    }
}
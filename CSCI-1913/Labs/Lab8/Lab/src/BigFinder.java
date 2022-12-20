public class BigFinder {
    // the smallest int -- for reference, and to serve as a good default.
    public static final int SMALLEST = -2147483648;
    private int biggestSoFar;

    /**
     * create a new BigFinder with an initial value
     * @param initial
     */
    public BigFinder(int initial) {
        biggestSoFar = initial;
    }

    /**
     * Have the big finder "see" a new value -- increasing it's biggest so far if it's a new biggest value
     * @param newNum
     */
    public void see(int newNum) {
        if (newNum > biggestSoFar) {
            biggestSoFar = newNum;
        }
    }

    /**
     * reset the bigFinder object. Not currently planned for use.
     */
    private void resetToMin() {
        biggestSoFar = SMALLEST;
    }

    /**
     * get the biggest number this big finder has seen so far
     * this would be the maximum of the initial value at the constructor, and all of the values passed to the see method.
     * @return
     */
    public int getBiggestSoFar() {
        return biggestSoFar;
    }



    /**
     * Given a big finder, make it just a little bit bigger.
     * @param bf
     */
    public static void makeABitBigger(BigFinder bf) {
        bf.biggestSoFar++;
    }

    public static void main(String[] args) {
        BigFinder bf = new BigFinder(0);
        bf.see(6);
        bf.resetToMin();
        System.out.println(bf.getBiggestSoFar());
        BigFinder.makeABitBigger(bf);
    }
}
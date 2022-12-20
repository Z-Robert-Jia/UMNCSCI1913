public class GameScore implements Comparable<GameScore>{
    private double score;
    private String name;
    private boolean hard;

    public GameScore(String name, double score, boolean hard){
        this.name = name;
        this.score = score;
        this.hard = hard;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public boolean isHardMode() {
        return hard;
    }

    /**
     * To string method, returns string
     * @return
     */
    @Override
    public String toString() {
        String str = "";
        if (hard){
            str = "*";
        }
        return name + " " + score + str;
    }


    /**
     * compareTo method, compares first DIFFICULTY then SCORE
     * @param other the object to be compared.
     * @return
     */
    @Override
    public int compareTo(GameScore other) {
        if (this.hard && !other.hard){
            return 1;
        } else if (!this.hard && other.hard) {
            return -1;
        } else {
            return Double.compare(this.score,other.score);
        }
    }

    /**
     * Two objects are equal only if they have the exact same name, score, hard
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (this == obj){
            return true;
        } else if (obj instanceof GameScore) {
            GameScore other = (GameScore) obj;
            return this.name.equals(other.name) && this.score==other.score && this.hard == other.hard;
        }
        return false;
    }

}

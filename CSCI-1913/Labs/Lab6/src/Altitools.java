/*
 * CSCI 1913
 * Lab 06
 * Author: Zheng Robert Jia
 *          Daniyal Khan
 * */
// keep this line.
import java.lang.Math;
// this line will let you use function from the Java math package:
// details here: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Math.html
// but a few functions you might need:
// Math.abs(number)
// Math.atan2(y, x)
// Math.pow(a,b) (which equals a^b)
// Math.toDegrees(radians)
// Math.sqrt(number)
// Use these roughly as written (so include the "Math." part)

public class Altitools {

    /**
     * Computes the steepest angle (Raising or falling) in a mountain range
     * @param mountainRange an array of doubles representing the heights of a mountain range. Will not be modified
     * @return the steepest upward/downward angle in the mountain range as a positive value measured in degrees.
     */
    public static double steepest_angle(double [] mountainRange) {
        double steepest_change = 0;
        for (int i = 1; i < mountainRange.length; i++) {
            double dif = Math.abs(mountainRange[i]-mountainRange[i-1]);
            if (dif > steepest_change){
                steepest_change = dif;
            }
        }
        return Math.toDegrees(Math.atan(steepest_change));
    }

    /**
     * Calculates the distance between the two mointain ranges 1 step interval apart
     * @param a first range
     * @param b second range
     * @return the distance between the two ranges
     */
    public static double calc_distances(double a, double b){
        return Math.sqrt(Math.pow((a-b),2)+1);
    }

    /**
     * Get the total "travel distance" over a mountain range
     * @param mountainRange an array of doubles representing the heights of a mountain range.  Will not be modified
     * @return the travel distance -- a non-negative double.
     */
    public static double total_distance(double [] mountainRange) {
        if (mountainRange.length <= 1){
            return 0;
        }
        double distance = 0;
        for (int i = 0; i < mountainRange.length-1; i++){
            distance += calc_distances(mountainRange[i],mountainRange[i+1]);
        }
        return distance;
    }

    /**
     * compute the longest (in terms of travel distance) seuqentially climbing part of a mountain range.
     * @param mountainRange an array of doubles representing the heights of a mountain range. Will not be modified
     * @return the latest travel distance of any sequentially climbing segment of the mountain range
     */
    public static double longest_sequential_climb(double [] mountainRange) {
        if (mountainRange.length <= 1){
            return 0;
        }
        double seq_climb = 0;
        boolean is_climb;
        double climb;
        double highest_climb = 0;
        for (int i = 1; i <mountainRange.length; i++){
            is_climb = (mountainRange[i] - mountainRange[i-1])>0;
            climb = calc_distances(mountainRange[i],mountainRange[i-1]);
            if (is_climb){
                seq_climb += climb;
                if (i==mountainRange.length-1 && seq_climb>highest_climb){
                    highest_climb = seq_climb;
                }
            }
            else if (seq_climb > highest_climb){
                highest_climb = seq_climb;
                seq_climb = 0;
            }
            else {
                seq_climb = 0;
            }
        }
        return highest_climb;
    }

    /**
     * compute the numebr of peaks (higher than it's neighbors) and valleys (lower than it's neighbors) in a mountain
     * @param mountainRange an array of doubles representing the heights of a mountain range. Will not be modified
     * @return a length 2 int array. position 1 is the number of peaks and position 2 the number of valleys.
     */
    public static int[] num_of_peaks_and_valleys(double [] mountainRange){
        if (mountainRange.length<2){
            return new int[]{0, 0};
        }
        int peaks = 0;
        int valleys = 0;

        // count peaks
        for (int i = 1; i<mountainRange.length-1; i++){
            if (mountainRange[i]>mountainRange[i-1] && mountainRange[i] > mountainRange[i+1]){
                peaks++;
            }
        }
        // count valleys
        for (int i = 1; i<mountainRange.length-1;i++){
            if (mountainRange[i]<mountainRange[i-1] && mountainRange[i]<mountainRange[i+1]){
                valleys++;
            }
        }
        return new int[]{peaks,valleys};
    }

    /**
     * Creates a new array to indicate what would happen if we were to hypothetically fill the lowest parts of a
     * mountain range up to a fixed height
     * @param mountainRange an array of doubles representing the heights of a mountain range. Will not be modified
     * @param target a double. the new array will have all positions below this filled up to this height
     * @return a new array showing the result of filling in the array
     */
    public static double[] fill_valleys(double [] mountainRange, double target){
        // copy the array first
        double[]copy_mountainRange = new double[mountainRange.length];
        for (int i = 0; i<mountainRange.length; i++){
            copy_mountainRange[i] = mountainRange[i];
        }
        // I could do enhanced for loop as well, but I don't know if I would lose points for that
        for (int i = 0; i<copy_mountainRange.length;i++){
            if(copy_mountainRange[i]<target){
                copy_mountainRange[i] = target;
            }
        }
        return copy_mountainRange;
    }

}


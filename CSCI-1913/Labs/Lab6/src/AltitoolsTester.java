import java.util.Arrays;

public class AltitoolsTester {
    public static void main(String[] args) {

        System.out.println("steepest_angle");
        double res = 0;
        double[] mountain_range = new double[]{1, 2, 1, 3, 1, 4, 2};
        res = Altitools.steepest_angle(mountain_range);
        System.out.println(res); // 71.56505117707799

        mountain_range = new double[]{10,1,5,10,15,6};
        res = Altitools.steepest_angle(mountain_range);
        System.out.println(res); // 83.6598082540901

        mountain_range = new double[] {0, -100, 0, 100, 200};
        res = Altitools.steepest_angle(mountain_range);
        System.out.println(res); // 89.42706130231652

        mountain_range = new double[]{1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1};
        res = Altitools.steepest_angle(mountain_range);
        System.out.println(res); // 0.0

        mountain_range = new double[]{};
        res = Altitools.steepest_angle(mountain_range);
        System.out.println(res); // 0.0


        System.out.println("total_distance");
        mountain_range = new double[]{0, 12, 14, 11, 16, 77, 73, 72, 71, 90};
        res = Altitools.total_distance(mountain_range);
        System.out.println(res);     // 109.52498624153611

        mountain_range = new double[]{};
        res = Altitools.total_distance(mountain_range);
        System.out.println(res); // 0.0

        mountain_range = new double[] {7.5};
        res = Altitools.total_distance(mountain_range);
        System.out.println(res); // 0.0

        mountain_range = new double[]{-1,1,-2,2,-3,3};
        res = Altitools.total_distance(mountain_range);
        System.out.println(res);     // 20.703233307176834

        mountain_range = new double[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        res = Altitools.total_distance(mountain_range);
        System.out.println(res);     // 13.0


        System.out.println("longest_sequential_climb");
        mountain_range = new double[]{5, 4, 1, 2, 2.2, 2.3, 2.35, 2.37, 2.39, 2.4, 2.3, 2, 1, 100, 99, 98, 77};
        res = Altitools.longest_sequential_climb(mountain_range);
        System.out.println(res);     // 99.00505037623081

        mountain_range = new double[]{5, 4, 1, 0};
        res = Altitools.longest_sequential_climb(mountain_range);
        System.out.println(res);     // 0.0

        mountain_range = new double[]{1, 3, 4, 5};
        res = Altitools.longest_sequential_climb(mountain_range);
        System.out.println(res);     // 5.06449510224598

        mountain_range = new double[]{1, 2, 1, 1};
        res = Altitools.longest_sequential_climb(mountain_range);
        System.out.println(res);     // 1.4142135623730951

        mountain_range = new double[]{1, 1, 1, 1};
        res = Altitools.longest_sequential_climb(mountain_range);
        System.out.println(res);     // 0.0

        System.out.println("num_of_peaks_and_valleys");
        int[] result;
        mountain_range = new double[]{};
        result = Altitools.num_of_peaks_and_valleys(mountain_range);
        System.out.println(Arrays.toString(result)); // [0, 0]

        mountain_range = new double[]{2,3};
        result = Altitools.num_of_peaks_and_valleys(mountain_range);
        System.out.println(Arrays.toString(result)); // [0, 0]

        mountain_range = new double[] {1,1,2,2,1,1,3,3,2,2,1,1};
        result = Altitools.num_of_peaks_and_valleys(mountain_range);
        System.out.println(Arrays.toString(result)); // [0, 0]

        mountain_range = new double[]{1,2,1,3,1,4,2,5,4,6,7,8,4,4,2,2,5,6,7,8};
        result = Altitools.num_of_peaks_and_valleys(mountain_range);
        System.out.println(Arrays.toString(result)); // [5, 4]

        mountain_range = new double[]{0, 12, 14, 11, 16, 77, 73, 72, 71, 90};
        result = Altitools.num_of_peaks_and_valleys(mountain_range);
        System.out.println(Arrays.toString(result)); // [2, 2]

        System.out.println("fill_valleys");
        double[] result1;
        mountain_range = new double[]{};
        result1 = Altitools.fill_valleys(mountain_range, 10);
        System.out.println(Arrays.toString(result1)); // []

        mountain_range = new double[]{5};
        result1 = Altitools.fill_valleys(mountain_range, 10);
        System.out.println(Arrays.toString(result1)); // [10.0]

        mountain_range = new double[] {0, 12, 14, 11, 16, 77, 73, 72, 71, 90};
        result1 = Altitools.fill_valleys(mountain_range, -10);
        System.out.println(Arrays.toString(result1)); // [0.0, 12.0, 14.0, 11.0, 16.0, 77.0, 73.0, 72.0, 71.0, 90.0]

        mountain_range = new double[]{0, 12, 14, 11, 16, 77, 73, 72, 71, 90};
        result1 = Altitools.fill_valleys(mountain_range, 30);
        System.out.println(Arrays.toString(result1)); // [30.0, 30.0, 30.0, 30.0, 30.0, 77.0, 73.0, 72.0, 71.0, 90.0]

        mountain_range = new double[]{0, 12, 14, 11, 16, 77, 73, 72, 71, 90};
        result1 = Altitools.fill_valleys(mountain_range, 300);
        System.out.println(Arrays.toString(result1)); // [300.0, 300.0, 300.0, 300.0, 300.0, 300.0, 300.0, 300.0, 300.0, 300.0]

    }
}

/*

expected output


steepest_angle
71.56505117707799
83.6598082540901
89.42706130231652
0.0
0.0
total_distance
109.52498624153611
0.0
0.0
20.703233307176834
13.0
longest_sequential_climb
99.00505037623081
0.0
5.06449510224598
1.4142135623730951
0.0
num_of_peaks_and_valleys
[0, 0]
[0, 0]
[0, 0]
[5, 4]
[2, 2]
fill_valleys
[]
[10.0]
[0.0, 12.0, 14.0, 11.0, 16.0, 77.0, 73.0, 72.0, 71.0, 90.0]
[30.0, 30.0, 30.0, 30.0, 30.0, 77.0, 73.0, 72.0, 71.0, 90.0]
[300.0, 300.0, 300.0, 300.0, 300.0, 300.0, 300.0, 300.0, 300.0, 300.0]



 */
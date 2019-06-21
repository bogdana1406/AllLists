package ex1;

import java.util.Arrays;

public class GradeBook {
    public static void main(String[] args) {
        int[][] gradesArray = {{87, 96, 70},
                {68, 87, 90},
                {94, 100, 90},
                {100, 81, 82},
                {83, 65, 85},
                {78, 87, 65},
                {85, 75, 83}
        };

//        System.out.println(calcMin(gradesArray));
//        varArgs();
        processArrays();

    }

    private static int calcMin(int[][] grades) {
        int min = grades[0][0];
        for (int[] row: grades) {
            for (int itom: row ) {
                if(itom < min) {
                    min = itom;
                }
            }
        }
        return min;
    }

    private static void varArgs() {
        double a = 0.56;
        double b = 1.86;
        double c = 5.16;
        double d = 0.99;
        double e = 4.54;
        double f = 5.9;

        System.out.println("Average of 2 element  " + calcAverage(a, b));
        System.out.println("Average of 3 element  " + calcAverage(a, b, c));
        System.out.println("Average of 4 element  " + calcAverage(a, b, c, d));
        System.out.println("Average of 5 element  " + calcAverage(a, b, c, d, e));
    }

    private static double calcAverage(double... args) {
        double sum = 0;
        for (double i: args) {
            sum +=i;
        }
        return sum / args.length;
    }

    private static void processArrays() {
        double[] doubleArray = {8.9, 5.65, 8.12, 45.0, 77.1};
        Arrays.sort(doubleArray);
        System.out.println(Arrays.toString(doubleArray));

        int[] filledArray = new int[7];
        Arrays.fill(filledArray, 7);
        System.out.println(Arrays.toString(filledArray));

        int[] intArray = {1, 2, 3, 4, 5};
        int[] arrayCopy = new int[10];
        System.arraycopy(intArray, 0, arrayCopy, 0, intArray.length);
        System.out.println(Arrays.toString(arrayCopy));
    }
}


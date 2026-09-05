package string.class_problems;

import java.util.Random;

public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("===============================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-10s | %-12.2f | %-12.2f | %-8.2f | %-12s%n",
                    "Person " + (i + 1), heights[i], weights[i], bmi, status);
        }
        System.out.println("===============================================================");
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + (1.95 - 1.50) * rand.nextDouble(); // Heights: 1.50m - 1.95m
            weights[i] = 45.0 + (100.0 - 45.0) * rand.nextDouble(); // Weights: 45kg - 100kg
        }

        printWellnessReport(heights, weights);
    }
}
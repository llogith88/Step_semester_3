package string.assignment_problems;

import java.util.Scanner;

class LongestSignalStreak {

    static void findLongestStreak(String signalLog) {

        int count = 1;
        int max = 1;
        char maxColor = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count > max) {
                max = count;
                maxColor = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + maxColor +
                "' repeated " + max + " times");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter signal log:");

        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);

        sc.close();
    }
}
import java.util.Scanner;

public class Task4 {

    static boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentLoad = 0;
        for (int i = 0; i < weights.length; i++) {
            if (currentLoad + weights[i] > capacity) {
                daysNeeded++;
                currentLoad = 0;
            }
            currentLoad += weights[i];
        }
        return daysNeeded <= days;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        int days = sc.nextInt();

        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (weights[i] > left) left = weights[i];
            right += weights[i];
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
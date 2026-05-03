import java.util.Scanner;

public class Task4 {

    static boolean fitsWithinDays(int[] packages, int totalDays, int truckCapacity) {
        int daysUsed = 1;
        int loadToday = 0;
        for (int i = 0; i < packages.length; i++) {
            if (loadToday + packages[i] > truckCapacity) {
                daysUsed++;
                loadToday = 0;
            }
            loadToday += packages[i];
        }
        return daysUsed <= totalDays;
    }

    static void findMinShippingCapacity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of packages: ");
        int count = scanner.nextInt();
        int[] packages = new int[count];
        System.out.print("Enter weights: ");
        for (int i = 0; i < count; i++) {
            packages[i] = scanner.nextInt();
        }
        System.out.print("Enter number of days: ");
        int totalDays = scanner.nextInt();

        int minCapacity = 0;
        int maxCapacity = 0;
        for (int i = 0; i < count; i++) {
            if (packages[i] > minCapacity) minCapacity = packages[i];
            maxCapacity += packages[i];
        }

        while (minCapacity < maxCapacity) {
            int midCapacity = (minCapacity + maxCapacity) / 2;
            if (fitsWithinDays(packages, totalDays, midCapacity)) {
                maxCapacity = midCapacity;
            } else {
                minCapacity = midCapacity + 1;
            }
        }

        System.out.println(minCapacity);
    }

    public static void main(String[] args) {
        findMinShippingCapacity();
    }
}
import java.util.Scanner;

public class Task3 {

    static void sortNumbers(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void findMedian() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.print("Enter elements: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        sortNumbers(numbers);

        System.out.println(numbers[size / 2]);
    }

    public static void main(String[] args) {
        findMedian();
    }
}
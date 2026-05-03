import java.util.Scanner;

public class Task2 {

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

    static void findKthSmallest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.print("Enter elements: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.print("Enter k: ");
        int position = scanner.nextInt();

        sortNumbers(numbers);

        System.out.println(numbers[position - 1]);
    }

    public static void main(String[] args) {
        findKthSmallest();
    }
}
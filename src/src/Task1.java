import java.util.Scanner;

public class Task1 {

    static void bubbleSort(char[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s1 = sc.next().toCharArray();
        char[] s2 = sc.next().toCharArray();

        if (s1.length != s2.length) {
            System.out.println("NO");
            return;
        }

        bubbleSort(s1);
        bubbleSort(s2);

        boolean isAnagram = true;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                isAnagram = false;
                break;
            }
        }

        System.out.println(isAnagram ? "YES" : "NO");
    }
}
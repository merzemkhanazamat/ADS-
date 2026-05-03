import java.util.Scanner;

public class Task1 {

    static void sortCharacters(char[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void checkAnagram() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first word: ");
        char[] firstWord = scanner.next().toCharArray();
        System.out.print("Enter second word: ");
        char[] secondWord = scanner.next().toCharArray();

        if (firstWord.length != secondWord.length) {
            System.out.println("NO");
            return;
        }

        sortCharacters(firstWord);
        sortCharacters(secondWord);

        boolean isAnagram = true;
        for (int i = 0; i < firstWord.length; i++) {
            if (firstWord[i] != secondWord[i]) {
                isAnagram = false;
                break;
            }
        }

        System.out.println(isAnagram ? "YES" : "NO");
    }

    public static void main(String[] args) {
        checkAnagram();
    }
}
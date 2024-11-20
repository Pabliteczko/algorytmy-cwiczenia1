import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] array1 = {3, 5, 5, 1, 7, 8, 3, 3};
        //Użycie metody do znalezienia minimalnej wartości
        System.out.println(min(array1));
        //Użycie metody do znalezienia maksymalnej wartości
        System.out.println(max(array1));
        //Użycie metody do znalezienia minimalnej i maksymalnej wartości
        minmax(array1);

        //Użycie metody do zmienienia miejscami liczb obok siebie w tablicy
        int[] array2 = {1, 2, 3, 4, 5, 6};
        swap(array2);
        System.out.println(Arrays.toString(array2));

        //Użycie metody do zamienienia wierszów z kolumnami
        char[][] matrix = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };
        char[][] transposedMatrix = transpose(matrix);
        System.out.println(Arrays.deepToString(transposedMatrix));

        //Użycie metody wyszukującej dany znak z listy
        char[] array3 = {'a', 'b', 'c', 'a', 'd', 'a'};
        char findChar = 'a';

        List<Integer> result = find_letter(array3, findChar);

        System.out.println("Wystąpienia znaku '" + findChar + "' znajdują się na pozycjach: " + result);

        // Użycie metody wyszukiwania binarnego liczby w tablicy upożadkowanej rosnąco lub malejąco
        int[] ascendingArray = {1, 2, 3, 4, 5, 6};
        int[] descendingArray = {6, 5, 4, 3, 2, 1};

        int findNumber = 4;

        System.out.println("Szukana liczba w tablicy rosnącej: " + binarySearch(ascendingArray, findNumber));
        System.out.println("Szukana liczba w tablicy malejącej: " + binarySearch(descendingArray, findNumber));


    }

    //Metoda znajdująca najmniejszą wartość
    public static int min(int[] arr) {
        int min = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    //Metoda znadjdująca najwiiększą wartość
    public static int max(int[] arr) {
        int max = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    //Metoda znajdująca największą i najmniejszą wartość, wypisująca je w Stringu
    public static void minmax(int[] arr) {
        int min = arr[1];
        int max = arr[1];

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("Najmniejszy element tablicy to " + min + ", a największy to " + max);
        ;
    }

    //Metoda zmieniająca miejscami dwie sąsiadującce ze sobą liczby w tablicy
    public static int[] swap(int[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        return arr;
    }

    //Metoda wykonująca transpozycje (zmiane wierszów z kolumnami)
    public static char[][] transpose(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] transposed = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    //Metoda szukająca lokalizacji danego znaku
    public static List<Integer> find_letter(char[] array, char target) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                positions.add(i);
            }
        }
        return positions;
    }

    //Metoda używająca wyszukiwania binarnego liczby w tablicy upożadkowanej rosnąco lub malejąco
    public static int binarySearch(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }
        boolean isAscending = array[0] < array[array.length - 1];
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return middle;
            }
            if (isAscending) {
                if (target < array[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (target > array[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return -1;
    }

}

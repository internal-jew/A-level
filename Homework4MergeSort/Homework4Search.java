import java.util.Scanner;

public class Homework4Search {
    public static void main(String[] args) {
        Scanner scaner=new Scanner(System.in);
        System.out.println("Enter quantity of number to sort");
        int n=scaner.nextInt();
        int[] source=new int[n];
        System.out.println("Enter numbers:");
        for (int i = 0; i <n; i++) {

            source[i]=scaner.nextInt();
        }


        // Исходный массив
    //    int[] source = {1, 4, 3, 0, 23, 8, 8, 45, 2};
        int[] result = sort(source);
// Вывод на экран отсортированного массива
        for (int element : result
        ) {
            System.out.print(element + " ");

        }
    }


    //Метод разбиения массива пополам
    private static int[] sort(int[] dim) {
        // Разбиваем массивы пополам пока не останется 1 элемент
        if (dim.length == 1) {
            return dim;
        }

        int[] first = new int[dim.length / 2];//Первая половина массива
        // Заполнение первого массива
        for (int i = 0; i < dim.length / 2; i++) {
            first[i] = dim[i];
        }
        //Второй массив - при четном количестве элементов
        int[] second;
        if (dim.length % 2 == 0) {
            second = new int[dim.length / 2];
        } else {
            //Второй массив - при нечетном количестве элементов
            second = new int[(dim.length / 2) + 1];
        }

        int j = 0;// Счетчик второго массива
        for (int i = (dim.length / 2); i < dim.length; i++) {
            second[j] = dim[i];
            j++;
        }

        int[] left = sort(first); // Рекурсия пока в массиве не останется 1 элемент
        int[] right = sort(second);// Рекурсия пока в массиве не останется 1 элемент
        return sorting(left, right); //Вызов метода сортировки слиянием
    }


// Метод сортировки слиянием
    private static int[] sorting(int[] dim1, int[] dim2) {
        int[] result = new int[dim1.length + dim2.length];
        int i = 0; // Счетчик первого массива
        int j = 0;// Счетчик второго массива
        int k = 0;// Счетчик результатирующего массива
        while (k < result.length) {
            if (dim1[i] < dim2[j]) {
                result[k] = dim1[i];
                i++;
                k++;
            } else {
                result[k] = dim2[j];
                j++;
                k++;
            }
            // Если в первом массиве закончились элементы, результатирующий массив дозаполняем вторым массивом
            if (i == dim1.length) {
                for (int l = j; l < dim2.length; l++) {
                    result[k] = dim2[l];
                    k++;

                }
                return result;
            }
            // Если во вотром массиве закончились элементы, результатирующий массив дозаполняем первым массивом
            if (j == dim2.length) {
                for (int l = i; l < dim1.length; l++) {
                    result[k] = dim1[l];
                    k++;

                }
                return result;
            }

        }
        // В случие, если условия не сработали (хотя такого быть не должно)
        System.out.println("Error with sorting");
        return result;
    }
}
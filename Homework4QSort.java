public class Homework4QSort {
    public static void main(String[] args) {
        int[] source = {76, 11, 7, 0, 7, 8, 1, 98, 0, 7, 9, 65};
        System.out.println("Original data array:");
        for (int element : source //Вывод первоначального массива в консоль
        ) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Sorted data array by quick sort:");
        for (int element : sort(source, 0, source.length - 1) //Вывод отсортированного массива в консоль
        ) {
            System.out.print(element + " ");
        }
    }

    private static int[] sort(int[] dim, int startIndex, int endIndex) { // Метод сортировки
        if (endIndex - startIndex == 0) { //Если на участке сортировки всего один элемент - завершить метод
            return dim;
        }
        int leftIndex = startIndex;// Индекс первого элемента на участке
        int rightIndex = endIndex; // Индекс последнего элемента на участке
        int indexOfReferentItem = (startIndex + endIndex) / 2; //Индекс опорного элемента. Выбираем средний элемент участка

        while (leftIndex < rightIndex) { // Продолжаем действия пока левый и правый индексы не сойдутся
            while ((leftIndex < indexOfReferentItem) && dim[leftIndex] <= dim[indexOfReferentItem]) {//Ищем индекс элемента, значение которого больше или равно опорного
                leftIndex++;
            }
            while ((rightIndex > indexOfReferentItem) && dim[rightIndex] >= dim[indexOfReferentItem]) { //Ищем индекс элемента, значение которого меньше или равно опорного
                rightIndex--;
            }
            if (leftIndex < rightIndex) { // Проверка, чтобы индексы не указывали на опорный элемент сразу вдвоем
                int temp = dim[rightIndex]; //меняем местами значения по найденым индексам
                dim[rightIndex] = dim[leftIndex];
                dim[leftIndex] = temp;
                if (leftIndex == indexOfReferentItem) { // Если левый индекс указывает на опорный элемент, тогда индекс опорного элемента менятся на правый индекс, так как произошел обмен
                    indexOfReferentItem = rightIndex;
                } else if (rightIndex == indexOfReferentItem) { // Если правый индекс указывает на опорный элемент, тогда индекс опорного элемента менятся на левый индекс, так как произошел обмен
                    indexOfReferentItem = leftIndex;
                }
            }

        }
        //Вызываем рекурсивно сортировку новых участков
        sort(dim, startIndex, indexOfReferentItem); // участок слева от опорного элемента
        sort(dim, indexOfReferentItem + 1, endIndex); //участок справа от опорного элемента

        return dim;
    }


}

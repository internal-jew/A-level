public class Homework4QSort {
    public static void main(String[] args) {
        int[] source = {76, 11, 7, 0, 7, 8, 1, 98, 0, 7, 9, 65};
        System.out.println("Original data array:");
        for (int element : source //����� ��������������� ������� � �������
        ) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Sorted data array by quick sort:");
        for (int element : sort(source, 0, source.length - 1) //����� ���������������� ������� � �������
        ) {
            System.out.print(element + " ");
        }
    }

    private static int[] sort(int[] dim, int startIndex, int endIndex) { // ����� ����������
        if (endIndex - startIndex == 0) { //���� �� ������� ���������� ����� ���� ������� - ��������� �����
            return dim;
        }
        int leftIndex = startIndex;// ������ ������� �������� �� �������
        int rightIndex = endIndex; // ������ ���������� �������� �� �������
        int indexOfReferentItem = (startIndex + endIndex) / 2; //������ �������� ��������. �������� ������� ������� �������

        while (leftIndex < rightIndex) { // ���������� �������� ���� ����� � ������ ������� �� ��������
            while ((leftIndex < indexOfReferentItem) && dim[leftIndex] <= dim[indexOfReferentItem]) {//���� ������ ��������, �������� �������� ������ ��� ����� ��������
                leftIndex++;
            }
            while ((rightIndex > indexOfReferentItem) && dim[rightIndex] >= dim[indexOfReferentItem]) { //���� ������ ��������, �������� �������� ������ ��� ����� ��������
                rightIndex--;
            }
            if (leftIndex < rightIndex) { // ��������, ����� ������� �� ��������� �� ������� ������� ����� ������
                int temp = dim[rightIndex]; //������ ������� �������� �� �������� ��������
                dim[rightIndex] = dim[leftIndex];
                dim[leftIndex] = temp;
                if (leftIndex == indexOfReferentItem) { // ���� ����� ������ ��������� �� ������� �������, ����� ������ �������� �������� ������� �� ������ ������, ��� ��� ��������� �����
                    indexOfReferentItem = rightIndex;
                } else if (rightIndex == indexOfReferentItem) { // ���� ������ ������ ��������� �� ������� �������, ����� ������ �������� �������� ������� �� ����� ������, ��� ��� ��������� �����
                    indexOfReferentItem = leftIndex;
                }
            }

        }
        //�������� ���������� ���������� ����� ��������
        sort(dim, startIndex, indexOfReferentItem); // ������� ����� �� �������� ��������
        sort(dim, indexOfReferentItem + 1, endIndex); //������� ������ �� �������� ��������

        return dim;
    }


}

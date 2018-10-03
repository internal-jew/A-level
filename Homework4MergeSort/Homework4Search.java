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


        // �������� ������
    //    int[] source = {1, 4, 3, 0, 23, 8, 8, 45, 2};
        int[] result = sort(source);
// ����� �� ����� ���������������� �������
        for (int element : result
        ) {
            System.out.print(element + " ");

        }
    }


    //����� ��������� ������� �������
    private static int[] sort(int[] dim) {
        // ��������� ������� ������� ���� �� ��������� 1 �������
        if (dim.length == 1) {
            return dim;
        }

        int[] first = new int[dim.length / 2];//������ �������� �������
        // ���������� ������� �������
        for (int i = 0; i < dim.length / 2; i++) {
            first[i] = dim[i];
        }
        //������ ������ - ��� ������ ���������� ���������
        int[] second;
        if (dim.length % 2 == 0) {
            second = new int[dim.length / 2];
        } else {
            //������ ������ - ��� �������� ���������� ���������
            second = new int[(dim.length / 2) + 1];
        }

        int j = 0;// ������� ������� �������
        for (int i = (dim.length / 2); i < dim.length; i++) {
            second[j] = dim[i];
            j++;
        }

        int[] left = sort(first); // �������� ���� � ������� �� ��������� 1 �������
        int[] right = sort(second);// �������� ���� � ������� �� ��������� 1 �������
        return sorting(left, right); //����� ������ ���������� ��������
    }


// ����� ���������� ��������
    private static int[] sorting(int[] dim1, int[] dim2) {
        int[] result = new int[dim1.length + dim2.length];
        int i = 0; // ������� ������� �������
        int j = 0;// ������� ������� �������
        int k = 0;// ������� ����������������� �������
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
            // ���� � ������ ������� ����������� ��������, ���������������� ������ ����������� ������ ��������
            if (i == dim1.length) {
                for (int l = j; l < dim2.length; l++) {
                    result[k] = dim2[l];
                    k++;

                }
                return result;
            }
            // ���� �� ������ ������� ����������� ��������, ���������������� ������ ����������� ������ ��������
            if (j == dim2.length) {
                for (int l = i; l < dim1.length; l++) {
                    result[k] = dim1[l];
                    k++;

                }
                return result;
            }

        }
        // � ������, ���� ������� �� ��������� (���� ������ ���� �� ������)
        System.out.println("Error with sorting");
        return result;
    }
}
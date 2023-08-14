import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {

        int size = 20;
        int min = 0;
        int max = 20;

        int[] arr = RandArr(size, max, min);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i] + " ");
        }
    }
    public void sort(int arr[])
    {

        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, arr.length, i);
        for (int i=arr.length-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    void heapify(int arr[], int n, int i)
    {
        int father = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && arr[left] > arr[father])
            father = left;

        if (right < n && arr[right] > arr[father])
            father = right;
        if (father != i)
        {
            int swap = arr[i];
            arr[i] = arr[father];
            arr[father] = swap;

            heapify(arr, n, father);
        }
    }
    private static int[] RandArr(int size, int max, int min) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((max - min) + 1) + min;
        }
        return arr;
    }


}
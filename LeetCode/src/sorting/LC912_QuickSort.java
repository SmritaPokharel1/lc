package sorting;

public class LC912_QuickSort {

    public static void quickSort(int[] nums, int low, int high){

        if(low < high){
            int pivotIndex = partition(nums, low,high);
            quickSort(nums,low,pivotIndex -1 );
            quickSort(nums, pivotIndex +1, high);
        }
    }

    public static int partition(int[] nums, int low, int high){

        int pivot = nums[high];

        int i = low - 1;

        for(int j = low; j < high; j++){

            if(nums[j] <= pivot){

                i++;
                swap(nums,i,j);
            }
        }

        swap(nums,i+1,high);

        return i+1;
    }

    public static void swap(int[] nums, int i, int j){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {10, 7, 8, 9, 1, 5};

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: ");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

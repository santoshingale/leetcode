class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;        
    }

    private void mergeSort(int [] arr, int s, int e) {
        if( s < e ) {
            int m = (s + e) / 2;

            mergeSort(arr, s, m);
            mergeSort(arr, m + 1, e);

            merge(arr, s, m, e);
        }
    }

    private void merge(int[]arr, int s, int m, int e) {
        int leftSize = m - s + 1; // Size of left subarray
        int rightSize = e - m;    // Size of right subarray

        int [] left = new int[leftSize];
        int [] right = new int[rightSize];

        for(int i = 0; i < leftSize; i++) {
            left[i] = arr[i + s];
        }

        for(int i = 0; i < rightSize; i++) {
            right[i] = arr[i + m + 1];
        }

        int i = 0;
        int j = 0;
        int k = s;

        while(i < leftSize && j < rightSize) {
            if(left[i] <= right[j]) {
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
            }
        }

        while(i < leftSize) {
            arr[k++] = left[i++];
        }

        while(j < rightSize) {
            arr[k++] = right[j++];
        }
        
    }
}
package BinarySearch;

public class CountOccurences {
    public static int countOccurrences(int[] arr, int target) {
        int first=search(arr,target,true);

        if(first==-1) {
            return 0;
        }

        int last=search(arr,target,false);
        return last-first+1;
    }

    private static int search(int[] arr,int target,boolean findFirst) {
        int ans = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {

                ans = mid;

                if (findFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={0, 0, 1, 1, 1, 2, 3};
        int target=1;
        System.out.println(countOccurrences(arr, target));
    }
}

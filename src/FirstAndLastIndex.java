/* Given a sorted array of integer arr and an integer target,
*  find the index of the first and last position of target in arr.
*  If target can't be found in arr, return [-1, -1]
* */
public class FirstAndLastIndex {
    public static int[] getIndex(int[] arr, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result[0] = i;
                break;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
    public static int[] getIndex1(int[] arr, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result[0] = i;
                while (arr[i] == target && i < arr.length) {
                    result[1] = i;
                    i++;
                }
            }
        }
        return result;
    }

    public static int[] getIndexBinary(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                if (result[0] > mid) result[0] = mid;
                if (result[1] < mid) result[1] = mid;
            }
            if (target < arr[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (result[0] == Integer.MAX_VALUE) {
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,5,5,6,8};
        int target = 8;
        System.out.println(toString(getIndexBinary(arr, target)));
    }


    public static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i : arr) {
            sb.append(i).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}

package easy;

public class T69MySqrt {
    public static void main(String[] args) {
        int x = 2147395599;
        int res = mySqrt(x);
        System.out.println(res);

    }

    private static int mySqrt(int x) {
        return binarySearch(0, x, x);
    }

    private static int binarySearch(int left, int right, int target){
        int mid = Math.min((left + right) / 2,46340);   //46340为最大值对应的输出
        while (left <= right){
            if ((mid * mid) < target && (mid + 1) * (mid + 1) < 0) {    //排除大于2,147,395,600的情况
                return mid;
            }
            //找到目标值
            if ((mid * mid < target && (mid + 1) * (mid + 1) > target) || mid * mid == target){
                return mid;
            }
            if (mid * mid < target && (mid + 1)*(mid + 1) <= target){  //向右查找
                return binarySearch(mid+1, right, target);
            }
            if (mid * mid > target){  //向左查找
                return binarySearch(left, mid-1, target);
            }
        }
        return -1;
    }
}

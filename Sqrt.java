// Implement int sqrt(int x).
//
// Compute and return the square root of x.

public class Sqrt{
    public int mySqrt(int x){
        if( x < 0){
            return -1;
        }

        if(x <= 1){
            return 1;
        }
        //binary search
        int lo = 1;
        int hi = x;

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(mid * mid == x){
                return mid;
            }

            if(mid * mid > x){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return hi;
    }

    public static void main(String[] args){
        Sqrt s = new Sqrt();

        int x = 101;
        System.out.println(s.mySqrt(x));
    }
}

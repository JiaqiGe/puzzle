// Implement pow(x, n).

public class Power{
    public double myPow(double x, int n) {
            //recursion
            double result = 0;
            if(x >= 0 && n >= 0){
                result =  powerHelp(x, n);
            }else if(x < 0 && n >= 0){
                if(n % 2 == 0){
                    result =  powerHelp(-x, n);
                }else{
                    result =  - powerHelp(-x, n);
                }
            }else if(x >= 0 && n < 0){
                result = 1 / (powerHelp(x, -n));
            }else {
                if( (-n) % 2 == 0){
                    result =  1 / powerHelp(-x, -n);
                }else{
                    result = - (1 / powerHelp(-x, -n));
                }
            }

            return result;
    }

    private double powerHelp(double x, int n){
        //in case that x and n are both non-negative

        //base
        if(n == 0){
            return 1.0;
        }

        if(n == 1){
            return x;
        }

        double half = powerHelp(x, n / 2);

        double result = 0;

        if(n % 2 == 0){
            if(isOverFlow(half, half)){
                return Double.MAX_VALUE;
            }

            result = half * half;
        }else{
            if(isOverFlow(half, half) || isOverFlow(half * half, x)){
                return Double.MAX_VALUE;
            }

            result = half * half * x;
        }

        return result;
    }

    boolean isOverFlow(double x, double y){
        if(x < Double.MAX_VALUE / y){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        Power p = new Power();
        double x = -2;
        int n = 4;

        System.out.print(x+"^"+n+"="+p.myPow(x,n));
    }
}


public class ReverseBit{
  public int reverseBits(int n) {
      int result = 0;
      for(int i = 0; i < 32; i++){
          int bit = n % 2;
          n = n >> 1;

          result = result << 1;
          result += bit;
      }
      return result;
  }

  public int test(int n){
    return n << 31;
  }

  public static void main(String[] args){
    ReverseBit r = new ReverseBit();
    System.out.println(r.test(1));
  }
}

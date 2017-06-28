 public class AToI {
    public int myAtoi(String str) {
      if(str == null || str.isEmpty()){
        return 0;
      }
      str = str.trim();

      if(str.charAt(0) == '-'){
          return - myAtoi(str.substring(1));
      }

      if(!isValid(str)){
        return 0;
      }
      int result = 0;
      int unit = 1;
      for(int i = str.length()-1; i >= 0; i--){
          char c = str.charAt(i);
          int digit = 0;
          switch (c){
            case '1':
              digit = 1;
              break;
            case '2':
              digit = 2;
              break;
            case '3':
              digit = 3;
              break;
            case '4':
              digit = 4;
              break;
            case '5':
              digit = 5;
              break;
            case '6':
              digit = 6;
              break;
            case '7':
              digit = 7;
              break;
            case '8':
              digit = 8;
              break;
            case '9':
              digit = 9;
              break;
            default:
              digit = 0;
              break;
          }

          if(result > Integer.MAX_VALUE - unit*digit){
            return 0;
          }

          result += unit*digit;
          unit *= 10;
      }
      return result;

    }

    private boolean isValid(String str){
      for(int i = 0; i < str.length(); i++){
        if(str.charAt(i) > '9' || str.charAt(i) < '0'){
           return false;
        }
      }
      return true;
    }

    public static void main(String[] args){
      AToI s = new AToI();
      System.out.println(s.myAtoi("-560"));
    }

}

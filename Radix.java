public class Radix{
  public static void radixsort(int[]data){
    @SuppressWarnings({"unchecked" , "rawtypes"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    int largestDigit = getLargest(data) + "".length();
    largestDigit =  (int)Math.pow(10, largestDigit - 1);
    
  }

  private static int getLargest(int[]data){
    int ans = data[0];
    for(int i = 1; i < data.length; i++){
      if(data[i] > ans){
        ans = data[i];
      }
    }
    return ans;
  }
}

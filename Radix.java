import java.util.Arrays;
public class Radix{
  public static void radixsort(int[]data){
    if(data.length == 0){
      return ;
    }
    @SuppressWarnings({"unchecked" , "rawtypes"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[19];
    int bucketIndex = 0;
    int MAX = getLargest(data) + "".length();
  }

  private static int getLargest(int[]data){
    //starting with the first element, compare the ans variable to all the elements to find th greatest value
    int ans = data[0];
    for(int i = 1; i < data.length; i++){
      if(data[i] > ans){
        ans = data[i];
      }
    }
    return ans;
  }

  private static int getDigit(int digit, Integer value){
    //basically we first divide by 10 to the power of the digit input(integer division)
    //this yields us only the digits from our desire digit onwards until the last digit (from right to left)
    //we then mod this by 10 to only get our desired digit
    int dig = (int)Math.pow(10 , digit);
    value = Math.abs(value);
    value =  value / dig;
    value = value % 10;
    return value;
  }

  private static void combine(MyLinkedList<Integer> list, MyLinkedList<Integer>[] buckets){
    //iterates through the buckets array and list extends those linkedlists in each bucket
    for(int i = 0; i < buckets.length; i++){
      if(buckets[i] != null){
        if(buckets[i].size() != 0){
          list.extend(buckets[i]);
          buckets[i].clear();
        }
      }
    }
  }

  private static void combine(MyLinkedList<Integer> list, int[] data){
    //just copy over each data point
    for(int i = 0; i < data.length; i++){
      data[i] = (int)list.removeFront();
    }
  }

  public static void main(String[] args) {
    int[] data = {12, -31, 24, -42, 02, -01, 14, -21, 00};
    int[] data1 = {};
    System.out.println(Arrays.toString(data));
    radixsort(data);
    System.out.println(Arrays.toString(data));
    System.out.println(Arrays.toString(data1));
    radixsort(data1);
    System.out.println(Arrays.toString(data1));
  }

}

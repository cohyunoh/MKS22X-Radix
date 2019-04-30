import java.util.Arrays;
public class Radix{
  public static void radixsort(int[]data){
    @SuppressWarnings({"unchecked" , "rawtypes"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for(int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    if(data.length == 0){
      return ;
    }
    MyLinkedList<Integer> list = new MyLinkedList<Integer>();
    int MAX = getLargest(data, list);
    int digit = 0;
    while(digit < MAX){
      int size = list.size();
      //System.out.println(list);
      for(int i = 0; i < size; i++){
        //get the first value of the list and remove it at the same time
        Integer val = list.removeFront();
        //get the desired digit
        int dig = getDigit(digit, val);
        //if the number is positive
        if(val < 0){
          buckets[9-dig].add(val);
        }else{
          //add it to the index of 10 plus the digit
          buckets[dig + 10].add(val);
        }
      }
      combine(list,buckets);
      digit ++;
    }
    combine(list, data);
  }
  private static int getLargest(int[]data, MyLinkedList<Integer> list){
    //starting with the first element, compare the ans variable to all the elements to find th greatest value
    int ans = 0;
    for(int i = 0; i < data.length; i++){
      if (Math.abs(data[i]) > Math.pow(10, ans)){
        ans = (int)Math.ceil(Math.log10(Math.abs(data[i])));
      }
      list.add(data[i]);
    }
    return ans;
  }

  private static int getDigit(int digit, Integer value){
    //basically we first divide by 10 to the power of the digit input(integer division)
    //this yields us only the digits from our desire digit onwards until the last digit (from right to left)
    //we then mod this by 10 to only get our desired digit
    int dig = (int)Math.pow(10 , digit);
    value = (Math.abs(value) / dig) % 10;
    return value;
  }

  private static void combine(MyLinkedList<Integer> list, MyLinkedList<Integer>[] buckets){
    //iterates through the buckets array and list extends those linkedlists in each bucket
    for(int i = 0; i < buckets.length; i++){
      if(buckets[i].size() > 0){
        list.extend(buckets[i]);
        buckets[i].clear();
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
    int[] data = {1, -3, 2, -4, 0, -0, 1, -1, 0};
    int[] data1 = {};
    System.out.println(Arrays.toString(data));
    radixsort(data);
    System.out.println(Arrays.toString(data));
    System.out.println(Arrays.toString(data1));
    radixsort(data1);
    System.out.println(Arrays.toString(data1));
    System.out.println(Math.log10(1));
    System.out.println(Math.ceil(Math.log10(1)));
  }

}

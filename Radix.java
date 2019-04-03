import java.util.Arrays;
public class Radix{
  public static void radixsort(int[]data){
    @SuppressWarnings({"unchecked" , "rawtypes"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    int largestDigit = getLargest(data) + "".length();
    MyLinkedList<Integer> list = new MyLinkedList<Integer>();
    //go through first digits
    int bucketIndex = 0;
    while(bucketIndex < largestDigit){
      if(bucketIndex == 0){
        for(int i = 0; i < data.length; i++){
          int dig = getDigit(bucketIndex, data[i]);
          if(data[i] < 0){
            if(buckets[9-dig] == null){
              buckets[9-dig] = new MyLinkedList<Integer>();
            }
            buckets[9-dig].add(data[i]);
          }else if(data[i] > 0){
            if(buckets[dig + 10] == null){
              buckets[dig + 10] = new MyLinkedList<Integer>();
            }
            buckets[dig + 10].add(data[i]);
          }
        }
        combine(list,buckets);
        bucketIndex ++;
      }else{
        int size = list.size();
        //System.out.println(list);
        for(int i = 0; i < size; i++){
          Integer val = list.removeFront();
          int dig = getDigit(bucketIndex, val);
          if(val < 0){
            if(buckets[9-dig] == null){
              buckets[9-dig] = new MyLinkedList<Integer>();
            }
            buckets[9-dig].add(val);
          }else if(val > 0){
            if(buckets[dig + 10] == null){
              buckets[dig + 10] = new MyLinkedList<Integer>();
            }
            buckets[dig + 10].add(val);
          }
        }
        combine(list,buckets);
        bucketIndex ++;
      }
      System.out.println(list);
    }
    combine(list, data);
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

  private static int getDigit(int digit, Integer value){
    int dig = (int)Math.pow(10 , digit);
    value = Math.abs(value);
    value =  value / dig;
    value = value % 10;
    return value;
  }

  private static void combine(MyLinkedList<Integer> list, MyLinkedList<Integer>[] buckets){
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
    for(int i = 0; i < data.length; i++){
      data[i] = (int)list.removeFront();
    }
  }

  public static void main(String[] args) {
    int[] data = {12, -31, 24, -42, 02, -01, 14, -21};
    System.out.println(Arrays.toString(data));
    radixsort(data);
    System.out.println(Arrays.toString(data));
  }

}

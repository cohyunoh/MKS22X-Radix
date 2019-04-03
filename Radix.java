import java.util.Arrays;
public class Radix{
  public static void radixsort(int[]data){
    @SuppressWarnings({"unchecked" , "rawtypes"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    //this is the highest digit in the list
    int largestDigit = getLargest(data) + "".length();
    //this will store the values after each pass
    MyLinkedList<Integer> list = new MyLinkedList<Integer>();
    //go through first digits
    //this will keep track of which digit we looking at
    int bucketIndex = 0;
    //keep running until we reach the highest digit
    while(bucketIndex < largestDigit){
      //for the first pass through transfer from data to buckets then to list
      if(bucketIndex == 0){
        for(int i = 0; i < data.length; i++){
          //get the digit
          int dig = getDigit(bucketIndex, data[i]);
          //if the number is negative
          if(data[i] < 0){
            //make sure the bucket we are adding to is instantiated
            if(buckets[9-dig] == null){
              buckets[9-dig] = new MyLinkedList<Integer>();
            }
            //add it to the index of 9 minus the digit
            buckets[9-dig].add(data[i]);
          //if the number is positive
          }else if(data[i] > 0){
            //make sure the bucket we are adding to is instantiated
            if(buckets[dig + 10] == null){
              buckets[dig + 10] = new MyLinkedList<Integer>();
            }
            //add it to the index of 10 plus the digit
            buckets[dig + 10].add(data[i]);
          }
        }
        //transfer the values in order to list
        combine(list,buckets);
        //go to the next digit
        bucketIndex ++;
      }else{
        int size = list.size();
        //System.out.println(list);
        for(int i = 0; i < size; i++){
          //get the first value of the list and remove it at the same time
          Integer val = list.removeFront();
          //get the desired digit
          int dig = getDigit(bucketIndex, val);
          //if the number is positive
          if(val < 0){
            //make sure the bucket we are adding to is instantiated
            if(buckets[9-dig] == null){
              //add it to the index of 9 minus the digit
              buckets[9-dig] = new MyLinkedList<Integer>();
            }

            buckets[9-dig].add(val);
          }else if(val > 0){
            //make sure the bucket we are adding to is instantiated
            if(buckets[dig + 10] == null){
              buckets[dig + 10] = new MyLinkedList<Integer>();
            }
            //add it to the index of 10 plus the digit
            buckets[dig + 10].add(val);
          }
        }
        //transfer the values in order to list
        combine(list,buckets);
        bucketIndex ++;
        bucketIndex ++;
      }
      //System.out.println(list);
    }
    //transfer all the values from list to data
    combine(list, data);
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
    int[] data = {12, -31, 24, -42, 02, -01, 14, -21};
    System.out.println(Arrays.toString(data));
    radixsort(data);
    System.out.println(Arrays.toString(data));
  }

}

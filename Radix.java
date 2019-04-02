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
          int dig = getDigit(data[i]);
          if(data[i] < 0){
            buckets[9-dig] = data[i];
          }else if(data[i] > 0){
            buckets[dig + 10] = data[i];
          }
        }
        combine(list,buckets);
      }else{
        for(int i = 0; i < list.size(); i++){
          int dig = getDigit(list.);
          if(data[i] < 0){
            buckets[9-dig] = data[i];
          }else if(data[i] > 0){
            buckets[dig + 10] = data[i];
          }
        }
        combine(list,buckets);
      }
    }
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

  private static int getDigit(int digit, int value){
    int dig = (int)Math.pow(10 , digit);
    value =  value / dig;
    value = value % 10;
    return value;
  }

  private static void combine(MyLinkedList<Integer> list, MyLinkedList<Integer>[] buckets){
    for(int i = 0; i < buckets.length; i++){
      list.extend(buckets[i]);
      buckets[i].clear();
    }
  }

  public static void main(String[] args) {
    System.out.println(getDigit(0, 987654321));
    System.out.println(getDigit(1, 987654321));
    System.out.println(getDigit(2, 987654321));
    System.out.println(getDigit(3, 987654321));
    System.out.println(getDigit(4, 987654321));
    System.out.println(getDigit(5, 987654321));
    System.out.println(getDigit(6, 987654321));
    System.out.println(getDigit(7, 987654321));
    System.out.println(getDigit(8, 987654321));
  }
}

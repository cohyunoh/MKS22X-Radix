public class Radix{
  public static void radixsort(int[]data){
    @SuppressWarnings({"unchecked" , "rawtypes"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    int largestDigit = getLargest(data) + "".length();
    MyLinkedList<Integer> list = new MyLinkedList<Integer>();
    //go through first digits
    int bucketIndex = 0;

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

  private static int putIntoBucket(int digit, int value){
    int dig = (int)Math.pow(10 , digit);
    value =  value / dig;
    value = value % 10;
    return value;
  }

  public static void main(String[] args) {
    System.out.println(putIntoBucket(0, 987654321));
    System.out.println(putIntoBucket(1, 987654321));
    System.out.println(putIntoBucket(2, 987654321));
    System.out.println(putIntoBucket(3, 987654321));
    System.out.println(putIntoBucket(4, 987654321));
    System.out.println(putIntoBucket(5, 987654321));
    System.out.println(putIntoBucket(6, 987654321));
    System.out.println(putIntoBucket(7, 987654321));
    System.out.println(putIntoBucket(8, 987654321));
  }
}

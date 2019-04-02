public class MyLinkedList<E>{
  class Node{
    private E data;
    private Node next,prev;
    //constructor 1 for a middle node
    public Node(E inpt, Node nexInpt, Node prevInpt){
      data = inpt;
      next = nexInpt;
      prev = prevInpt;
    }
    //constructor 2 for beginning/ending node
    public Node(E inpt, Node nodeInpt, boolean end){
      if(end){
        data = inpt;
        next = null;
        prev = nodeInpt;
      }
      else{
        data = inpt;
        next = nodeInpt;
        prev = null;
      }
    }
    //if there is no other nodes to reference
    public Node(E inpt){
      data = inpt;
      next = null;
      prev = null;
    }
    //Empty node
    public Node(){
      data = null;
      next = null;
      prev = null;
    }
    //returns value of node
    public E getData(){
      return data;
    }
    //returns reference of next node
    public Node next(){
      return next;
    }
    //returns reference of previous node
    public Node prev(){
      return prev;
    }
    // sets the value of node
    public E setData(E inpt){
      E oldval = data;
      data = inpt;
      return oldval;
    }
    //sets the reference of the next node
    public void setNext(Node inpt){
      next = inpt;
    }
    //sets the reference of the previous node
    public void setPrev(Node inpt){
      prev = inpt;
    }
    //returns the value of data as a String
    public String toString(){
      String ans = "";
      ans += data;
      return ans;
    }
  }
  private Node start;
  private Node end;
  private int size;
  //converts list into a string
  public String toString(){
    //this is the starting node
    Node base = start;
    String ans = "[";
    //only loops to the second to last node so we can print out a pretty product
    for (int i = 0; i < size - 1; i++){
      //it will get the value of the current base
      ans += base + ", ";
      //the base will then change into the stored next node reference
      base = base.next();
    }
    //final value to print out
    ans += base + "]";
    return ans;
  }

  public MyLinkedList(){
    //empty nodes
    start = new Node();
    end = new Node();
    // the default size is zero
    size = 0;
  }

  //adds value to end of list
  public boolean add(E value){
    //if empty list then set the value as the new start node
    if(size == 0){
      start = new Node(value);
      size +=1;
      return true;
    }
    //if there is only one value then make the value the new end node
    if(size == 1){
      end = new Node(value, start, true);
      start.setNext(end);
      size +=1;
      return true;
    }
    //make a new node that has the original end as its previous node
    Node newEnd = new Node(value, end, true);
    //set the original end's next value to the new end, making it a middle node
    end.setNext(newEnd);
    end = newEnd;
    //increase the size by one
    size +=1;
    return true;
  }


  public E removeFront(){
    //create a node to store the new start node, which will be the next node from start
    Node newStart = start.next();
    //set the next node's prev reference from the start node to null
    //we are making it a start node
    newStart.setPrev(null);
    //we set the next reference in the old start to null, which means we will never be able
    //to reference it
    start.setNext(null);
    //this stores the old start's data value
    E oldInt =  start.getData();
    //this reassigns start to the new start
    start = newStart;
    //decrease the size by 1
    size -= 1;
    //returns the old data value
    return oldInt;
  }

  public void extend(MyLinkedList<E> other){
    end.setNext(other.getNode(0));
    other.getNode(0).setPrev(end);
    end = other.getNode(other.size() - 1);
    size += other.size();
    other.clear();
  }

  public Node getNode(int index) {
    Node ans = start;
    //will check if it's a null value
    if (index >= size || index < 0){
      throw new NullPointerException("No Node at Index");
    }
    else{
      //this will loop until the right node is selected
      for (int i = 0; i<index && i < size - 1; i++){
        ans = ans.next();
      }
    }
    return ans;
  }

  //returns size of the linked list
  public int size(){
    return size;
  }

  public void clear(){
    size = 0;
    start = new Node();
    end = new Node();
  }
}

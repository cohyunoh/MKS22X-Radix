public class LinkedList<E>{
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
}

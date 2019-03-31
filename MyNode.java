public class MyNode<E> {
  private E data;
  private MyNode next, prev;

  public MyNode(E num) {
    data = num;
  }

  public MyNode(E num, MyNode nodeN, MyNode nodeP) {
    data = num;
    next = nodeN;
    prev = nodeP;
  }

  // --- Methods are self-explanatory --- //

  public void setNext(MyNode n) {
    next = n;
  }

  public void setPrev(MyNode p) {
    prev = p;
  }

  public E setData(E num) {
    E output = data;
    data = num;
    return output;
  }

  public MyNode next() {
    return next;
  }

  public MyNode prev() {
    return prev;
  }

  public E data() {
    return data;
  }

  public String toString() {
    return "" + data;
  }


}

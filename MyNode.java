public class MyNode<E> {
  private E data;
  private MyNode<E> next, prev;

  public MyNode(E num) {
    data = num;
  }

  public MyNode(E num, MyNode<E> nodeN, MyNode<E> nodeP) {
    data = num;
    next = nodeN;
    prev = nodeP;
  }

  // --- Methods are self-explanatory --- //

  public void setNext(MyNode<E> n) {
    next = n;
  }

  public void setPrev(MyNode<E> p) {
    prev = p;
  }

  public E setData(E num) {
    E output = data;
    data = num;
    return output;
  }

  public MyNode<E> next() {
    return next;
  }

  public MyNode<E> prev() {
    return prev;
  }

  public E data() {
    return data;
  }

  public String toString() {
    return "" + data;
  }


}

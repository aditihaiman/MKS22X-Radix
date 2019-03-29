public class MyNode {
  private Integer data;
  private MyNode next, prev;

  public MyNode(Integer num) {
    data = num;
  }

  public MyNode(Integer num, MyNode nodeN, MyNode nodeP) {
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

  public Integer setData(Integer num) {
    Integer output = data;
    data = num;
    return output;
  }

  public MyNode next() {
    return next;
  }

  public MyNode prev() {
    return prev;
  }

  public Integer data() {
    return data;
  }

  public String toString() {
    return "" + data;
  }


}

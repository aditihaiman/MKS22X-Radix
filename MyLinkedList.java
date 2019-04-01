public class MyLinkedList<E> {
  private MyNode<E> end, start;
  private int length;


  public MyLinkedList() {
    length = 0;
    start = new MyNode(null);
    end = new MyNode(null);
  }

  public void clear() {
    length = 0;
    start = new MyNode(null);
    end = new MyNode(null);
  }

  public void extend(MyLinkedList<E> other) {
    if (other.size()!=0) { //ignores case where other is empty
      if (this.size()== 0) { //checks special case where this is empty
        this.start.setNext(other.start.next());
        other.start.next().setPrev(this.start);
        this.end.setPrev(other.end.prev());
        other.end.prev().setNext(this.end);
      }
      else {
        this.end.prev().setNext(other.start.next()); // combines the first and last elements
        other.start.next().setPrev(this.end.prev()); // of the two lists
        this.end.setPrev(other.end.prev());
        other.end.prev().setNext(this.end);

      }
      this.length+=other.length; //fixes lengths
      other.length=0;
    }
  }

  public boolean add(E value) {
    MyNode<E> newNode = new MyNode(value);
    if (length == 0) { //exception, if an empty list, then add inbetween start and end
      start.setNext(newNode);
      end.setPrev(newNode);
      newNode.setNext(end);
      newNode.setPrev(start);
    }
    else{ //else, add before end, after end.prev
      newNode.setPrev(end.prev());
      end.prev().setNext(newNode);
      end.setPrev(newNode);
      newNode.setNext(end);
    }
    length++;
    return true;
  }

  public String toString() {
    if (length == 0) return "[]"; //empty list exception
    String output = "[";
    MyNode<E> current = start.next();
    while (current.data() != null) { //loops through all nodes between start and end
      output += current.data() + ", ";
      current = current.next();
    }
    return output.substring(0, output.length()-2) + "]";
  }

  public void add(int index, E value) {
    if (index < 0 || index > length) throw new IndexOutOfBoundsException();
    MyNode<E> current = start;
    if (index == length) add(value);
    else {
      for (int x = 0; x < length; x++) { //loops through, when it reaches the index specified, sets data to value
        if (x==index) {
          MyNode<E> newN = new MyNode(value, current.next(), current);
          current.setNext(newN);
          newN.next().setPrev(newN);
          current = current.next();
        }
        current = current.next();
      }
    length++;
    }
  }

  public E removeFront() {
    MyNode<E> node = start.next();
    start.setNext(node.next());
    node.next().setPrev(start);
    length--;
    return node.data();
  }




//--------------------- Unnecessary methods ---------------------//

public E remove(int index) {
  if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
  MyNode<E> node = getNthNode(index);
  node.prev().setNext(node.next());
  node.next().setPrev(node.prev());
  length--;
  return node.data();
}

  public boolean remove(E value){
    if (!contains(value)) return false;
    remove(indexOf(value));
    return true;
  }

  public E get(int index) {
    if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
    return getNthNode(index).data();
  }

  public E set(int index, E value) {
    if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
    return getNthNode(index).setData(value);
  }

  public boolean contains(E value) {
    MyNode<E> current = start.next();
    boolean output = false;
    for (int x = 0; x < length; x++) { //loops through list, if value exists then output is set to true
      if (current.data().equals(value)) output = true;
      current = current.next();
    }
    return output;
  }

  public int indexOf(E value) {
    MyNode<E> current = start.next();
    int output = -1;
    for (int x = 0; x < length; x++) {
      if (current.data().equals(value)) output = x;
      current = current.next();
    }
    return output;
  }

  public int size() {
    return length;
  }

// -- Helper Method -- //
//linear
  private MyNode<E> getNthNode(int index) { //private helper method to find node at an index
    MyNode<E> current = start.next();
    MyNode<E> output = current;
    for (int x = 0; x < length; x++) {
      if (x == index) {
        output = current;
      }
      current = current.next();
    }
    return output;
  }


}

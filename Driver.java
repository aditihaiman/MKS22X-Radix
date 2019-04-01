import java.util.*;
import java.io.*;

public class Driver {
  public static void main(String[] args) {

    int[] test = {10, 17, 26, 24, 9, 13};
    Radix.radixsort(test);
    System.out.println(Arrays.toString(test));

    // MyLinkedList<Integer> a = new MyLinkedList<Integer>();
    // MyLinkedList<Integer> b = new MyLinkedList<Integer>();
    // a.add(3); b.add(24);
    // System.out.println(a + " ; " + b);
    // a.extend(b);
    // System.out.println(a + " ; " + b);

  }


}

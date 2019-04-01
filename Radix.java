import java.util.*;
import java.io.*;

public class Radix {

  public void radixsort(int[] data) {
    int max = getMax(data);
    MyLinkedList[] buckets = new MyLinkedList[10];
    MyLinkedList<Integer> data1 = new MyLinkedList<Integer>();
    copy(data, data1);

    for(int x = max; x > 0; x /= 10) {
      int digits = 0;
      for(int y = 0; y < data.length; y++) {
        buckets[(data1.get(y)/(10^digits))%10].add(data1.get(y));
      }
      digits++;
    }


  }

  public static int getMax(int[] data) {
    int max = 0;
    for(int x = 0; x < data.length; x++) {
      if(Math.abs(data[x]) > max) max = Math.abs(data[x]);
    }
    return max;
  }

  public static void copy(int[] data, MyLinkedList<Integer> data1) {
    for(int x = 0; x < data.length; x++) {
      data1.add(data[x]);
    }
  }

}

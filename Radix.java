import java.util.*;
import java.io.*;

public class Radix {

  public void radixsort(int[] data) {
    int max = getMax(data);
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    MyLinkedList<Integer> data1 = new MyLinkedList<Integer>();
    copy(data, data1);
    for(int x = max; x > 0; x /= 10) {
      int digits = 0;
      for(int y = 0; y < data.length; y++) {
        buckets[(data1.get(y)/(10^digits))%10].add(data1.get(y));
      }
      digits++;
      extend(data1, buckets);
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

  public static void copy2()

  public static void extend(MyLinkedList<Integer> data1, MyLinkedList<Integer>[] bucket) {
    data1.clear();
    for(int x = 0; x < bucket.length; x++) {
      data1.extend(bucket[x]);
    }
  }

}

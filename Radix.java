import java.util.*;
import java.io.*;

public class Radix {

  public static void radixsort(int[] data) {
    int max = getMax(data);
    ArrayList<MyLinkedList<Integer>> buckets = new ArrayList<MyLinkedList<Integer>>();
    for(int x = 0; x < 10; x++){
      buckets.add(new MyLinkedList<Integer>());
    }
    MyLinkedList<Integer> data1 = new MyLinkedList<Integer>();
    copy(data, data1);
    for(int x = 0; Math.abs(max/10^x) > 0; x++) {
      for(int y = 0; y < data.length; y++) {
        buckets.get((int)(data1.get(y)/Math.pow(10, x)%10)).add(data1.get(y));
        System.out.println(buckets);
      }
      extend(data1, buckets);
    }
    copy2(data, data1);

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

  public static void copy2(int[] data, MyLinkedList<Integer> data1) {
    for(int x = 0; x < data.length; x++) {
      data[x]=data1.get(x);
    }
  }

  public static void extend(MyLinkedList<Integer> data1, ArrayList<MyLinkedList<Integer>> bucket) {
    data1.clear();
    for(int x = 0; x < bucket.size(); x++) {
      data1.extend(bucket.get(x));
    }
  }

}

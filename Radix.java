import java.util.*;
import java.io.*;

public class Radix {
  private static int BASE = 1000;

  public static void radixsort(int[] data) {
    int temp1[] = getMaxMin(data); //get max an min
    int max = getDigits(temp1[0] - temp1[1]); //digits of largest number
    int min = temp1[1];
    MyLinkedList<Integer>[] buckets = new MyLinkedList[BASE];
    for(int x = 0; x < buckets.length; x++){
      buckets[x] = new MyLinkedList<Integer>();
    }
    MyLinkedList<Integer> data1 = new MyLinkedList<Integer>();
    copy(data, data1, min); //copy original to new linked list
    for(int x = 0; x < max; x++) { //loops through for each digit
      while(data1.size()>0) {
        int temp = data1.removeFront();
        buckets[(int)(temp/Math.pow(BASE, x)%BASE)].add(temp); //adds each number to appropriate bucket
      }
      extend(data1, buckets);

    }
    copy2(data, data1, min); //copy buckets back to original
  }

  public static int getMin(int[] data){
    int min = data[0];
    for(int x = 1; x < data.length; x++){
      if(data[x] < min) min = data[x];
    }
    return min;
  }

  public static int[] getMaxMin(int[] data) {
    int output[] = new int[2];
    int max = data[0], min = data[0];
    for(int x = 0; x < data.length; x++) {
      if(data[x] > max) max = data[x];
      if(data[x] < min) min = data[x];
    }
    output[0] = max;
    output[1] = min;
    return output;
  }

  public static int getDigits(int max){
    if (max==0) return 1;
    int count = 0;
    for(int x = max; max > 0; max/=BASE){
      count++;
    }
    return count;
  }

  public static void copy(int[] data, MyLinkedList<Integer> data1, int min) { //copy original to linked list
    for(int x = 0; x < data.length; x++) {
      data1.add(data[x] - min);
    }
  }

  public static void copy2(int[] data, MyLinkedList<Integer> data1, int min) { //copy linked list back to original
    for(int x = 0; x < data.length; x++) {
      data[x]=data1.removeFront() + min;
    }
  }

  public static void extend(MyLinkedList<Integer> data1, MyLinkedList<Integer>[] bucket) {
    for(int x = 0; x < bucket.length; x++) {
      data1.extend(bucket[x]);
    }
  }





}

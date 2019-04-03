import java.util.*;
import java.io.*;

public class Radix {

  public static void radixsort(int[] data) {
    int max = getDigits(getMax(data));
    //System.out.println(max);
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for(int x = 0; x < buckets.length; x++){
      buckets[x] = new MyLinkedList<Integer>();
    }
    MyLinkedList<Integer> data1 = new MyLinkedList<Integer>();
    copy(data, data1); //copy original to new linked list
    for(int x = 0; x < max; x++) { //loops through for each digit
      while(data1.size()>0) {
        int temp = data1.removeFront();
        //System.out.println("A");

        if(temp>=0) {
          buckets[(int)(temp/Math.pow(10, x)%10)].add(temp); //adds each number to appropriate bucket
        }
        else{
          temp*=-1;
          buckets[(int)(temp/Math.pow(10, x)%10) + 10].add(temp*-1);
        }
      }
      if(x+1 == max) extend2(data1, buckets);
      else extend(data1, buckets);

    }
    copy2(data, data1); //copy buckets back to original
  }

  public static int getMax(int[] data) {
    int max = 0;
    for(int x = 0; x < data.length; x++) {
      if(Math.abs(data[x]) > max) max = Math.abs(data[x]);
    }
    return max;
  }

  public static int getDigits(int max){
    if (max==0) return 1;
    int count = 0;
    for(int x = max; max > 0; max/=10){
      count++;
    }
    return count;
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

  public static void extend(MyLinkedList<Integer> data1, MyLinkedList<Integer>[] bucket) {
    for(int x = 0; x < bucket.length; x++) {
      data1.extend(bucket[x]);
    }
  }

  public static void extend2(MyLinkedList<Integer> data1, MyLinkedList<Integer>[] bucket) {
    for(int x = 19; x > 9; x--){
      data1.extend(bucket[x]);
    }
    for(int x = 0; x < 10; x++) {
      data1.extend(bucket[x]);
    }
  }


}

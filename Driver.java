import java.util.*;
import java.io.*;

public class Driver {
  public static void main(String[] args) {
    Random r = new Random(4);

    int[] test = {-1002, 1702, 2262, -1242, 1922, 3132, 2190};
    //test = new int[100000];
    //int[] test1 = new int[10000];
    // for(int x = 0; x < test.length; x++) {
    //   int temp = Math.abs(r.nextInt(10));
    //   test[x] = temp;
    //   //test1[x] = temp;
    // }

    Radix.radixsort(test);

    // for(int x = 0; x < test.length; x++){
    //   if (test[x]!=test1[x]) System.out.println("X");
    // }
    System.out.println(Arrays.toString(test));

    // MyLinkedList<Integer> a = new MyLinkedList<Integer>();
    // MyLinkedList<Integer> b = new MyLinkedList<Integer>();
    // a.add(3); b.add(24);
    // System.out.println(a + " ; " + b);
    // a.extend(b);
    // System.out.println(a + " ; " + b);

  }

// public static void main(String[]args){
//     System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
//     int[] MAX_LIST = {1000000000,500,10};
//     for(int MAX : MAX_LIST){
//       for(int size = 31250; size < 2000001; size*=2){
//         long qtime=0;
//         long btime=0;
//         //average of 5 sorts.
//         for(int trial = 0 ; trial <=5; trial++){
//           int []data1 = new int[size];
//           int []data2 = new int[size];
//           for(int i = 0; i < data1.length; i++){
//             data1[i] = (int)(Math.random()*MAX);
//             data2[i] = data1[i];
//           }
//           long t1,t2;
//           t1 = System.currentTimeMillis();
//           Radix.radixsort(data2);
//           t2 = System.currentTimeMillis();
//           qtime += t2 - t1;
//           t1 = System.currentTimeMillis();
//           Arrays.sort(data1);
//           t2 = System.currentTimeMillis();
//           btime+= t2 - t1;
//           if(!Arrays.equals(data1,data2)){
//             System.out.println("FAIL TO SORT!");
//             System.exit(0);
//           }
//         }
//         System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
//       }
//       System.out.println();
//     }
//   }


}

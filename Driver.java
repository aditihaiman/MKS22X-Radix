import java.util.*;
import java.io.*;

public class Driver {
  public static void main(String[] args) {

    int[] test = {10, 17, 26, 24, 9, 13};
    Radix.radixsort(test);
    System.out.println(Arrays.toString(test));

  }


}

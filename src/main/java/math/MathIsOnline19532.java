package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class MathIsOnline19532 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] prepared = Arrays.stream(br.readLine().split(" ")).mapToInt(
        Integer::parseInt).toArray();

    int a = prepared[0];  int b = prepared[1];  int c = prepared[2];
    int d = prepared[3];  int e = prepared[4];  int f = prepared[5];

//    for (int y = -1000; y < 1000; y++) {
//      int n = c - b * y;
//      if((a != 0) && ((n % a) == 0)) {
//        int x = n / a;
//        if(d * x + e * y == f) {
//          System.out.println(x + " " + y);
//          return;
//        }
//      }
//    }

  }
}

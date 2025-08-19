package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Flip1439 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] inp = br.readLine().toCharArray();

    boolean flag0 = false;
    boolean flag1 = false;

    int f1 = 0;
    int f0 = 0;

    for (char c : inp) {
      if (c == '0' && !flag0) {
        f0++;
        flag0 = true;
        flag1 = false;
      }

      if (c == '1' && !flag1) {
        f1++;
        flag0 = false;
        flag1 = true;
      }
    }

    System.out.println(Math.min(f0, f1));
  }

}

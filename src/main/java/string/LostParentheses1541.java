package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LostParentheses1541 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] removeMinus = br.readLine().split("-");

    long result = 0;
    long temp;

    for (int i = 0; i < removeMinus.length; i++) {
      if (removeMinus[i].contains("+")) {
        temp = Arrays.stream(removeMinus[i].split("\\+"))
            .map(Integer::parseInt).mapToInt(value -> value).sum();
      } else {
        temp = Integer.parseInt(removeMinus[i]);
      }

      if (i != 0) {
        result -= temp;
      } else {
        result += temp;
      }
    }
    System.out.println(result);
  }
}

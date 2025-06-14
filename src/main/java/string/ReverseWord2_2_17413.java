package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWord2_2_17413 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] input = br.readLine().toCharArray();
    StringBuilder sb = new StringBuilder();

    boolean isInTag = false;
    StringBuilder temp = new StringBuilder();

    for (char c : input) {
      if (c == '<' || isInTag) {
        isInTag = true;
        sb.append(temp.reverse()).append(c);
        temp.setLength(0);

        if (c == '>') {
          isInTag = false;
        }
      } else if (c == ' ') {
        sb.append(temp.reverse()).append(c);
        temp.setLength(0);

      } else {
        temp.append(c);
      }
    }

    // isEmpty가 자바 11 기준으로는 안됨
    if (temp.length() != 0) {
      sb.append(temp.reverse());
    }

    System.out.println(sb);
  }

}

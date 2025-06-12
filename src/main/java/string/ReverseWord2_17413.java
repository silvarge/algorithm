package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWord2_17413 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] temp = br.readLine().toCharArray();
    StringBuilder sb = new StringBuilder();
    StringBuilder tmp = new StringBuilder();
    boolean isInTag = false;

    for (char c : temp) {

      if (c == '<') {
        isInTag = true;
      }

      if (c == '>') {
        isInTag = false;
      }

      // 문자 뒤집을지 안뒤집을지
      if (isInTag || c == '>') {
        if (c == '<' && tmp.length() != 0) {
          sb.append(tmp.reverse());
          tmp.setLength(0);
        }
        sb.append(c);
      } else {
        if (c == ' ') {
          sb.append(tmp.reverse()).append(" ");
          tmp.setLength(0);
        } else {
          tmp.append(c);
        }

      }
    }
    sb.append(tmp.reverse());
    System.out.println(sb);
  }

}

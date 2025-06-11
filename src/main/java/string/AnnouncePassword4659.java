package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnnouncePassword4659 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String input;
    while (true) {

      input = br.readLine();

      if (input.equals("end")) {
        break;
      }

      // 모음: aeiou
      // 자음: bcdfghjklmnpqrstvwxyz

      // 모음 하나를 반드시 포함해야 한다.
      if (!(input.matches(".*[aeiou].*"))) {
        sb.append("<").append(input).append("> is not acceptable.\n");
        continue;
      }

      // 모음/자음이 3개 연속으로 오면 안 된다.
      if (input.matches(".*[aeiou]{3,}.*") || input.matches(".*[bcdfghjklmnpqrstvwxyz]{3,}.*")) {
        sb.append("<").append(input).append("> is not acceptable.\n");
        continue;
      }

      // 같은 글자가 연속으로 2번 나오면 안 된다 (예외 존재)
      if (input.matches(".*(.)\\1.*") && !input.matches(".*(ee|oo).*")) {
        sb.append("<").append(input).append("> is not acceptable.\n");
        continue;
      }

      sb.append("<").append(input).append("> is acceptable.\n");
    }
    System.out.println(sb);
  }

}

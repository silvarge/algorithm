package set_and_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AtoB16953 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    int cnt = 1;

    while (B >= A) {
      if (B == A) {
        break;
      }

      if (B % 10 == 1) {
        B /= 10;
        cnt++;
      } else if (B % 2 == 0) {
        B /= 2;
        cnt++;
      } else {
        cnt = -1;
        break;
      }
    }

    if (B != A) {
      cnt = -1;
    }

    System.out.println(cnt);
  }
}

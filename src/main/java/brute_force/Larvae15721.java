package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Larvae15721 {

  static int A, T, target;

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    A = Integer.parseInt(br.readLine());
    T = Integer.parseInt(br.readLine());
    target = Integer.parseInt(br.readLine());

    System.out.println(play());
  }

  static int play() {
    int b = 0;
    int d = 0;
    int repeat = 2;

    while (true) {
      // 번-데기-번-데기
      for (int i = 0; i < 4; i++) {
        if (i % 2 == 0) {  // 뻔
          b++;
        } else {  // 데기
          d++;
        }

        if (target == 0 && b == T) {
          return (b + d - 1) % A;
        }

        if (target == 1 && d == T) {
          return (b + d - 1) % A;
        }

      }

      // 번번
      for (int i = 0; i < repeat; i++) {
        b++;

        if (target == 0 && b == T) {
          return (b + d - 1) % A;
        }
      }

      // 데기데기
      for (int i = 0; i < repeat; i++) {
        d++;

        if (target == 1 && d == T) {
          return (b + d - 1) % A;
        }
      }

      repeat++;

    }

  }

}

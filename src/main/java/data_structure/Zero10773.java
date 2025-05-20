package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero10773 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> stack = new Stack<>();

    int N = Integer.parseInt(br.readLine());
    int num;
    for (int i = 0; i < N; i++) {
      num = Integer.parseInt(br.readLine());
      if(num == 0){
        stack.pop();
      }else {
        stack.push(num);
      }
    }

    int size = stack.size();
    int count = 0;
    for (int i = 0; i < size; i++) {
      count += stack.pop();
    }
    System.out.println(count);
  }

}

public class OveriddingTest {
  public void result(){
//    Fish a = new Fish();
//    Fish b = new Fish(1);
    Fish c = new Whale();
    Fish d = new Whale(1);
//    Whale e = new Whale();
//    Whale f = new Whale(1);
//    a.fn();
//    b.fn();
    c.fn();
    d.fn();
//    e.fn();
//    f.fn();
  }
}


class Fish{
  public Fish(){
    System.out.println("i'm fish");
  }
  public Fish(int a) {
    System.out.println(a + "Fish");
  }
  public void fn(){
    System.out.println("FFFish");
  }
}

class Whale extends Fish {

  @Override
  public void fn() {
    System.out.println("whaaaaaale");
  }

  public Whale(int a) {
    System.out.println("i'm Whale" + a);
  }

  public Whale() {
    System.out.println("i'm Whale");
  }
}

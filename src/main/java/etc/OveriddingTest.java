package etc;

public class OveriddingTest {
  public void result(){
//    etc.Fish a = new etc.Fish();
//    etc.Fish b = new etc.Fish(1);
    Fish c = new Whale();
    Fish d = new Whale(1);
//    etc.Whale e = new etc.Whale();
//    etc.Whale f = new etc.Whale(1);
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
    System.out.println(a + "etc.Fish");
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
    System.out.println("i'm etc.Whale" + a);
  }

  public Whale() {
    System.out.println("i'm etc.Whale");
  }
}

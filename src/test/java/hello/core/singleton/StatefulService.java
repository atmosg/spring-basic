package hello.core.singleton;

public class StatefulService {
  // 상태 유지 필드
  private int price = 10_000;

  public void order(String name, int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }
}

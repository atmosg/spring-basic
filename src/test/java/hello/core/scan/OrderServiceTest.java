package hello.core.scan;

import org.junit.jupiter.api.Test;
import hello.core.order.OrderServiceImpl;

public class OrderServiceTest {

  @Test
  void createOrder() {
    // 분명 아무런 오류 메시지도 안떠서 실행을 돌렸는데
    // 이게 웬걸 NullPointerException(NPE)가 떠버린다.
    // OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    // orderServiceImpl.createOrder(1L, "청소기", 230_000);
  }
}
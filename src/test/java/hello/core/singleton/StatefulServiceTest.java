package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class StatefulServiceTest {
  @Test
  void StatefulServiceSingleton() {
    AnnotationConfigApplicationContext ac =
      new AnnotationConfigApplicationContext(TestConfig.class);

    StatefulService service1 = ac.getBean("statefulService", StatefulService.class);
    StatefulService service2 = ac.getBean("statefulService", StatefulService.class);

    // 유저A는 10,000원 주문
    // 유저B는 20,000원 주문
    service1.order("UserA", 10_000);
    service2.order("UserB", 20_000);

    int price = service1.getPrice();
    System.out.println("UserA가 주문한 금액은? " + price);
    // 터미널 결과 : UserA가 주문한 금액은? 20000

    Assertions.assertThat(price).isEqualTo(20_000);
  }

  @Configuration
  static class TestConfig {
    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }
  }
}

package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SingletonServiceTest {
  @Test
  @DisplayName("싱글톤 패턴을 적용한 객체 사용")
  void SingletonServiceTest() {

    // new 생성자가 막혀있는지 확인해보자
    // SingletonService instance = new SingletonService();
    // ※ The constructor SingletonService() is not visible

    SingletonService instance1 = SingletonService.getInstance();
    SingletonService instance2 = SingletonService.getInstance();

    // 동일한 참조값을 가진다. 즉, 둘은 같은 객체
    // instacne1 : hello.core.singleton.SingletonService@618b19ad
    // instacne2 : hello.core.singleton.SingletonService@618b19ad
    System.out.println("instacne1 : " + instance1.toString());
    System.out.println("instacne2 : " + instance2.toString());

    Assertions.assertThat(instance1).isSameAs(instance2);
  }
}

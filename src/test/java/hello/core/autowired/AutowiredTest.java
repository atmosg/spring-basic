package hello.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class AutowiredTest {

  @Test
  void autowiredOptions() {
    AnnotationConfigApplicationContext context = 
      new AnnotationConfigApplicationContext(AutowiredTestConfig.class);

    TestBean testBean = context.getBean(TestBean.class);
    testBean.consoleMemberService(); // null
  }

  @Configuration
  @ComponentScan()
  static class AutowiredTestConfig {}
}

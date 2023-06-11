package hello.core.beanfind;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;

class ApplicationContextExtendsFindTest {
  AnnotationConfigApplicationContext ac = 
    new AnnotationConfigApplicationContext(TestConfig.class);

  @Test
  @DisplayName("부모 타입으로 조회시 자식이 둘 이상이면 중복 오류가 발생한다")
  void findDuplicatedBeansByParent() {
    // 아래 코드만 돌리면 중복 오류남
    // DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
    assertThrows(
      NoUniqueBeanDefinitionException.class,
      () -> ac.getBean(DiscountPolicy.class)
    );
  }

  @Test
  @DisplayName("부모 타입으로 조회시 자식이 둘 이상이라면 빈 이름을 지정하자")
  void findBeanByParentTypeBeanName() {
    DiscountPolicy rateDiscountPolicy = ac.getBean(
      "rateDiscountPolicy", 
      DiscountPolicy.class
      );
    Assertions.assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
  }

  @Test
  @DisplayName("Object 타입으로 모두 조회하기")
  void findAllBeansByObjectType() {
    Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
    for (String key : beansOfType.keySet()) {
      System.out.println("key : " + key + "\nvalue : " + beansOfType.get(key));
    }
  }

  @Test
  @DisplayName("부모 타입으로 모든 빈 조회하기")
  void findAllBeansByParentType() {
    Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
    System.out.println(beansOfType.toString());
    // {
    //    rateDiscountPolicy=hello.core.discount.RateDiscountPolicy@56e8b606, 
    //    fixDiscountPolicy=hello.core.discount.FixDiscountPolicy@2dd29a59
    // }
  }
  

  @Configuration
  static class TestConfig {
    @Bean
    public DiscountPolicy rateDiscountPolicy() {
      return new RateDiscountPolicy();
    }

    @Bean
    public DiscountPolicy fixDiscountPolicy() {
      return new FixDiscountPolicy();
    }
  }
}
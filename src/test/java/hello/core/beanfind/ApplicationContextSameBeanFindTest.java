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

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

class ApplicationContextSameBeanFindTest {
  AnnotationConfigApplicationContext ac = 
    new AnnotationConfigApplicationContext(SameBeanConfig.class);

  @Test
  @DisplayName("특정 타입의 모든 빈을 조회하기")
  void findAllBeanByType() {
    Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
    System.out.println("beansOfType : " + beansOfType);

    for (String key : beansOfType.keySet()) {
      System.out.println("key : "+ key + "\nvalue : " + beansOfType.get(key));
    }

    // 타입으로 조회한 빈들의 갯수가 2개인지 확인
    Assertions.assertThat(beansOfType.size()).isEqualTo(2);
  }

  @Test
  @DisplayName("동일한 타입이 존재한다면 중복 오류가 발생해야 한다")
  void findDuplicatedBeansByType() {
    assertThrows(
      NoUniqueBeanDefinitionException.class,
      () -> ac.getBean(MemberRepository.class)
    );
  }

  @Configuration
  static class SameBeanConfig {
    @Bean
    public MemberRepository memberRepository1() {
      return new MemoryMemberRepository();
    }

    @Bean
    public MemberRepository memberRepository2() {
      return new MemoryMemberRepository();
    }
  }
}

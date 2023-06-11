package hello.core.beanfind;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

class ApplicationContextBasicFindTest {
  AnnotationConfigApplicationContext ac = 
    new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("빈 이름으로 조회하기")
  void findBeanByName() {
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }
  

  @Test
  @DisplayName("존재하지 않는 빈 조회하기")
  void findNotBean() {
    assertThrows(NoSuchBeanDefinitionException.class, () ->
      ac.getBean("something", MemberService.class));
  }


  @Test
  @DisplayName("타입만으로 빈 조회하기")
  void findBeanByType() {
    MemberService memberService = ac.getBean(MemberService.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }


  @Test
  @DisplayName("구체 타입으로 조회하기")
  void findBeanByImplemented() {
    MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }
}

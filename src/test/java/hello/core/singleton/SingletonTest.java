package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;

class SingletonTest {
  
  @Test
  void springContainerTest() {
    AnnotationConfigApplicationContext ac = 
    new AnnotationConfigApplicationContext(AppConfig.class);

    MemberService memberService1 = ac.getBean("memberService", MemberService.class);
    MemberService memberService2 = ac.getBean("memberService", MemberService.class);

    // 동일한 객체가 두 번 호출된다
    // (2) hello.core.member.MemberServiceImpl@3af0a9da
    System.out.println(memberService1.toString());
    System.out.println(memberService2.toString());

    // 왜 얘들은 같지?
    Assertions.assertThat(memberService1).isEqualTo(memberService2);
  }

  @Test
  void pureContainerTest() {
    AppConfig appConfig = new AppConfig();

    MemberService memberService1 = appConfig.memberService();
    MemberService memberService2 = appConfig.memberService();

    // 서로 다른 참조값을 나타낸다
    // hello.core.member.MemberServiceImpl@6771beb3
    // hello.core.member.MemberServiceImpl@51399530
    System.out.println(memberService1.toString());
    System.out.println(memberService2.toString());

    // 서로 다른 참조값을 가지기 때문에
    // isNotEqualTo 테스트를 정상적으로 통과한다
    Assertions.assertThat(memberService1).isNotEqualTo(memberService2);
  }
}

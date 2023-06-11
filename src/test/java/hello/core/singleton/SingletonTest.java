package hello.core.singleton;

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

    System.out.println(memberService1.toString());
    System.out.println(memberService2.toString());
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
  }
}

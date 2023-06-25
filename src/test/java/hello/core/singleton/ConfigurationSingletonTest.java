package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
  @Test
  void configurationTest() {
    AnnotationConfigApplicationContext ac =
      new AnnotationConfigApplicationContext(AppConfig.class);

    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

    System.out.println(memberService.getMemberRepository());
    System.out.println(orderService.getMemberRepository());
    System.out.println(memberRepository);

    System.out.println(ac.getBean("appConfig", AppConfig.class));

    Assertions
      .assertThat(memberService.getMemberRepository())
      .isEqualTo(orderService.getMemberRepository());
  }
}

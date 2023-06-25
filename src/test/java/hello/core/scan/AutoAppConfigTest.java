package hello.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;

public class AutoAppConfigTest {

  @Test
  void basicScan() {
    AnnotationConfigApplicationContext ac = 
      new AnnotationConfigApplicationContext(AutoAppConfig.class);
  }

  // void basicScan() {
  //   MemberService memberService = ac.getBean(MemberService.class);

  //   System.out.println(memberService.getMemberRepository());
  //   Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
  // }

  // @Test
  // void findAppBean() {
  //   String[] beanDefNames = ac.getBeanDefinitionNames();
  //   for (String beanDefName :beanDefNames) {
  //     BeanDefinition beanDef = ac.getBeanDefinition(beanDefName);

  //     if (beanDef.getRole() != BeanDefinition.ROLE_APPLICATION) continue;

  //     System.out.println(ac.getBean(beanDefName));
  //   }
  // }
}
package hello.core.beandefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

class BeanDefinitionTest {
  AnnotationConfigApplicationContext ac =
    new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("빈 메타데이터 확인하기")
  void findApplicationBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for (String name : beanDefinitionNames) {
      BeanDefinition beanDef = ac.getBeanDefinition(name);

      if (beanDef.getRole() != BeanDefinition.ROLE_APPLICATION) continue;
      
      System.out.println("bean name : " + name + "\nbean def : " + beanDef);
    }
  }
}

package hello.core.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;


public class ComponentFilterAppConfigTest {
  
  @Test
  void filterScan() {
    AnnotationConfigApplicationContext ac = 
      new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

    BeanA beanA = ac.getBean("beanA", BeanA.class);
    // hello.core.scan.filter.BeanA@3569fc08
    System.out.println(beanA.toString());

    // beanB를 가져오려고 하면
    // NoSuchBeanDefinitionException 에러가 뜬다
    // BeanB beanB = ac.getBean("beanB", BeanB.class);

    Assertions.assertThrows(
      NoSuchBeanDefinitionException.class,
      () -> ac.getBean("beanB", BeanB.class)
    );
  }


  @Configuration
  @ComponentScan(
    includeFilters = @Filter(
      type = FilterType.ANNOTATION, 
      classes = MyIncludeComponent.class
    ),
    excludeFilters = @Filter(
      type = FilterType.ANNOTATION, 
      classes = MyExcludeComponent.class
    )
  )
  static class ComponentFilterAppConfig {}
}

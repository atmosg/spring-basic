package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class DiscountServiceTest {
  MemberService memberService;
  OrderService orderService;

  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
  }

  @Test
  void createOrder() {
    // given
    Long memberId = 1L;
    Member member = new Member(memberId, "MemberA", Grade.VIP);
    memberService.join(member);
  
    // when
    Order order = orderService.createOrder(memberId, "ItemA", 10_000);
    int discountPrice = order.getDiscountPrice();
  
    // then
    Assertions.assertThat(discountPrice).isEqualTo(1000);
  }
}
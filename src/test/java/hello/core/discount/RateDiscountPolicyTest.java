package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {
  RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("VIP회원은 10% 할인 적용")
  void vip_discount() {
    // given
    Member member = new Member(1L, "VIP", Grade.VIP);

    // when
    int discount = discountPolicy.discount(member, 10_000);

    // then
    Assertions.assertThat(discount).isEqualTo(1000);
  }

  @Test
  @DisplayName("BASIC회원은 할인 금액이 0원")
  void basic_discount() {
    Member member = new Member(2L, "BASIC", Grade.BASIC);
    int discount = discountPolicy.discount(member, 10_000);
    Assertions.assertThat(discount).isEqualTo(0);
  }
}

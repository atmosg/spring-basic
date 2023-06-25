package hello.core.autowired;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hello.core.member.MemberService;

@Component
public class TestBean {
  private final Optional<MemberService> memberService;

  @Autowired()
  public TestBean(Optional<MemberService> memberService) {
    System.out.println("TestBean 호출됐니? : " + memberService);
    this.memberService = memberService;
  }

  public void consoleMemberService() {
    System.out.println(memberService);
  }
}

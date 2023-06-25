package hello.core.singleton;

public class SingletonService {
  // static 영역에 객체를 한 개만 생성해둔다
  private static final SingletonService instance = new SingletonService();

  // 인스턴스에 접근하는 방법은 
  // public으로 정의된 static 메서드를 통해서만 가능하도록
  // 한정지어 놓는다
  public static SingletonService getInstance() {
    return instance;
  }

  // 의도가 아무리 좋다한들 실수로라도 new SingletonService()를 호출하면
  // 새 인스턴스가 생성되므로 private으로 이를 사전에 방지한다
  private SingletonService() {}

  public void logic() {
    System.out.println("싱글톤 객체가 호출되었습니다.");
  }
}
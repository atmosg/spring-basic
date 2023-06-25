package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
  private String url;

  public NetworkClient() {
    System.out.println("Constructor 호출");
  }

  public void init() {
    System.out.println("NetworkClient init");
    connect();
    call("DB 연결을 초기화 합니다");
  }

  public void close() {
    System.out.println("NetworkClient Destory");
    disconnect();
  }


  // @Override
  // public void afterPropertiesSet() throws Exception {
  //   System.out.println("NetworkClient afterPropertiesSet");
  //   connect();
  //   call("DB 연결을 초기화 합니다");
  // }

  // @Override
  // public void destroy() throws Exception {
  //   System.out.println("NetworkClient Destory");
  //   disconnect();
  // }

  public void setUrl(String url) {
    this.url = url;
  }

  public void connect() {
    System.out.println("DB Connect to : " + url);
  }

  public void call(String msg) {
    System.out.println("call: " + url + "\nmsg : " + msg);
  }

  public void disconnect() {
    System.out.println("DB Disconnected with : " + url);
  }
}
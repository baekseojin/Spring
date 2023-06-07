package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}

/*
controller service repository <-> DB

		    domain

controller : 웹 MVC의 컨트롤러 역할
service : 핵심 비지니스 로직 구현
repository : 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
domain : 비지니스 도메인 객체 / 예) 회원, 주문, 쿠폰 등등 주로 DB에 저장하고 관리됨

*/

package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() { // 스프링 빈은 무상태로 설계하자
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);

		//ThreadA: 10000원 주문
		statefulService1.order("userA", 10000);
		//ThreadB: 20000원 주문
		statefulService2.order("userB", 20000);

		//A 주문금액 조회
		int price = statefulService1.getPrice();
		Assertions.assertThat(price).isNotEqualTo(10000);
	}

	static class TestConfig {
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}

}

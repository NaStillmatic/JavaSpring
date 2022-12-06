package org.example.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 음식점에서 음식 주문하는 과정 구현
 * 요구사항
 * 1. 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
 *     └ 손님, 메뉴판, 동까스/냉면,만두, 요리사, 요리
 * 2. 객체들 간의 관계를 고민
 *     └ 손님  -- 메뉴판
 *     └ 손님  -- 요리사
 *     └ 요리사 -- 요리
 * 3. 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
 *     └ 손님 -- 손님 타입
 *     └ 돈까스/냉면/만두 -- 요리타입
 *     └ 메뉴판 -- 메뉴판 타입
 *     └ 메뉴 -- 메뉴 타입
 *     └ 요리 -- 요리 타입
 * 4. 협럭을 설계
 * 5. 객체들을 포괄하는 타입에 적절한 책임을 할당
 * 6. 구현하기
 */
public class CustomerTest {

    @DisplayName("메뉴이름에 해당하는 요리를 주문한다.")
    @Test
    void orderTest() {
        Customer customer = new Customer();

        Menu menu = new Menu(List.of(
                new MenuItem("돈까스", 5000),
                new MenuItem("냉면", 7000)
        ));
        Cooking cooking = new Cooking();

        assertThatCode(() -> customer.order("돈까스", menu, cooking))
                .doesNotThrowAnyException();
    }
}

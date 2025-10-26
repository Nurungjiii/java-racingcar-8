package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class CarTest {
    @DisplayName("자동차 생성 성공 - 이름 할당 및 위치 0 초기화")
    @Test
    void createCar_success() {
        String carName = "pobi";
        Car car = new Car(carName);

        // 이름이 정확히 할당되었는지 확인
        assertThat(car.getName()).isEqualTo(carName);
        // 초기 위치가 0인지 확인
        assertThat(car.getPosition()).isEqualTo(0);
    }

    private void assertThat() {
    }

    @DisplayName("자동차 이름 5자 초과 시 예외 발생")
    @Test
    void createCar_fail_nameLength() {
        String carName = "longname"; // 6자

        // 예외 발생을 검증합니다.
        assertThatThrownBy()
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class) // 예외 타입 확인
                .hasMessageContaining("[ERROR] 자동차 이름은 5자 이하만 가능합니다."); // 예외 메시지 확인
    }

    @DisplayName("자동차 이름이 null, 빈 문자열, 공백일 경우 예외 발생")
    @ParameterizedTest // 여러 값을 테스트하기 위해 ParameterizedTest 사용
    @ValueSource(strings = {"", " ", "   "}) // 빈 문자열, 공백
    void createCar_fail_nameEmpty(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 공백이 될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 null일 경우 예외 발생")
    void createCar_fail_nameNull() {
        assertThatThrownBy(() -> new Car(null)) // null 값 테스트
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 공백이 될 수 없습니다.");
    }

    // 전진 로직 테스트

    @DisplayName("무작위 값이 4 이상일 때 전진 가능(true)을 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9}) // 경계값(4)과 그 이상
    void isMoveable_true(int randomNumber) {
        Car car = new Car("test");
        // isMoveable은 무작위성이 없는 순수 함수이므로, 값을 직접 넣어 테스트합니다.
        assertThat(car.isMoveable(randomNumber)).isTrue();
    }

    @DisplayName("무작위 값이 3 이하일 때 전진 불가(false)를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3}) // 경계값(3)과 그 이하
    void isMoveable_false(int randomNumber) {
        Car car = new Car("test");
        assertThat(car.isMoveable(randomNumber)).isFalse();
    }
}

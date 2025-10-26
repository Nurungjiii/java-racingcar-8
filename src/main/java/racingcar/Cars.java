package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 여러 대의 자동차(Car) 객체를 관리하고 경주 로직을 수행하는 클래스입니다.
 */
public class Cars {
    private final List<Car> cars;

    /**
     * 쉼표로 구분된 자동차 이름 문자열을 받아 Car 객체 리스트로 초기화합니다.
     * 초기화 과정에서 각 Car 객체의 유효성 검사를 수행합니다.
     *
     * @param carNames 쉼표로 구분된 자동차 이름 문자열 (예: "pobi,woni,jun")
     */
    public Cars(String carNames) {
        this.cars = parseCarNames(carNames);
    }

    // 외부에서 Cars 객체 리스트에 직접 접근하는 것을 제한하기 위해 Getter를 제공합니다.
    public List<Car> getCars() {
        return cars;
    }

    /**
     * 입력된 문자열을 파싱하여 Car 객체의 리스트를 생성합니다.
     *
     * @param carNames 쉼표로 구분된 자동차 이름 문자열
     * @return 생성된 Car 객체의 리스트
     */
    private List<Car> parseCarNames(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름 목록은 비어있을 수 없습니다.");
        }

        // 쉼표로 분리하여 각 이름으로 Car 객체를 생성합니다.
        return Arrays.stream(carNames.split(","))
                .map(String::trim) // 이름 앞뒤 공백 제거
                .map(Car::new)     // 각 이름으로 Car 객체 생성 (이때 Car 생성자에서 이름 유효성 검사 수행)
                .toList();         // Java 16+
    }
    // 경주 실행 및 우승자 판별 로직 추가
    // 모든 자동차를 한 번 씩 이동 시킴니다
    public void moveCars() {
        for (Car car : cars) {
            car.tryMove();
        }
    }
    // 현재 경주에서 가장 많이 전진한 위치(최대값)을 반환합니다
    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
    // 우승자 목록을 반환함 (최대위치와 동일한 위치에 있는 자동차)
    // @return 우승한 자동차 이름 목록
    public List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

}

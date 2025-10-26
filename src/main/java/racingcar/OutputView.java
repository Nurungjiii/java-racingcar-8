package racingcar;

import java.util.List;

// 경주 진행 상황과 최종 결과를 출력하는 역할을 수행합니다.

public class OutputView {

    public void printRaceStart() {
        System.out.println("\n실행 결과");
    }

    // 현재 턴의 모든 자동차 위치를 출력합니다.
    // @param cars 현재 경주 중인 Cars 객체

    public void printRaceState(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + repeatChar('-', car.getPosition()));
        }
        System.out.println(); // 턴 종료 후 줄 바꿈
    }

    // 자동차의 위치만큼 '-' 문자를 반복하여 반환합니다.
    private String repeatChar(char c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    // 최종 우승자 목록을 출력합니다.
    // @param winners 우승자 이름 목록
    public void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }

    // 예외 메시지를 출력합니다.
    // @param message 예외 메시지

    public void printError(String message) {
        System.out.println(message);
    }
}

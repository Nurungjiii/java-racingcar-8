package racingcar;

import camp.nextstep.edu.missionutils.Console;

// 사용자로부터 입력을 받는 역할을 수행합니다.
public class InputView {
    // 상수: 시도 횟수의 최소 값 (1회 이상)
    private static final int MIN_TRY_COUNT = 1;

    // 경주할 자동차 이름을 입력 받습니다.
    // @return 쉼표(,)로 구분된 자동차 이름 문자열
    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // Console API를 사용하여 사용자 입력을 받습니다.
        return Console.readLine();
    }

    // 시도할 횟수를 입력 받고 유효성을 검사합니다.
    // @return 시도할 횟수 (int)

    public int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        try {
            // 입력된 문자열을 정수형으로 변환합니다.
            int tryCount = Integer.parseInt(input);
            // 1회 이상인지 유효성 검사
            validateTryCount(tryCount);
            return tryCount;
        } catch (NumberFormatException e) {
            // 정수형 변환에 실패하면 예외 발생
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }

    // 시도 횟수 유효성 검사 메서드
    private void validateTryCount(int tryCount) {
        // 요구사항: 시도 횟수는 1회 이상이어야 합니다.
        if (tryCount < MIN_TRY_COUNT) {
            // 잘못된 값 입력 시 IllegalArgumentException 발생
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 " + MIN_TRY_COUNT + "회 이상이어야 합니다.");
        }
    }
}

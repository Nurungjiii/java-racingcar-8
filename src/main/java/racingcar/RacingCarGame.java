package racingcar;

// 게임의 전체 흐름(입력, 실행, 출력)을 제어하는 클래스입니다.
public class RacingCarGame {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    // 경주 게임을 시작하고 실행합니다.

    public void start() {
        // 1. 자동차 이름 입력 및 Cars 객체 생성 (예외 발생 시 던져짐)
        String carNamesInput = inputView.inputCarNames();
        Cars cars = new Cars(carNamesInput);

        // 2. 시도 횟수 입력 (예외 발생 시 던져짐)
        int tryCount = inputView.inputTryCount();

        // 3. 경주 실행 및 결과 출력
        runRace(cars, tryCount);

        // 4. 최종 우승자 출력
        outputView.printWinners(cars.getWinners());
    }

    // 자동차 이름 입력 및 Cars 객체 초기화 로직 (유효성 검사 시 재시도)
    private Cars initializeCars() {
        while (true) {
            try {
                String carNamesInput = inputView.inputCarNames();
                return new Cars(carNamesInput);
            } catch (IllegalArgumentException e) {
                // Cars 생성 중 예외 발생 시 에러 메시지 출력 후 재입력
                outputView.printError(e.getMessage());
            }
        }
    }

    // 시도 횟수 입력 로직 (유효성 검사 시 재시도)
    private int getTryCount() {
        while (true) {
            try {
                return inputView.inputTryCount();
            } catch (IllegalArgumentException e) {
                // 시도 횟수 입력 중 예외 발생 시 에러 메시지 출력 후 재입력
                outputView.printError(e.getMessage());
            }
        }
    }

    // 경주를 시도 횟수만큼 실행하고 매 턴 결과를 출력하는 로직
    private void runRace(Cars cars, int tryCount) {
        outputView.printRaceStart();

        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            outputView.printRaceState(cars);
        }
    }
}

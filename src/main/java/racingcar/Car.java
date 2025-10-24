package racingcar;

public class Car {
    // 이름,위치,속성 정의
    // 이름은 한 번 정해지면 바뀌지 않음으로 final로 선언
    private final String name;
    private int position;

    public Car(String name) {
        // 전달 받은 이름으로 필드 초기화
        this.name=name;
        // 모든 자동차의 시작 위치는 0
        this.position=0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

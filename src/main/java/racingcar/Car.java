package racingcar;

public class Car {
    // 이름 길이 제한을 상수 정의
    private static final int MAX_NAME_LENGTH = 5;
    // 이름,위치,속성 정의
    // 이름은 한 번 정해지면 바뀌지 않음으로 final로 선언
    private final String name;
    private int position;

    public Car(String name) {
        // 생성자에서 이름 할당 전에 유효성 검사 수행
        validateName(name);
        // 전달 받은 이름으로 필드 초기화
        this.name=name;
        // 모든 자동차의 시작 위치는 0
        this.position=0;
    }

    // 이름 유효성 검사 메서드 구현
    private void validateName(String name) {
        // 이름이 null이거나, 앞뒤 공백을 제거했을 때 비어있는지 검사
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 공백");
        }
        // 이름의 길이가 5자를 초과하는지 검사
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 길이5초과");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

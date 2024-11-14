# kotlin-racingcar

## 2단계 - 문자열 사칙 연산 계산기 구현

### 기능 요구 사항

- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 기능 구현 목록

- 숫자(Number)
    - [x] 소수 첫째 자리까지만 표현한다. (소수 둘째 자리에서 반올림한다.)
    - [x] 표현 가능한 범위는 -1억 ~ 1억으로 고정한다.
    - [x] 다른 숫자와 사칙연산을 할 수 있다.
        - [x] 덧셈
        - [x] 뺄셈
        - [x] 곱셈
        - [x] 나눗셈
            - [x] 0으로 나눌 수 없다.
            - [x] 나눗셈의 결과는 소수 둘째 자리에서 반올림한다.


- 사칙 연산자(Operator)
    - [x] 사칙 연산자는 덧셈, 뺄셈, 곱셈, 나눗셈이며, 각각 "+", "-", "*", "/"로 표현된다.


- 계산기(Calculator)
    - [x] 계산할 수식을 하나의 문자열로 받을 수 있다.
        - [x] 입력값은 빈 공백 문자가 될 수 없다.
        - [x] 입력값은 숫자, 사칙 연산자, 공백으로만 구성된다.
        - [x] 숫자 연산자 숫자 순으로 입력되어야 한다. (처음과 마지막은 항상 숫자)
    - [x] 입력받은 수식을 숫자와 연산자로 분리한다.
    - [x] 분리된 숫자와 연산자를 통해 계산을 수행할 수 있다.

## 3단계 - 자동차 경주

### 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 기능 구현 목록

- 자동차 (Car)
    - [x] 전진 또는 멈출 수 있다.
        - [x] 위치 (CarPosition)를 가진다.
        - [x] 전진하는 경우 위치 (CarPosition)의 값이 1 증가한다.


- 숫자 생성기 (NumberGenerator)
    - [x] 랜덤한 값을 생성할 수 있다.
        - [x] 생성된 값은 0 이상 9 이하이다.
    - [x] 원하는 값을 생성할 수 있다.


- 자동차들 (Cars)
    - [x] 여러 대의 자동차를 가질 수 있다.
    - [x] 각 자동차의 전진 여부를 결정할 수 있다.
        - [x] 전진 여부는 숫자 생성기 (NumberGenerator) 를 통해 생성된 값이 4 이상일 경우이다.
    - [x] 각 자동차의 위치를 외부에 전달할 수 있다.


- 자동차 경주 게임 (RacingGame)
    - [x] 자동차들 (Cars)과 시도 횟수 (Round)를 가진다.
    - [x] 시도 횟수 (Round) 만큼 각 자동차의 전진 / 멈춤 행위를 진행시킬 수 있다.

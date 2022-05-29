# kotlin-lotto

## 문자열 덧셈 계산기
### 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 프로그래밍 요구 사항
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.

### 상세 구현 사항
[x] 계산할 문자열을 입력받는다.
  [x] 빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다.
  [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
  [x] 구분자는 기본적으로 쉼표(,)와 콜론(:)을 사용할 수 있다.
  [x] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다.
  [x] 마침표(.)는 커스텀 구분자로 사용할 수 없다.
  [x] 계산할 수는 자연수만 가능하다. 아닐경우 RuntimeException이 발생한다.
[x] 구분자를 기준으로 분리한 숫자의 합을 반환한다.
[x] 결과를 출력한다.

## 로또(자동)
### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 실행 결과
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
...
[3, 5, 11, 16, 32, 38]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)

### 프로그래밍 요구 사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 상세 구현 사항
[x] 구입금액 입력받기
  [x] 구입금액이 비어있는 경우 IllegalArgumentException 발생
  [x] 구입금액이 정수가 아닌 경우 IllegalArgumentException 발생
  [x] 구입금액이 0보다 작으면 IllegalArgumentException 발생
[x] 금액에 따른 로또 개수 구하기
[x] 당첨 번호 입력받기
[x] 개수에 맞추어 로또 생성하기
[x] 사용자의 로또와 당첨 번호 비교하기
[x] 당첨 통계 구현 하기
[x] 수익률 구현하기 (소수점 아래 두자리까지 출력)


## 로또(2등)
### 기능 요구사항
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

### 실행 결과
[... 생략 ...]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)

### 프로그래밍 요구 사항
- Enum 클래스를 적용해 프로그래밍을 구현한다.
- 일급 컬렉션을 쓴다.
- 일급 컬렉션을 사용하는 이유

### 상세 구현 사항
[] 보너스 볼을 입력받는다.
  [x] empty이거나 숫자가 아니면 IllegalArgumentException 발생
  [x] 1 ~ 45 사이의 번호가 아니면 IllegalArgumentException 발생
  [] 당첨 번호와 중복되면 IllegalArgumentException 발생
[] 2등을 추가한다.
  [] 5개가 일치하고, 보너스 볼이 일치하는 경우 2등이다.
  [] 당첨통계 출력시에도 추가한다.

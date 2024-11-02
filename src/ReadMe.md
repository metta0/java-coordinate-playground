# 2️⃣ 좌표계산기

## A. 기능 요구사항
>### 1.좌표  
[x] 사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.  
[x] 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.  
[x] X, Y좌표 모두 최대 24까지만 입력할 수 있다.  
[x] 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다.  

>### 2.출력  
[x] 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.  

>### 3.도형(직선)  
[x] 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.  
[x] 직선인 경우는 두 점 사이 거리를 계산해서 출력한다.  

>### 3-2.도형(사각형)  
[x] 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.  
[x] 좌표값을 네 개 입력한 경우, 네 점을 연결하는 사각형으로 가정한다.  
[x] 네 점이 뒤틀어진 사다리꼴이나 마름모는 제외하고 직사각형만 허용하도록 검사한다.  
[x] 사각형인 경우 사각형의 넓이를 계산해서 출력한다.  

>### 3-3.도형(삼각형)  
[x] 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.  
[x] 좌표값을 세 개 입력한 경우, 세 점을 연결하는 삼각형으로 가정한다.  
[x] 삼각형인 경우 삼각형의 넓이를 계산해서 출력한다.  

## B. 프로그래밍 요구사항
+ **상속과 인터페이스를 적용해 중복 코드를 제거한다.**  
+ 자바 코드 컨벤션을 지키면서 프로그래밍한다.  
+ 기본적으로 Google Java Style Guide을 원칙으로 한다.  
+ 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.  
+ indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.  
+ 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.  
+ 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.  
+ 3항 연산자를 쓰지 않는다.  
+ else 예약어를 쓰지 않는다.  
+ else 예약어를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.  
+ 힌트: if문에서 값을 반환하는 방식으로 구현하면 else 예약어를 사용하지 않아도 된다.  
+ **모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외**  
+ 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.  
+ UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.  
+ 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.  
+ **함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.**  
+ 모든 원시 값과 문자열을 포장한다  
+ 줄여 쓰지 않는다(축약 금지).  
+ 일급 컬렉션을 쓴다.  

## C. 회고
최종적으로 선생님 코드를 참고삼아 다시 짰다. 처음부터 다시 짠다는 것이 매우 귀찮았지만, 내가 모르는 부분이 어딘지 알게 되었다. 테스트 코드 작성 속도도 올랐고, 전체적인 복습이 되어 자신감도 붙었다. 내가 부족했던 부분에 대해 회고한다.

### 1. 리팩토링
#### (1). **생성자에 예외처리 부분을 묶어서 한 번에 깔끔하게 하자.**
```
Rectangle(List<Point> points){
        super(points);

        if(isPointCountInvalid(points)) throw new IllegalArgumentException(ERROR_NUMBER_OF_POINTS);
        if(isPointRectangle(points)) throw new IllegalArgumentException(RECTANGLE_ERROR);
    }
```
->
```
Rectangle(List<Point> points){
        super(points);
        checkValidation(points);
    }

    @Override
    public void checkValidation(List<Point> points){
        if(isPointCountInvalid(points)) throw new IllegalArgumentException(ERROR_NUMBER_OF_POINTS);
        if(isPointRectangle(points)) throw new IllegalArgumentException(RECTANGLE_ERROR);
    }
```
checkValidation 메소드로 예외처리부분을 묶는다. 이유는 SRP준수 및 가독성 향상.

#### (2) **상수 값, 에러문구 모두 문자열로 포장**
```
    private static final int NUMBER_OF_POINTS = 4;
    private static final int NUMBER_OF_UNIQUE_POINTS = 2;
    private static final String RESULT_PREFIX = "사각형의 넓이는 ";
    private static final String ERROR_NUMBER_OF_POINTS = "점의 갯수가 " + NUMBER_OF_POINTS + "개 여야 합니다.";
    private static final String RECTANGLE_ERROR = "직사각형이어야 합니다.";
```
재사용성, 가독성을 높인다.

#### (3) **일급 컬렉션은 필수가 아니다.**  
: '일급 컬렉션의 단점'은  
- 방어적 복사로 인한 메모리 사용 증가 - 성능이슈
- 코드 복잡성 증가  

처음에 List<'Point'> 를 위한 일급 컬렉션을 만들었지만, 계속 조작이 필요할 때마다 return값으로 List를 받았기 때문에 복잡성이 증가했다. 상황을 고려해서 사용하자.

#### (4) **Model과 View 사이 종속성 제거는 필수가 아니다.**  
:물론, 종속성이 덜할 수록 좋다. 하지만 코드의 복잡성 증가를 고려하여 어느정도 종속성을 허용할 것인지 판단이 필요하다.  
```
public static Figure inputCoordinates(String input) {
        try {
            input = input.replace(" ", "");
            checkAccuracyOfPoints(input);
            List<Point> points = generatePoints(input);
            return FigureFactory.create(points);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoordinates();
        }
```
위의 예시를 보면, InputView클래스에서 Point와 FigureFactory인 모델을 가져다 사용했다. 그럼으로서 종속성이 발생하고, SRP 위배와 OCP를 위배하게 된다. 하지만, 그만큼 코드가 간결해져서 InputView의 코드 몇 줄만으로 Point생성과 도형생성까지 할 수 있다.

```코드의 복잡성 증가 <-> 종속성, 재사용성```  
이 두가지를 고려하여 판단하자.

### 2. 인터페이스 클래스
#### (1) 인터페이스에는 인스턴스 변수를 만들지 못한다.  
: 당연한 얘기지만, 몰랐었다.  
```
인터페이스는 클래스가 '무엇'을 할지 규정하지, '어떻게' 구현할지를 규정하지 않는다.
-> '상태'가 아니라 '행동'을 규정하고, 그것이 더 유연하기 때문이다.
```

#### (2) 인터페이스를 상속받은 후 Sub 클래스에서 Visibility는 reduce되지 못한다. 고로, 모두 public이다.
```
- 계약 강제 : 인터페이스를 아는 모든 clients들이 자유롭게 이용하도록 계약을 강제한다.
- 다형성 지원: 인터페이스를 implements할 클래스들의 object를 다형성으로 자유롭게 이용하려면, 당연히 public 이어야 한다.
ex. new Figure(points).checkValidation();
```

### 3. super()은 생성자의 가장 처음에 와야한다.  
:
```
Rectangle(List<Point> points) {
        super(points);
        checkRectangleWith(points);
    }
```
super()이 가장 먼저 와야 하는 이유는, 만약 super()가 checkRectangleWith() 다음에 오고, checkRectangleWith()에서 부모클래스의 메소드를 사용한다면 에러가 발생하기 때문이다.  

부모클래스가 super()로써 먼저 인스턴스화 되지 않는다면, 인스턴스화 되지 않은 부모클래스의 부분을 먼저 사용하여 문제가 발생할 수 있다.

### 4. 팩토리 패턴 사용 + MAP COLLECTION
:
장점  
+ if조건문 여러개를 한 번에 처리할 수 있다.
+ create시 예외처리 등 한 곳에서 관리가능하다.
+ 한 곳에서 create하니, 테스트시에도 create만 사용하면 돼서 객체생성이 매우 용이하다.

단점
+ 코드 복잡성 증가.

### 5. Abstract 클래스에서 List<'Point'> points 를 상속받기 때문에, 하위 클래스에서 getPoints()가 필요했다.  
처음에 
```
public interface Figure {
    List<Point> getPoints();
    //...
    }

public abstract class AbstractFigure implements Figure {
    @Override
    public List<Point> getPoints() {
        return points;
    }
}
```
getPoints()가 왜 필요한지 몰랐다. 하지만, 도형클래스들이 AbstractFigure에서 points를 상속받으니 points를 접근할 때 getPoints()가 필요하다는 것을 알게 되었다.
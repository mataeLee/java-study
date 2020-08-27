# Java-study
제약 조건이 걸린 미션 솔루션(java 언어 기반)을 통해 효과적인 코드나 품질을 생각한 코드를 작성하는 연습하기.
## 미션
- [Racing-car](https://github.com/mataeLee/java-study/tree/master/racing-car)
## 제약 조건
- 함수가 단일 동작을 할 수 있도록 구현한다.
- indent(인덴트, 들여쓰기) depth를 최대한 줄인다.
- else 예약어를 되도록 쓰지 않는다.
- switch/case를 되도록 쓰지 않는다.
- 불필요한 공백 라인을 만들지 않는다.
    * 공백 라인을 띄우는 것도 코드상에 문맥이 달라지는 부분에 의도를 가지고 띄운다.
- 값을 하드코딩 하지 않는다.
    * 문자열, 숫자 등의 리터럴 값을 하드코딩 하지 않는다.
    * 가능하면 상수(static final)를 만들고 이름을 부여해 이 변수의 역할이 무엇인지 의도를 드러낸다.
- Java api와 collection을 적극 활용한다.
- Git commit 메세지를 의미있게 작성한다.
- 객체에 메시지를 보낸다.
    * 상태 데이터를 가지는 객체에서 데이터를 꺼내려(get)하지 말고 객체에 메시지를 보낸다.
    
## 기본적으로 MVC 패턴을 적용
물론 큰 구조안에서 될 수 있으면 다른 디자인 패턴을 적용하도록 한다.

### Model
- 데이터를 담을 수 있는 컴포넌트다.
- 가공 및 변환 가능한 데이터를 대상으로 만들어야한다.
- 재사용 가능 해야하므로 다른 인터페이스에서도 변하지 말아야 한다.
- View, Controller에 의존하는 일이 없어야한다.
- 변경이 일어나면 변경 통지에 대한 처리만 한다.

### View
- 데이터의 객체 입력 및 출력을 보여주는 컴포넌트다.
- 사용자 인터페이스 요소를 나타낸다.
- Model이 가지고 있는 정보는 따로 저장하지 않는다.
- Model이나 Controller에 의존하는 일이 없어야 한다.
- 변경이 일어나면 변경 통지에 대한 처리만 한다.

### Controller
- 사용자 이벤트를 처리해 주는 컴포넌트다.
- 애플리케이션의 메인 로직을 담당하며, 데이터와 사용자 인터페이스 요소의 중간다리 역할이다.
- Model, View에 대해서 알고 있어야 한다. (둘이 서로 의존성이 없기 떄문에 컨트롤러가 중간에서 동작시킨다.)
- Model, View의 변경을 모니터링 해야한다.
- Model, View의 변경 통지를 받아 처리하고, 처리된 결과를 담당 컴포넌트에게 알린다.
    
## Test
- 코드가 오류나 예외 없이 작동하는지 확인하기 위해 작성한다.
- 프로덕션 코드 작성방식을 생각하는데 도움을 준다.
- 프로덕션 코드 구현에 적절한 지표가 된다.
- 애플리케이션 유닛(메소드)을 작게 만들수록 효과적으로 테스트 할 수 있다.

### 단위테스트를 하는데 있어서 유의할 점
- 최대한 잘게 나눠서 테스트를 해야 한다.
- 테스트 코드들은 서로 분리가 되어야 한다.
- 테스트 하기 쉬운 코드랑 어려운 코드를 잘 나누자
    * 예) 테스트 하기 쉬운 코드 -> 명확한 데이터들이나 로직으로 구성된 코드
    * 예) 테스트 하기 어려운 코드 -> 변화가 있는 데이터나 로직으로 구성된 코드

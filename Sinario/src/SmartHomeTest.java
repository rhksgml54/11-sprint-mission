public class SmartHomeTest {
    public static void main(String[] args) {
        /* [요구사항] 서로 다른 종류의 가전제품(TV, 라디오)을 하나의 시스템에서 통합 관리하라.
         * [원리] '다형성(Polymorphism)' - 업캐스팅(Upcasting)
         * - 부모 타입인 HomeAppliance 배열을 선언하면, 그 자식들(SmartTV, OldRadio)을 모두 담을 수 있습니다.
         * - 메모리: 힙(Heap) 영역에 각각 SmartTV, OldRadio 객체가 생성되지만,
         * 배열(myAppliance)은 이들을 'HomeAppliance(가전제품)'라고만 인식하고 가리킵니다.
         */
        HomeAppliance[] myAppliance = {
                new SmartTV("Samsung"),  // 0번지: 삼성 TV 생성
                new OldRadio("GoldStar"),// 1번지: 금성 라디오 생성
                new SmartTV("LG")        // 2번지: LG TV 생성
        };

        System.out.println("== 스마트 홈 시스템 가동 ==");

        /* [요구사항] 등록된 모든 기기를 순서대로 제어하되, 스마트 기능은 있는 놈만 실행하라.
         * [구현] 향상된 for문 (for-each) 사용
         */
        for (HomeAppliance app : myAppliance) {

            /* [공통 기능 실행]
             * app 변수는 HomeAppliance 타입이지만, 실제로는 자식 객체(TV or Radio)가 들어있습니다.
             * 자바의 '동적 바인딩(Dynamic Binding)' 덕분에 부모의 turnOn이 아니라,
             * 실제 객체(자식)가 오버라이딩한 turnOn()이 실행됩니다.
             */
            app.turnOn();

            /* [인터페이스 확인 - 감별사]
             * [요구사항] 현재 꺼낸 기기가 와이파이 기능이 있는지 확인하라.
             * [원리] instanceof 연산자
             * - "너 혹시 SmartWifi 자격증(인터페이스) 가지고 있니?"라고 물어보는 과정입니다.
             * - OldRadio는 이 인터페이스가 없으므로 false가 되어 이 블록을 건너뜁니다.
             */
            if (app instanceof SmartWifi) {

                /* [다운캐스팅 - Downcasting]
                 * [원리] 부모 타입(HomeAppliance)인 app 변수로는 connect() 버튼을 누를 수 없습니다.
                 * (부모 설계도에는 connect 기능이 없으니까요!)
                 * 그래서 "너 사실 SmartWifi 맞잖아!" 하고 강제로 형변환을 해서
                 * 숨겨져 있던 connect() 기능을 실행하는 것입니다.
                 */
                SmartWifi smartDevice = (SmartWifi) app;
                smartDevice.connect();
            }
            System.out.println("----------------------");
        }
    }
}

/* [추상 클래스 - 설계도]
 * [요구사항] '가전제품'이라는 개념만 정의하고, 실제 제품은 만들지 못하게 하라.
 * -> abstract class: new HomeAppliance(); 가 불가능해집니다.
 */
abstract class HomeAppliance {

    /* [불변성 - Immutability]
     * [요구사항] 한번 정해진 브랜드는 폐기할 때까지 바꿀 수 없다.
     * -> final: 초기화 이후 값 변경 금지.
     */
    final String brand;

    /* [생성자]
     * [요구사항] 제품 생성 시 브랜드를 필수로 입력받아라.
     * -> 자식 객체가 생성될 때 super(brand)를 통해 호출되며, 여기서 최종적으로 값이 세팅됩니다.
     */
    HomeAppliance(String brand) {
        this.brand = brand;
    }

    /* [추상 메서드 - 강제성]
     * [요구사항] 모든 가전은 켜져야 하지만, 켜지는 방식은 각자 알아서 해라.
     * -> abstract void: 자식 클래스에게 "이거 안 만들면 에러 낼 거야"라고 협박(강제)하는 역할입니다.
     */
    abstract void turnOn();
}

/* [인터페이스 - 기능 명세서]
 * [요구사항] 스마트 기기라면 반드시 '연결' 기능이 있어야 한다.
 * -> 상속(족보)과는 별개로 '기능'을 장착(implements)하는 개념입니다.
 */
interface SmartWifi {
    void connect(); // 구현체들이 반드시 만들어야 할 숙제
}

/* [클래스 1 - 다기능 자식]
 * [구조] 가전제품(상속)이면서 + 와이파이 기능(구현)을 동시에 가짐.
 */
class SmartTV extends HomeAppliance implements SmartWifi {

    /* [생성자 연결]
     * [원리] 부모(HomeAppliance)의 brand 변수는 private하거나 final이라 자식이 직접 못 건드립니다.
     * -> super(brand): "부모님, 이 브랜드 이름 좀 대신 저장해주세요"라고 부모 생성자를 호출합니다.
     */
    SmartTV(String brand) {
        super(brand);
    }

    /* [오버라이딩]
     * 부모가 시킨 숙제(turnOn)를 실제 TV에 맞게 구현함.
     */
    @Override
    void turnOn() {
        // 부모의 brand 변수는 상속받았으므로 내 것처럼 사용 가능
        System.out.println("[" + brand + " TV] 전원을 켭니다");
    }

    /* [인터페이스 구현]
     * SmartWifi 인터페이스가 시킨 숙제(connect)를 구현함.
     * 이걸 구현했기 때문에 main에서 instanceof 검사를 통과할 수 있음.
     */
    @Override
    public void connect() {
        System.out.println(" -> 와이파이에 연결합니다.");
    }
}

/* [클래스 2 - 단순 자식]
 * [구조] 가전제품 상속만 받음. 와이파이 기능 없음.
 */
class OldRadio extends HomeAppliance {

    OldRadio(String brand) {
        super(brand); // 마찬가지로 브랜드 저장을 부모에게 위임
    }

    @Override
    void turnOn() {
        System.out.println("[" + brand + " 라디오] 지지직 소리가 납니다.");
    }
    // SmartWifi를 구현하지 않았으므로 connect() 메서드가 없습니다.
}
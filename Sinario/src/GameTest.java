public class GameTest {
    public static void main(String[] args) {
        // [순서 1] 클래스 이름으로 직접 접근 (new 안 함)
        // Static 메서드는 클래스 로드 시점에 이미 완성되어 있어 바로 부를 수 있습니다.
        Adventurer.printTotalCount();

        // [순서 2] 인스턴스화 (객체 탄생)
        // a1, a2는 각각 메모리의 다른 주소에 저장됩니다. (서로 다른 인간)
        Adventurer a1 = new Adventurer("전사"); // totalCount가 1이 됨
        Adventurer a2 = new Adventurer("마법사"); // totalCount가 2가 됨

        // [순서 3] 다형성/오버로딩 확인
        a1.attack(); // 파라미터 없는 버전 호출

        // [순서 4] 가변인자 확인
        // "골드", "물약"... 이 값들이 자동으로 String[] 배열에 담겨 전달됩니다.
        a1.getLoot("골드", "물약", "전설의 검");

        // [순서 5] 결과 확인
        // a1과 a2가 비록 다른 객체지만, static 변수인 totalCount는 하나를 공유했음을 증명합니다.
        Adventurer.printTotalCount();
    }
}



class Adventurer {
    /* * [요구사항] 모험가 개개인의 이름을 저장하라.
     * [구현] String(문자열) 타입으로 name 변수를 선언하여 객체별 고유 이름을 저장한다.
     */
    String name;

    /* * [요구사항] 모험가의 성장 수치를 저장하라.
     * [구현] int(정수) 타입으로 level 변수를 선언하여 숫자로 레벨을 관리한다.
     */
    int level;

    /* * [요구사항] 모든 객체가 공유하는 카운트를 저장하라.
     * [구현] static 키워드를 사용해 int 타입 totalCount 변수를 선언한다.
     * 이 변수는 Heap이 아닌 Static 메모리에 단 하나만 존재하게 된다.
     */
    static int totalCount = 0;

    /* * [요구사항] 객체 생성 시 이름을 전달받아 즉시 저장하라.
     * [구현] 생성자 파라미터로 받은 String name을 'this.name'에 대입(Assignment)하여 저장한다.
     * 이때 level은 1로, totalCount는 기존 값에 +1을 더해 업데이트한다.
     */
    Adventurer(String name) {
        this.name = name;
        this.level = 1;
        totalCount++;
        System.out.println(name + " 모험가가 생성되었습니다!");
    }

    /* * [요구사항] 무기 정보 없이 공격하는 기능을 구현하라.
     * [구현] 매개변수가 없는 attack() 메서드를 정의하여 기본 동작을 실행한다.
     */
    void attack() {
        System.out.println("맨손으로 공격합니다!");
    }

    /* * [요구사항] 특정 무기 이름을 받아서 공격하는 기능을 구현하라.
     * [구현] String weapon이라는 문자열 변수를 입력값으로 받아 출력문에 포함한다.
     */
    void attack(String weapon) {
        System.out.println(weapon + "로 공격합니다!");
    }

    /* * [요구사항] 여러 개의 전리품 이름을 한꺼번에 처리하라.
     * [구현] 'String... items' (가변인자)를 사용하여 들어온 문자열들을
     * String[] 배열 형태로 묶어서 저장하고, for문을 통해 하나씩 꺼낸다.
     */
    void getLoot(String... items) {
        System.out.println(name + "이(가) " + items.length + "개의 아이템을 획득!");
        for(String item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /* * [요구사항] 현재 서버 상태(총원)를 외부로 출력하라.
     * [구현] static 메서드 내에서 공유 변수인 totalCount 값을 읽어와 콘솔에 출력한다.
     */
    static void printTotalCount() {
        System.out.println("현재 서버의 총 모험가 수: " + totalCount + "명");
    }
}
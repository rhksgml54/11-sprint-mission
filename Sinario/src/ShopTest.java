public class ShopTest {
public static void main(String[] args) {
    // Java Bean & 캡슐화 테스트
    Member member = new Member("김코딩", 20, 1000);


    // 잘못된 데이터 입력 시도
    member.setAge(-5);
    member.setPoint(-500);

    System.out.println("회원 이름: " + member.getName());
    System.out.println("회원 나이: " + member.getAge());
    System.out.println("회원 포인트: " + member.getPoint());

    // 불변 객체 테스트
    Receipt receipt = new Receipt("ORD-20260210", 50000);

    //영수증 발행
    System.out.println("== 영수증 발행 ==");
    System.out.println("주문번호: " + receipt.getOrderId());
    System.out.println("결재금액: " + receipt.getAmount());


}
}

// Java Bean 규약을 따르는 회원 클래스
class Member {
    // 접근 제어자 private -> 외부에서 필드 직접 접근 차단(데이터 보호)
    private String name;
    private int age;
    private int point;

    // 기본 생성자 필수 (Java Bean 규약)
    public Member() {}

    public Member(String name, int age, int point){
        setName(name);
        setAge(age);
        setPoint(point);
    }

    // Setter의 데이터 유효성 검증
    public void setAge(int age) {
        if(age < 0) {
            System.out.println("에러: 나이는 음수가 될 수 없습니다!");
        } else {
            this.age = age;
        }
    }
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("이름은 비어있을 수 없습니다.");
        } else {
            this.name = name;
        }
    }
    public void setPoint(int point) {
            if(point < 0) {
                System.out.println("사용가능한 포인트가 없습니다");
            }else{
                this.point = point;
            }

        }
    public String getName() { return name; }

    public int getAge() { return age; }

    public int getPoint() { return point; }
}

class Receipt {
    // final 키워드 -> 초기화 후 값 변경 불가
    private final String orderId;
    private final  int amount;

    // 생성자를 통해서만 값 주입
    public Receipt(String orderId, int amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    // Setter 없음 -> 값 변경 경로 차단
    public String getOrderId() {
        return orderId;
    }
    public int getAmount() {
        return amount;
    }

}
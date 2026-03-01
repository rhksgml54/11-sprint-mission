public class BankSystemTest {
    public static void main(String[] args) {
        // 가정: DB에서 "W"(출금)라는 코드가 넘어옴
        String dbCode = "W";
        int amount = 50000;

        try{
            System.out.println("== 은행 시스템 가동 ==");
            // 안전한 조회 (DB코드 -> Enum)
            TransactionType type = TransactionType.fromCode(dbCode);
            System.out.println("거래 종류: " + type.getDesc());

            // Enum 다형성 활용 (if 문 없이 바로 계산)
            int fee = type.calculateFee(amount);
            System.out.println("수수료: " + fee + "원");

            // switch문 활용
            switch (type) {
                case WITHDRAWAL:
                    System.out.println("-> 출금 시 보이스피싱 주의!");
                    break;
                case TRANSFER:
                    System.out.println("-> 이체 한도를 확인하세요.");
                    break;
                case DEPOSIT:
                    System.out.println("-> 감사합니다.");
                    break;

        }
        }
        catch(IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}

enum TransactionType {
    // 1. 상수 정의 (데이터 + 행동)
    DEPOSIT("D", "입금") {
        @Override
        public int calculateFee(int amount) {
            return 0;
        }
    },
    WITHDRAWAL("W", "출금") { // 오타 수정: WIRHDRAWAL -> WITHDRAWAL
        @Override
        public int calculateFee(int amount) {
            return 1000;
        }
    },
    TRANSFER("T", "이체") {
        @Override
        public int calculateFee(int amount) {
            return (int) (amount * 0.1);
        }
    }; // 여기가 상수 선언의 끝입니다.

    // 2. 필드 및 생성자
    private final String code;
    private final String desc;

    TransactionType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    // 3. 추상 메서드 선언
    public abstract int calculateFee(int amount);

    // 4. 역매핑 메서드 (수정됨)
    public static TransactionType fromCode(String code) {
        // null 체크
        if (code == null) { // dbDate -> code 로 수정
            throw new IllegalArgumentException("코드가 null 입니다.");
        }

        // 반복문으로 찾기
        for (TransactionType type : values()) {
            if (type.code.equals(code)) { // dbData -> code 로 수정
                return type;
            }
        }

        // 못 찾았을 때
        throw new IllegalArgumentException("존재하지 않는 코드입니다: " + code);
    }
}


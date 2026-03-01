import java.util.HashSet;
import java.util.Set;

// 이메일을 유일 식별자로 사용하는 불변 객체 정의
record User(String email) {
    public  User {
        if (age < 0) {
            throw new IllegalArgumentException(("나이는 음수가 될 수 없습니다."));
        }
    }
}

public class RegistrationSystem {
    static void main(String[] args) {
        // HashSet 사용 -> 중복 이메일 차단
        Set<User> userList = new HashSet<>();

        // 가입시도 3번
        userList.add(new User("java@codeit.com"));
        userList.add(new User("spring@codeit.com"));
        userList.add(new User("java@codeit.com"));

        // 총 가입자 수 출력
        System.out.println("=== 가입 완료: ===");
        System.out.println("총 가입자수: " + userList.size());

        // contains는 eqauls 기반으로 비교
        boolean isSpringMember = userList.contains(new User("spring@codeit.com"));
        System.out.println("스프링 유저 가입 여부: " +isSpringMember);

        // remove 처리
        userList.remove(new User("java@codeit.com"));
        System.out.println("/n[알림] java@codeit.com 유저가 탈퇴하였습니다.");

        // 현재 남은 유저 출력 -> 리스트를 바로 출력
        System.out.println("현재 남은 유저: " + userList);
    }
}
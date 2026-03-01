import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// 필요한 import 추가

// 1. 메인 클래스 (파일명과 같으므로 public 유지)
public class Application {

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("민지", 85),
                new Student("수현", 77),
                new Student("지훈", 90),
                new Student("은우", 65)
        );

        // -------------------------------------------------
        // [문제] 여기에 스트림 로직을 작성하세요.
        // 1. 점수 80점 이상 필터링
        // 2. 이름 대문자 변환
        // 3. List<String>으로 수집
        // -------------------------------------------------
        students.stream()
                .filter(student -> student.getScore() >= 80)
                .map(student -> student.getName().toUpperCase())
                .forEach(System.out::println);//얘 더 모르겠네

    }
}

// 2. 서브 클래스 (public을 지우고 class만 씀)
class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return name + " (" + score + "점)";
    }
}
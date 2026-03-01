
/*
import java.util.function.BinaryOperator;

public class TestTest {
    class Calculator{
        //TODO 덧셈
        public static int add(int x, int y) {
            return x + y;
        }
    }
    public class StaticMethodTest{
        public static void main(String[] args) {
            // TODO: Calculator 클래스의 add 메서드를 메서드 참조로 연결
            BinaryOperator<Integer> operator = Calculator::add;

            int result = operator.apply(10,20)

            System.out.println("정적 메서드 결과: " + result);
        }
    }
}


import java.util.function.BinaryOperator;

class Calculator{
    //TODO 곱셈
    public static int multiply(int x, int y) {
        return x * y;
    }
}
public class InstanceMethodTest{
    public static void main(String[] args) {
        // TODO: 생성한 객체(calc)의 multiply 메서드를 메서드 참조로 연결
        BinaryOperator<Integer> operator = Calculator::multiply;

        int result = operator.apply(10,10);

        System.out.println("인스턴스 메서드 결과: " + result);
    }
}


import java.util.function.BiFunction;
import java.util.function.Function;

public class Member {
    private String name;
    private String id;

    public Member() { System.out.println("기본 생성자"); }

    // TODO: 생성자 두가지 등록
    // 1개 매개변수 받는 생성자
    public Member(String id){
        this.id = id;
        System.out.println("ID 생성자 호출");
    }
    // 2개 매개변수 받는 생성자
    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("ID+Name 생성자 호출");
    }

    @Override
    public String toString() { return "ID: " + id + ", Name: " + name; }
}

public class ConstructorRef {
    public static void main(String[] args) {
        // TODO: 1개 인자 생성자
        Function<String, Member> f1 = Member::new;
        Member m1 = f1.apply("kimcoding");

        // TODO: 2개 인자 생성자
        BiFunction<String, String, Member> f2 = Member::new;
        Member m2 = f2.apply("kimcoding", "김코딩");

        System.out.println(m1);
        System.out.println(m2);
    }
}


import java.util.function.Predicate;

public class LambdaREfactorExample {
    public static void main(String[] args) {
        // 익명 클래스 제거, (매개변수) -> 반환식
        //TODO Predicate


        boolean result = // TODO
                System.out.println("result = " + result);
    }
}
*/
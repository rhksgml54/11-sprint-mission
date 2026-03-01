public class EnumTest {

    public enum Status {
        READY, // 준비됨
        IN_PROGRESS, // 진행중
        DONE // 완료됨
    }
    public void process(Status status) {
        switch (status) {
            case READY  :
                System.out.println("준비됨");
                break;

            case IN_PROGRESS:
                System.out.println("진행중");
                break;

            case DONE:
                System.out.println("완료됨");
                break;

        }
    }
}




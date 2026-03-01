import java.util.Scanner;

public class suger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 5kg을 들고갈래
        // 3kg을 들고갈래
        // 5kg을 들고가는게 가장 좋겠지?

        // 5kg만 먼저 가져가고 남은값에서 3키로를 가져가는건 11,6같은 수에 계산이 실패
        // 5kg 먼저가져가고 3kg로 나눠 떨어지지않은면 다시 5로 돌아가
        // 5kg 봉지수 하나 줄이고 3kg 다시 시도했을때 떨어지는 수는 다 나누어 떨어지는지?
        // 그렇게 해도 안되면 -1 출력



        int 남은_설탕 = sc.nextInt();

        int v_5키로봉지_수 = 0;
        int v_3키로봉지_수 = 0;

        // 생각해보니 5키로를 가장 많이 들고가면서 봉지수를 딱 맞추는게 중요해
        // 5키로를 가장 많이 들고가게하려면 어떻게 해야할까?

        while (true) {
            if (다_들고갔는지_확인(남은_설탕)) {
                v_5키로봉지_수 = 남은_설탕 / 5;
                System.out.println(v_5키로봉지_수 + v_3키로봉지_수);
                break;
            }

            남은_설탕 = 포장_3키로(남은_설탕);
            v_3키로봉지_수 += 1;

            if (남은_설탕 == 0) {
                // 두개 값 합산 반환

                // 항상 틀린값을 반환
                System.out.println(v_5키로봉지_수 + v_3키로봉지_수);
                return;
            }

            if (남은_설탕 < 0){
                System.out.println("-1");
                return;
            }
        }
    }

    // 들고 간다라는걸 어떻게 구현할까?
    public static int 포장_3키로(int 남은_설탕) {
        return 남은_설탕 - 3;
    }

    public static int 포장_5키로(int 남은_설탕) {
        return 남은_설탕 - 5;
    }

    public static boolean 다_들고갔는지_확인(int 남은_설탕) {
        return 남은_설탕 % 5 == 0;
    }

}

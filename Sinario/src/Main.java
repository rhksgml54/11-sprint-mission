import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    // TODO
    //주문번호, 고객명, 상품목록
    String customerName;
    List<String> items;

    public Order(String customerName, List<String> items) {
        this.customerName = customerName;
        this.items = items;
    }


}


public class Application {
    public static void main(String[] args) {
        Map<String, Order> orderMap = new HashMap<>();

// TODO
// ORD001, 민지, 마우스, 키보드
        //orderId = ORD001 customerName = 민지 order.items = "키보드"
// ORD002, 수현, 노트북
// ORD003, 지훈, 모니터, USB 허브, 스피커

        Map<String, Order> orderMap = new HashMap<>();
        orderMap.put("ORD001", new Order("민지", List.of("마우스", "키보드")));
        orderMap.put("ORD002", new Order("수현",List.of("노트북")));
        orderMap.put("ORD003", new Order("지훈", List.of("모니터", "USB허브", "스피커")));


        for (Map.Entry<String, Order> entry : orderMap.entrySet()) {
            String orderId = entry.getKey();
            Order order = entry.getValue();

            System.out.println("주문번호: " + orderId);
            System.out.println("고객명: " + order.customerName);
            System.out.println("상품목록: " + order.items);
            System.out.println("---------------------------");
        }
    }
}
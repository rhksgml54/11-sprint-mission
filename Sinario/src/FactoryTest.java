public class FactoryTest{
    public static void main(String[] args) {
        // Composition 을 위한 부품 객체 생성
        Battery bat = new Battery(5000);

        // 상속받은 자식 객체 생성
        SmartPhone myPhone = new SmartPhone("Galaxy S24", bat, "Android");

        // Object 클래스의 toString() 오버라이딩 확인
        // System.out.println(myPhone.toString()); 과 동일
        System.out.println(myPhone);


    }
}

class Battery {
    // 포함 관계에 사용될 부품
    int capacity;

    public Battery(int capacity) {
        this.capacity = capacity;
    }

}

class Phone {
    // Composition: Phone has a Battery
    String model;
    Battery battery;


    public Phone(String model, Battery battery) {
        this.model = model;
        this.battery = battery;
    }


}

class SmartPhone extends Phone {
    // super(): 부모 클래스(Phone)의 생성자 호출
    // 생성자 첫 줄에 위치하는 것 잊지 마세요
    String os;


    public SmartPhone(String model, Battery battery, String os) {
        // 여기에 부모님(Phone)의 생성자를 호출하는 super(model, battery)가 먼저 와야 해요!
        super(model, battery);
        this.os = os;
        // 그 다음 '나'만의 특징인 this.os를 초기화합니다.


    }
    // overriding: 부모(Object)의 메서드를 재정의
    // 모든 클래스는 자동으로 Object를 상속받기 때문에 toString() 사용 가능
    @Override
    public String toString() {
        return "모델: " + model + ", 배터리: " + battery.capacity + "mAh, OS: " + os;
    }



}
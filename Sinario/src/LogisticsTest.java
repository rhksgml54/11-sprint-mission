public class LogisticsTest {
    public static void main(String[] args) {
        LogisticCenter center = new LogisticCenter();
        // 다형성 활용 -> 부모 타입 배열에 다양한 자식 객체 저장
        Parcel[] parcels = {
                new GeneralParcel("서울 강남구"),
                new FreshParcel("부산 해운대구"),
                new GeneralParcel("경기 성남시")
        };

        System.out.println("== 배송 일괄 처리 시작 ==");

        // 반복문으로 일괄 처리
        for (Parcel p : parcels) {
            center.scanParcel(p);
            System.out.println("----------------------");
        }
    }
}

    class Parcel {
        String address;

        // TODO 프로세스 메서드와 생성자 구현
        public Parcel(String address) {
            this.address = address;
        }

        void process() {
            System.out.println("[" + address + "]" + "배송 준비 중..");
        }
    }

    class GeneralParcel extends Parcel {
        GeneralParcel(String address) {
            super(address);
        }

        // process() 오버라이딩
        @Override
        void process() {
            System.out.println("[" + address + "]" + "일반 택배로 배송합니다.");
        }
    }

    class FreshParcel extends Parcel {
        FreshParcel(String address) { super(address); }
        // 신선 택배 고유 기능 구현, process() 오버라이딩

        void saveCooling() {
            System.out.println(" -> 냉동 상태를 유지합니다. ");
        }
        @Override
        void process() {
            System.out.println("[" + address + "] 긴급신선 택배로 배송합니다.");
        }
    }

    class LogisticCenter {
        // 매개변수 다형성: 어떤 택배든 처리 가능
        void scanParcel(Parcel p) {
            // 실제 객체의 제정의된 메서드 실행 -> 동적 바인딩
            p.process();

        // instanceof 를 이용한 타입 체크 및 안전한 다운캐스팅, 고유 기능 실행
        if(p instanceof FreshParcel) {
            FreshParcel fp = (FreshParcel) p;
            fp.saveCooling();
        }

    }
}

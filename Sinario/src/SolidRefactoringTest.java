import javax.print.attribute.standard.PrinterName;

public class SolidRefactoringTest {
    public static void main(String[] args) {
        // 외부에서 부품(의존성 조립)
        Printer myPrinter = new SimplePrinter();
        DocumentExporter pdfExporter = new PdfExporter();
        // ISP, LSP 적용
        // OCP 적용

        // 생성자 주입 -> DIP 적용
        DocumentService service = new DocumentService(myPrinter, pdfExporter);

        // 실행
        service.process("DOC-001");
    }

}

// 기능별로 인터페이스 분리(3개)
interface Printer {
    void print();
}
interface Scanner {
    void scan();
}
interface Fax {
    void fax();
}

// 필요한 인터페이스만 구현 -> class SimplePrinter
class SimplePrinter implements Printer {
    public void print() {
        System.out.println("기본 프린터로 출력합니다.");
    }
}

// class SmartCopier = 복합기 구현(프린트, 스캔, 팩스 가능)
class SmartCopier implements Printer, Scanner, Fax {
    public void print() {
        System.out.println("출력 완료");
    }

    public  void scan() {
        System.out.println("스캔 완료");
    }

     public void fax() {
        System.out.println("팩스 전송");
    }
}

// 파일 저장 방식을 전략 패턴으로 분리 interface DocumentExporter
    interface DocumentExporter {
        void export(String doxId);
}
    // class pdfExporter
    class PdfExporter implements DocumentExporter {
        public void export(String docId) {
            System.out.println("PDF로 변환하여 저장: " + docId);
        }
}

// class HtmlExporter
    class HtmlExporter implements DocumentExporter {
        public void export(String docId) {
            System.out.println(docId + " -> HTML 저장");
        }
}


class DocumentService {
    // 구체적인 클래스가 아닌 인터페이스에 의존
    private final Printer printer;
    private final DocumentExporter exporter;

    // DI 생성자 주입
    public DocumentService(Printer printer, DocumentExporter exporter) {
        this.printer = printer;
        this.exporter = exporter;
    }

    public void process(String docId) {
        System.out.println("문서 로딩 중: " + docId);

        // OCP: 구체적인 if문 없이 인터페이스 동작 수행
        exporter.export((docId));

        // DIP: 어떤 프린터가 와도 상관없음
        printer.print();
    }

}
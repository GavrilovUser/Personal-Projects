public class RecordTest {
  public static void main(String[] args) {
    record Point(int x, int y, String text) {}

    Point p = new Point(3, 5, "Тест");

    System.out.println((p.x() + p.y()) + p.text());
  }
}
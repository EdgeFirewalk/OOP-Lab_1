import java.util.ArrayList;
import java.util.Scanner;

class Point {
    public int x;
    public int y;

    public Point(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<Point>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты X и Y вершин многоугольника в порядке обхода его границы.");
        System.out.println("Например: 12 8.");
        System.out.println("Введите \"-\", чтобы закончить ввод.\n---");

        String userInput = "";
        while (true) {
            System.out.print("> ");
            userInput = scanner.nextLine();
            try {
                if (userInput.equals("-")) break;

                String[] coordinates = userInput.split(" ");
                if (coordinates.length == 2)
                    points.add(new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
                else
                    System.out.println("Слишком много данных для точки в пространстве. Попробуйте ещё раз...");
            }
            catch (Exception ex) {
                System.out.println("Кажется, в ввод попали буквы. Попробуйте ещё раз...");
            }
        }

        System.out.println("---\nЗаписанный массив точек:");
        for (Point point : points) {
            System.out.print(point.x);
            System.out.print(" ");
            System.out.println(point.y);
        }

        //=== Формула площади Гаусса ===
        int fSum = 0;

        // Первая часть суммы
        for (int i = 0; i < points.size() - 1; i++)
        {
            fSum += points.get(i).x * points.get(i + 1).y;
        }
        fSum += points.get(points.size() - 1).x * points.get(0).y;

        // Вторая часть суммы
        for (int i = 0; i < points.size() - 1; i++)
        {
            fSum -= points.get(i).y * points.get(i + 1).x;
        }
        fSum -= points.get(points.size() - 1).y * points.get(0).x;

        int result = Math.abs(fSum) / 2;
        //==============================

        System.out.println("---\nПлощадь указанного многоугольника равна: " + result);
    }
}
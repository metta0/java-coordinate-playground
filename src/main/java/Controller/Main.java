package Controller;

import java.util.List;
import java.util.Set;
import Model.PointFactory;
import Model.Points;
import Model.Rectangle;
import Model.Triangle;
import Model.Line;
import View.InputView;
import View.ResultView;

public class Main {
    final static ResultView resultView = new ResultView();

    public static void main(String[] args) {

        List<int[]> inputPoints = getPointsFromUser();
        Points points = PointFactory.createPointsFromList(inputPoints);

        // 2. 좌표평면에 도형 표시
        drawPoints(points);

        // 3. 도형의 길이 또는 넓이 표시
        if (isTwoPointsGiven(points)) {
            showLineDistance(points);
        }
        if (isThreePointsGiven(points)) {
            showTriangleArea(points);
        }
        if (isFourPointsGiven(points)){
            showRectangleArea(points);
        }
    }

    public static List<int[]> getPointsFromUser() {
        InputView inputView = new InputView();
        List<int[]> result;

        // 1.입력 범위 초과 시 에러 문구 출력 후 다시 입력받기
        try {
            result = inputView.getPointsFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            result = getPointsFromUser();
        }

        return result;
    }
 
    public static void drawPoints(Points Points){
        Set<String> pointSet = Points.getPointsAsSet();
        resultView.draw(pointSet);
    }

    public static boolean isTwoPointsGiven(Points points) {
        return points.size() == 2;
    }

    public static void showLineDistance(Points points) {
        Line line = new Line(points);

        resultView.printOut(line.showResult());
    }

    public static boolean isThreePointsGiven(Points Points) {
        return Points.size() == 3;
    }
    
    public static void showTriangleArea(Points points) {
        Triangle Triangle = new Triangle(points);

        resultView.printOut(Triangle.showResult());
    }

    public static boolean isFourPointsGiven(Points Points) {
        return Points.size() == 4;
    }

    public static void showRectangleArea(Points points) {
        Rectangle rectangle = new Rectangle(points);

        resultView.printOut(rectangle.showResult());
    }
}

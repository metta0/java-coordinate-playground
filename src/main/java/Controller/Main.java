package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Model.Point;
import Model.Points;
import Model.Rectangle;
import Model.Line;
import Model.ResultView;
import View.InputView;

public class Main {
    final static ResultView resultView = new ResultView();

    public static void main(String[] args) {

        List<int[]> inputPoints = getPointsFromUser();
        Points points = transformToPoints(inputPoints);

        // 2. 좌표에 특수문자 표시
        drawPoints(points);

        // 3. 좌표가 두 개 일 경우, 거리 출력
        if (isTwoPointsGiven(points)) {
            showLineDistance(points);
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

    public static Points transformToPoints(List<int[]> inputPoints) {
        ArrayList<Point> pointsArray = new ArrayList<>();

        for (int[] tempPoint : inputPoints) {
            pointsArray.add(new Point(tempPoint[0], tempPoint[1]));
        }

        return new Points(pointsArray);
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

        resultView.showDistance(line.getLineDistance());
    }

    public static boolean isFourPointsGiven(Points Points) {
        return Points.size() == 4;
    }

    public static void showRectangleArea(Points points) {

        Rectangle rectangle = new Rectangle(points);

        resultView.showRectangleArea(rectangle.getArea());
    }


}

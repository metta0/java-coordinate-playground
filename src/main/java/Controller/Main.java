package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Model.Coordinate;
import Model.Coordinates;
import Model.Line;
import Model.ResultView;
import View.InputView;

public class Main {
    final static ResultView resultView = new ResultView();

    public static void main(String[] args) {

        List<int[]> inputCoordinates = getCoordinatesFromUser();
        Coordinates coordinates = transformToCoordinates(inputCoordinates);

        // 2. 좌표에 특수문자 표시
        drawCoordinates(coordinates);

        // 3. 좌표가 두 개 일 경우, 거리 출력
        if (isTwoCoordinatesGiven(coordinates)) {
            showLineDistance(coordinates);
        }
    }

    public static List<int[]> getCoordinatesFromUser() {
        InputView inputView = new InputView();
        List<int[]> result;

        // 1.입력 범위 초과 시 에러 문구 출력 후 다시 입력받기
        try {
            result = inputView.getCoordinatesFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            result = getCoordinatesFromUser();
        }

        return result;
    }

    public static Coordinates transformToCoordinates(List<int[]> inputCoordinates) {
        ArrayList<Coordinate> coordinatesArray = new ArrayList<>();

        for (int[] coord : inputCoordinates) {
            coordinatesArray.add(new Coordinate(coord[0], coord[1]));
        }

        return new Coordinates(coordinatesArray);
    }

    public static void drawCoordinates(Coordinates coordinates){
        Set<String> coords = coordinates.getCoordinatesAsSet();
        resultView.draw(coords);
    }

    public static boolean isTwoCoordinatesGiven(Coordinates coordinates) {
        return coordinates.size() == 2;
    }

    public static void showLineDistance(Coordinates coordinates) {
        List<int[]> coords = coordinates.getCoordinatesAsList();

        Coordinate coor1 = new Coordinate(coords.get(0)[0], coords.get(0)[1]);
        Coordinate coor2 = new Coordinate(coords.get(1)[0], coords.get(1)[1]);

        Line line = new Line(coor1, coor2);

        resultView.showDistance(line.getLineDistance());
    }
}

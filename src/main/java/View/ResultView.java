package View;

import java.util.Set;

public class ResultView {

    private static final String FOUR_BLANK = "    ";
    private static final String PIPELINE = "|";
    private static final String POINT_MARK = "*";
    private static final String PLUS_MARK = "+";
    private static final String NEW_LINE = System.lineSeparator();
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 24;
    private StringBuilder sb = new StringBuilder();

    public ResultView() {
    }

    public void draw(Set<String> coordinates) {
        drawVerticalLineAndPoint(coordinates);
        drawHorizontalLine();
        drawHorizontalNumber();
        show();
    }


    private void drawVerticalLineAndPoint(Set<String> coordinates) {
        for(int y = MAX_VALUE; y >= MIN_VALUE; y--) {
            drawVerticalLine(y);
            drawVerticalPoint(y, coordinates);
            sb.append(NEW_LINE);
        }
    }

    private void drawVerticalLine(int y) {
        if(y % 2 == 0) {
            sb.append(String.format("%4d|", y));
            return;
        }

        sb.append(FOUR_BLANK).append(PIPELINE);
    }

    private void drawVerticalPoint(int y, Set<String> coordinates) {
        for(int x = MIN_VALUE; x <= MAX_VALUE; x++) {
            drawIfContainsXY(coordinates, x + "," + y);
        }
    }

    private void drawIfContainsXY(Set<String> coordinates, String coord){
        if(coordinates.contains(coord)) {
            sb.append(String.format("%4s", POINT_MARK));
        }

        sb.append(FOUR_BLANK);
    }



    private void drawHorizontalLine() {
        sb.append(String.format("%5s", PLUS_MARK));

        for(int x = MIN_VALUE; x <= MAX_VALUE; x++) {
             sb.append(String.format("%4s", "----"));
        }
    }

    private void drawHorizontalNumber() {
        sb.append(NEW_LINE);
        sb.append(String.format("%4s", 0));

        for(int x = MIN_VALUE; x <= MAX_VALUE; x++) {
            if(x % 2 == 0) {
                sb.append(String.format("%4s", x));
                continue;
            }

            sb.append(FOUR_BLANK);
        }
    }
    

    private void show() {
        System.out.println(sb.toString());
        System.out.println();
    }

    public void showDistance(double lineDistance) {
        System.out.printf("두 점 사이 거리는 %.3f \n", lineDistance);
    }

    public void showTriangleArea(double rectangleArea) {
        System.out.printf("삼각형 넓이는 %.3f \n", rectangleArea);
    }

    public void showRectangleArea(double rectangleArea) {
        System.out.printf("사각형 넓이는 %.3f \n", rectangleArea);
    }
    
    public void printOut(String result) {
        System.out.println(result);
    }
}

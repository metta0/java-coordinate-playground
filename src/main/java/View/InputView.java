package View;

import java.util.List;
import java.util.Scanner;
import Parser.PointParser;

public class InputView {

    public List<int[]> getPointsFromUser() throws IllegalArgumentException {

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        List<int[]> result;

        if (!PointParser.isInputValid(inputString))
            throw new IllegalArgumentException("좌표 형식은 (숫자,숫자) 이어야 합니다.");

        result = PointParser.getPoints(inputString);

        return result;
    }
}

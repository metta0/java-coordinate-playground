package Controller;

import java.util.List;

import Model.Coordinate;
import Model.ResultView;
import View.InputView;

public class Main {
    
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        
        List<int[]> result = getCoordinatesFromUser();
        
        Coordinate coor1 = new Coordinate(result.get(0)[0], result.get(0)[1]);
        Coordinate coor2 = new Coordinate(result.get(0)[0], result.get(0)[1]);

        //2. 좌표에 특수문자 표시

        //3. 좌표가 두 개 일 경우, 거리 출력
    }

    public static List<int[]> getCoordinatesFromUser(){
        InputView inputView = new InputView();
        List<int[]> result;

        //1.입력 범위 초과 시 에러 문구 출력 후 다시 입력받기
        try{
            result = inputView.getCoordinatesFromUser();
        }
        catch(IllegalArgumentException e){
            result = getCoordinatesFromUser();
        }

        return result;
    }
}

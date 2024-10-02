package Controller;

import View.InputView;

public class Main {
    
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<int[]> result = inputView.getCoordinatesFromUser();
    }
}

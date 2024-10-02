package View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputView {
    
    public List<int[]> getCoordinatesFromUser() throws Exception{
        
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        List<int[]> result;

        if(!isInputValid(inputString))
            throw new IllegalArgumentException();
        
        result = getCoordinates(inputString);
        
        return result;

    }

    private boolean isInputValid(String inputText){
        Matcher matcher = Pattern.compile("\\(\\d+,\\d+\\)(\\(\\d+,\\d+\\))?").matcher(inputText);

        if(matcher.find())
            return true;

        return false;
    }

    private List<int[]> getCoordinates(String inputText){
        ArrayList<int[]> result = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\((\\d+),(\\d+)\\)(\\((\\d+),(\\d+)\\))?").matcher(inputText);
        
        int x1 = Integer.parseInt(matcher.group(1));
        int y1 = Integer.parseInt(matcher.group(2));

        result.add(new int[]{x1,y1});

        if(matcher.group(3) != null && matcher.group(4) != null){
            int x2 = Integer.parseInt(matcher.group(3));
            int y2 = Integer.parseInt(matcher.group(4));

            result.add(new int[]{x2,y2});
        }

        return result;
    }
}

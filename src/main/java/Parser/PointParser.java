package Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointParser {

    public static boolean isInputValid(String inputText) {
        Matcher matcher = Pattern.compile("^\\(\\d+,\\d+\\)(-\\(\\d+,\\d+\\))+$").matcher(inputText);

        if (matcher.find())
            return true;

        return false;
    }

    public static List<int[]> getPoints(String inputText) {
        ArrayList<int[]> result = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\((\\d+),(\\d+)\\)").matcher(inputText);

        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));

            result.add(new int[] { x, y });
        }
        
        return result;
    }
    
}

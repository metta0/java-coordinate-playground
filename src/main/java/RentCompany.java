import java.util.ArrayList;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");
    ArrayList<Car> cars;

    RentCompany(){
        cars = new ArrayList<>();
    }

    public static RentCompany create(){
        return new RentCompany();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public String generateReport(){
        StringBuilder result = new StringBuilder();
        
        for(Car car : cars){
            result.append(car.getReport()).append(NEWLINE);
        }    
        return result.toString();
    }
}

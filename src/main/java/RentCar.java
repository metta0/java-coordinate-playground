public abstract class RentCar implements Car{
    protected double fuleEfficiency;
    protected double distance;
    protected String name;
    
    public double getNeededFuel(){
        return distance / fuleEfficiency;
    }
    
}

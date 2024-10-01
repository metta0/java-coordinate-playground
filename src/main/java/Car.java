public abstract class Car {
    protected double fuleEfficiency;
    protected double distance;
    protected String name;
    
    abstract double getFuelEfficiency();

    abstract double getDistance();

    double getNeededFuel(){
        return distance / fuleEfficiency;
    }

    abstract String getReport();
}

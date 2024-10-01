public class Sonata extends RentCar {
    
    Sonata(double distance){
        this.name = "Sonata";
        this.fuleEfficiency = 10;
        this.distance = distance;
    }

    @Override
    public double getDistance() {
        return this.distance;
    }

    @Override
    public double getFuelEfficiency() {
        return this.fuleEfficiency;
    }

    @Override
    public String getReport() {
        return this.name + " : " + (int)this.getNeededFuel() +"리터";
    }
}

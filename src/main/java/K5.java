public class K5 extends RentCar {
    
    K5(double distance){
        this.name = "K5";
        this.fuleEfficiency = 13;
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

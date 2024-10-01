public class Avante extends RentCar {
    
    Avante(double distance){
        this.name = "Avante";
        this.fuleEfficiency = 15;
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

public class Avante extends Car {
    
    Avante(double distance){
        this.name = "Avante";
        this.fuleEfficiency = 15;
        this.distance = distance;
    }

    @Override
    double getDistance() {
        return this.distance;
    }

    @Override
    double getFuelEfficiency() {
        return this.fuleEfficiency;
    }

    @Override
    public String getReport() {
        return this.name + " : " + (int)this.getNeededFuel() +"리터";
    }
}

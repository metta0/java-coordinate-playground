public class K5 extends Car {
    
    K5(double distance){
        this.name = "K5";
        this.fuleEfficiency = 13;
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

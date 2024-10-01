public class Sonata extends Car {
    
    Sonata(double distance){
        this.name = "Sonata";
        this.fuleEfficiency = 10;
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

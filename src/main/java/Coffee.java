public class Coffee extends CaffeineBeverage {

    @Override
    public void brew(){
        System.out.println(("brewCoffeeGrinds"));
    }

    @Override
    public void addCondiments(){
        System.out.println(("addSugarAndMilk"));
    }
    
}

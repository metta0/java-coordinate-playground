public class Tea extends CaffeineBeverage{

    @Override
    public void brew() {
        System.out.println("steepTeaBag");
    }

    @Override
    public void addCondiments() {
        System.out.println("addLemon");
    }
}
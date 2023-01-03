public class Trapeze extends Quadrangle{
    double field;
    Trapeze(Double[] tabOfTops) {
        super(tabOfTops);
        field = whatField();
    }

    @Override
    public void WhoAmI() {
        System.out.println("I'm a trapeze!");
        System.out.println("Circuit: " + String.format("%.2f", circuit) + " Field: " + String.format("%.2f", field));
    }

    @Override
    public String getFigureType() {
        return "Trapeze";
    }

    public double whatField() {
        return ((((Math.abs((tabOfTops[2]-tabOfTops[0])*(tabOfTops[5]-tabOfTops[1]) -
                (tabOfTops[3]-tabOfTops[1])*(tabOfTops[4]-tabOfTops[0])))*1.0)/2)+
                ((Math.abs((tabOfTops[2]-tabOfTops[0])*(tabOfTops[7]-tabOfTops[1]) -
                        (tabOfTops[3]-tabOfTops[1])*(tabOfTops[6]-tabOfTops[0]))*1.0)/2));
    }
}

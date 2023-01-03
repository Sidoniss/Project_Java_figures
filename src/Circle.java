public class Circle extends Figure {
    double field,circuit;
    Circle(Double[] tabOfTop){
        super(tabOfTop);
        circuit = whatCircuit();
        field = whatField();
    }

    @Override
    public void WhoAmI() {
        System.out.println("I'm a Circle!");
        System.out.println("Circuit: " + String.format("%.2f", circuit) + " Field: " + String.format("%.2f", field));
    }

    @Override
    public String getFigureType() {
        return "Circle";
    }

    @Override
    public double whatCircuit() {
        return tabOfTops[2]*3.14*2;
    }

    public double whatField() {
        return Math.pow(tabOfTops[2],2)*3.14;
    }
}

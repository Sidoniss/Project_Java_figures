public class Rectangle extends Parallelogram{
    double field;
    Rectangle(Double[] tabOfTops) {
        super(tabOfTops);
        field = whatField();
    }

    @Override
    public void WhoAmI() {
        System.out.println("I'm a rectangle!");
        System.out.println("Circuit: " + String.format("%.2f", circuit) + " Field: " + String.format("%.2f", field));
    }

    @Override
    public String getFigureType() {
        return "Rectangle";
    }

    @Override
    public double whatField() {
        return tabOfWalls[0]*tabOfWalls[1];
    }
}

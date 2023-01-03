public class Square extends Rectangle{
    double field;
    Square(Double[] tabOfTops) {
        super(tabOfTops);
        field = whatField();
    }

    @Override
    public void WhoAmI() {
        System.out.println("I'm a square!");
        System.out.println("Circuit: " + String.format("%.2f", circuit) + " Field: " + String.format("%.2f", field));
    }

    @Override
    public String getFigureType() {
        return "Square";
    }

    @Override
    public double whatField() {
        return tabOfWalls[0]*2;
    }
}

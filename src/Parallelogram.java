public class Parallelogram extends Trapeze{
    double field;
    Parallelogram(Double[] tabOfTops) {
        super(tabOfTops);
        field = whatField();
    }

    @Override
    public void WhoAmI() {
        System.out.println("I'm a parallelogram!");
        System.out.println("Circuit: " + String.format("%.2f", circuit) + " Field: " + String.format("%.2f", field));
    }

    @Override
    public String getFigureType() {
        return "Parallelogram";
    }

    @Override
    public double whatField() {
        return (2*(Math.abs(((tabOfTops[2]-tabOfTops[0])*(tabOfTops[5]-tabOfTops[1]))-
                ((tabOfTops[3]-tabOfTops[1])*(tabOfTops[4]-tabOfTops[0])))));
    }
}

public class Polygon extends Figure {

    Polygon(Double[] tabOfTop) {
        super(tabOfTop);
    }

    @Override
    public void WhoAmI() {
        System.out.println("I'm a Polygon!");
    }

    @Override
    public String getFigureType() {
        return "Polygon";
    }
}

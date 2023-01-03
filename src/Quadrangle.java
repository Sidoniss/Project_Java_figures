public class Quadrangle extends Figure {

    Quadrangle(Double[] tabOfTop) {
        super(tabOfTop);
    }

    @Override
    public void WhoAmI() {
        System.out.println("I'm a Quadrangle!");
    }

    @Override
    public String getFigureType() {
        return "Quadrangle";
    }
}

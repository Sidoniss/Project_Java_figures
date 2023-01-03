import java.util.Arrays;

public class Triangle extends Figure {
    String triangleType,triangleAngleType;
    double field;
    Triangle(Double[] tabOfTop) {
        super(tabOfTop);
        triangleType = whatTriangle();
        triangleAngleType = whatAngleTriangle();
        field = whatField();
    }

    @Override
    public void WhoAmI() {
        System.out.println("I'm a " + triangleType + " Triangle and I'm " + triangleAngleType + "!");
        System.out.println("Circuit: " + String.format("%.2f", circuit) + " Field: " + String.format("%.2f", field));
    }

    @Override
    public String getFigureType() {
        return "Triangle";
    }
    //sprawdzanie typu trójkąta pod względem ścian
    public String whatTriangle() {
        if(tabOfWalls[0] == tabOfWalls[1] && tabOfWalls[1] == tabOfWalls[2]) {
            return "equilateral";
        }
        else if(tabOfWalls[0] == tabOfWalls[1] || tabOfWalls[0] == tabOfWalls[2] || tabOfWalls[1] == tabOfWalls[2]) {
            return "isosceles";
        }
        else return "an equilateral";
    }

    //sprawdzanie typu trójkąta pod względem kątów
    public String whatAngleTriangle() {
        double[] sortWall = tabOfWalls;
        Arrays.sort(sortWall);
        double c=Math.round(Math.pow(sortWall[2],2)*10.0)/10.0;
        double ab=Math.round((Math.pow(sortWall[0],2)+Math.pow(sortWall[1],2))*10.0)/10.0;
        if(c>ab)
            return "obtuse";
        else if(c<ab)
            return "acute";
        else return "rectangular";
    }
    //obliczanie pola
    public double whatField(){
        double result;
        double p = circuit/2;
        result = Math.sqrt(Math.abs(p*((p-tabOfWalls[0])*(p-tabOfWalls[1])*(p-tabOfWalls[2]))));
        return result;
    }
}

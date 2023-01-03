import java.util.Objects;

public abstract class AddClass {
    //dodawanie odpowiednich figur do tablicy w klasie main
    public static Figure addOne(Double[] tabOfTop) {
        if(tabOfTop.length == 3) {
            return new Circle(tabOfTop);
        }
        else if(tabOfTop.length == 6) {
            if(!isTriangleOrQuadrangle(tabOfTop))
                throw new IllegalArgumentException();
            return new Triangle(tabOfTop);
        }
        else if(tabOfTop.length == 8) {
            if(!isTriangleOrQuadrangle(tabOfTop))
                throw new IllegalArgumentException();
            Quadrangle quadrangle = new Quadrangle(tabOfTop);
            return ChangeQuadrangle(quadrangle,tabOfTop);
        }
        else if(tabOfTop.length > 8 && tabOfTop.length%2 == 0) {
            return new Polygon(tabOfTop);
        }
        else throw new IllegalArgumentException();
    }

    //sprawdzanie poprawnosci dla trójkątów i czworokątów
    public static boolean isTriangleOrQuadrangle(Double[] tabOfTop) {
        int countX = 0;
        int countY = 0;
        for(int i=0;i<tabOfTop.length;i+=2) {
            for (int j = i + 2; j < tabOfTop.length; j+= 2) {
                if(Objects.equals(tabOfTop[i], tabOfTop[j]) && Objects.equals(tabOfTop[i + 1], tabOfTop[j + 1])) {
                    return false;
                }
                if(Objects.equals(tabOfTop[i], tabOfTop[j])) {
                    countX++;
                }
                else if(Objects.equals(tabOfTop[i + 1], tabOfTop[j + 1])) {
                    countY++;
                }
            }
            if(countX>=2 || countY>=2) {
                return false;
            }
            else {
                countX = 0;
                countY = 0;
            }
        }
        return true;
    }
    //tworzenie odpowiedniego typu czworokąta
    public static Figure ChangeQuadrangle(Figure CheckQuadrangle, Double[] tabOfTopRecent) {


        if ((CheckQuadrangle.tabOfTops[3] - CheckQuadrangle.tabOfTops[1])/
                (CheckQuadrangle.tabOfTops[2]-CheckQuadrangle.tabOfTops[0]) ==
                (CheckQuadrangle.tabOfTops[7] - CheckQuadrangle.tabOfTops[5])/
                        (CheckQuadrangle.tabOfTops[6]-CheckQuadrangle.tabOfTops[4]) ||
                (CheckQuadrangle.tabOfTops[5] - CheckQuadrangle.tabOfTops[3])/
                        (CheckQuadrangle.tabOfTops[4]-CheckQuadrangle.tabOfTops[2]) ==
                        (CheckQuadrangle.tabOfTops[7] - CheckQuadrangle.tabOfTops[1])/
                                (CheckQuadrangle.tabOfTops[6]-CheckQuadrangle.tabOfTops[0])) {

            if (CheckQuadrangle.tabOfWalls[0] == CheckQuadrangle.tabOfWalls[2] &&
                    CheckQuadrangle.tabOfWalls[1] == CheckQuadrangle.tabOfWalls[3]) {

                if ((Math.sqrt(Math.pow(CheckQuadrangle.tabOfTops[0]-CheckQuadrangle.tabOfTops[4],2) +
                        Math.pow(CheckQuadrangle.tabOfTops[1]-CheckQuadrangle.tabOfTops[5],2))) ==
                        (Math.sqrt((Math.pow(CheckQuadrangle.tabOfTops[2]-CheckQuadrangle.tabOfTops[6],2) +
                                Math.pow(CheckQuadrangle.tabOfTops[3]-CheckQuadrangle.tabOfTops[7],2))))) {

                    if (CheckQuadrangle.tabOfWalls[0] == CheckQuadrangle.tabOfWalls[1] &&
                            CheckQuadrangle.tabOfWalls[1] == CheckQuadrangle.tabOfWalls[2] &&
                            CheckQuadrangle.tabOfWalls[2] == CheckQuadrangle.tabOfWalls[3]) {
                        return new Square(tabOfTopRecent);
                    } else return new Rectangle(tabOfTopRecent);
                } else return new Parallelogram(tabOfTopRecent);
            } else return new Trapeze(tabOfTopRecent);
        }
        return CheckQuadrangle;
    }
}

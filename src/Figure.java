public class Figure {
    double[] tabOfTops;
    double[] tabOfWalls;
    double circuit;

    Figure(Double[] tabOfTop) {
        tabOfTops = new double[tabOfTop.length];
        tabOfWalls = new double[tabOfTop.length/2];
        for (int i = 0; i < tabOfTops.length; i++) {
            tabOfTops[i] = tabOfTop[i];
        }
        if(tabOfTop.length>3)
            tabOfWalls = lengthOfWall(tabOfTops);
        else tabOfWalls = null;
        circuit = whatCircuit();
    }

        public void WhoAmI() {
            System.out.println("I'm a Figure!");
        }

        public String getFigureType() {
            return "Figure";
        }
    //obliczanie i uzupełnianie danych dla tablicy ścian figury
    public double[] lengthOfWall(double[] tabOfTops) {
        double[] walls = new double[tabOfTops.length/2];
        int j=0;
        for(int i=0;i<tabOfTops.length;i+=2) {
            if(i == tabOfTops.length-2) {
                walls[j++] = Math.round(Math.sqrt((Math.pow(tabOfTops[i]-tabOfTops[0],2) +
                        Math.pow(tabOfTops[i+1]-tabOfTops[1],2)))*100.0)/100.0;
            }
            else {
                walls[j++] = Math.round(Math.sqrt((Math.pow(tabOfTops[i]-tabOfTops[i+2],2) +
                        Math.pow(tabOfTops[i+1]-tabOfTops[i+3],2)))*100.0)/100.0;
            }
        }
        return walls;
    }
    //obliczanie obwodu
    public double whatCircuit() {
        double circuit = 0;
        for (double tabOfWall : tabOfWalls) {
            circuit += tabOfWall;
        }
        return circuit;
    }
    //funkcja odpowiadająca za wyświetlanie wszystkich ścian danej figury
    public void showWalls() {
        if (tabOfWalls != null) {
            System.out.print("Walls: ");
            for (double tabOfWall : tabOfWalls) {
                System.out.print(String.format("%.2f", tabOfWall) + ";");
            }
            System.out.println();
        }
    }


}

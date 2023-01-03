import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfFigure;
        String listOfTop;
        Double[] tabOfTop;

        //pobieranie danych
        System.out.println("The figures are taken in the appropriate syntax, for example:");
        System.out.println("(1,2)4 - circle, (1,2)(3,4)(5,6) - triangle, (1,2)(3,4)(5,6)(7,8) - quadrangle" +
                ", (1,2)(2,3)(4,5)(6,7)(8,9)... - polygon");
        System.out.println("There must be no characters or spaces between the brackets and after them");
        System.out.println("Have fun!");
        System.out.println();
        System.out.println("Enter the number of figures:");
        numberOfFigure = scan.nextInt();
        Figure[] tabOfFigures = new Figure[numberOfFigure];
        boolean goodBad;
        for (int i=0;i<numberOfFigure;i++){
            goodBad = false;
            while (!goodBad) {
                System.out.println("Enter the " + (i+1) + " figure:");
                try {
                    listOfTop = scan.next();
                    if (ParseClass.goodOrNot(listOfTop)) {
                        tabOfTop = ParseClass.convertToDubTab(listOfTop);
                        if(!ParseClass.catchingRepetitions(tabOfTop))
                            throw new IllegalArgumentException();
                        tabOfFigures[i] = AddClass.addOne(tabOfTop);
                        goodBad = true;
                    }
                    else {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Incorrect data! Enter the data again:");
                }
            }
        }

        //funkcje
        for(int i=0; i< numberOfFigure; i++) {
            tabOfFigures[i].WhoAmI();
        }
        for (int i=0; i< numberOfFigure; i++) {
            tabOfFigures[i].showWalls();
        }
        ParseClass.log(tabOfFigures);
        scan.close();
    }
}
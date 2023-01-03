import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ParseClass {
    //Sprawdzanie czy podane dane mieszczą się w założeniach przyjętych przez program
    public static boolean goodOrNot(String test) {
        return test.matches("\\(-?\\d+(\\.\\d+)?,-?\\d+(\\.\\d+)?\\)(-?\\d+(\\.\\d+)?)|(\\(-?\\d+(\\.\\d+)?,-?\\d+(\\.\\d+)?\\)){2,}");
    }
    //konwertowanie tablicy punktów z podanych danych
    public static Double[] convertToDubTab(String list) {
        Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher m = p.matcher(list);
        ArrayList<Double> ints = new ArrayList<Double>();
        while (m.find()) {
            String a = m.group();
            ints.add(Double.valueOf(a));
        }
        Double[] tabOfTop = new Double[ints.size()];
        tabOfTop = ints.toArray(tabOfTop);
        return tabOfTop;
    }
    //Metoda łapiąca powtórzenia w polygon
    public static boolean catchingRepetitions(Double[] tabOfTop) {
        for(int i=0;i<tabOfTop.length;i+=2) {
            for (int j = i + 2; j < tabOfTop.length; j += 2) {
                if (tabOfTop[i].equals(tabOfTop[j]) && tabOfTop[i + 1].equals(tabOfTop[j + 1])) {
                    return false;
                }
            }
        }
        return true;
    }
    //tworzenie pliku oraz zapis w nim utworzonych figur
    public static void log(Figure[] tab) {
        new File("result.txt");
        try {
            PrintWriter write = new PrintWriter("result.txt");
            for (Figure figure : tab) {
                write.print(figure.getFigureType() + ", tops: ");
                if (figure.tabOfTops.length > 3) {
                    for (int j = 0; j < figure.tabOfTops.length; j += 2) {
                        write.print("(" + figure.tabOfTops[j] + "," + figure.tabOfTops[j + 1] + ") ");
                    }
                    write.println();
                } else {
                    write.println("(" + figure.tabOfTops[0] + "," + figure.tabOfTops[1] + ") " + figure.tabOfTops[2]);
                }
            }
            write.close();
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist!");
        }
    }
}

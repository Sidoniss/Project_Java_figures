import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestParseClass {
    //test dla poprawnych ciągów wejściowych
    @Test
    public void trueForParse() {
        Assertions.assertTrue(ParseClass.goodOrNot("(1,2)7"));
        Assertions.assertTrue(ParseClass.goodOrNot("(1.23,2.1251)7.3232"));
        Assertions.assertTrue(ParseClass.goodOrNot("(1,2)(3,4)(7,2)"));
        Assertions.assertTrue(ParseClass.goodOrNot("(1.321,2.132)(5.231,21.31)(43.21,34.43)"));
        Assertions.assertTrue(ParseClass.goodOrNot("(1,2)(4,5)(7,3)(2,7)"));
        Assertions.assertTrue(ParseClass.goodOrNot("(1.421,2.123)(5.321,21.24)(2.323,2.534)(3.34,4.532)"));
        Assertions.assertTrue(ParseClass.goodOrNot("(1,2)(5,3)(1,53)(2,34)(2,54)"));
        Assertions.assertTrue(ParseClass.goodOrNot("(1.2131,2.23)(4.342,1.43)(2.32,5.23)(21.32,12.32)(11,23.32)"));
    }
    //test dla błędnych ciągów wejściowych
    @Test
    public void falseForParse() {
        Assertions.assertFalse(ParseClass.goodOrNot("(1)7"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,)7"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,6)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,2)(1)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,2)3(3,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(2132132132,3213123213,)(2,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1..,2)7"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,.3)7"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,..3)7"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3..)7"));
        Assertions.assertFalse(ParseClass.goodOrNot("(.1,3)7"));
        Assertions.assertFalse(ParseClass.goodOrNot("(..1,3)7"));
        Assertions.assertFalse(ParseClass.goodOrNot("(.1,3).7"));
        Assertions.assertFalse(ParseClass.goodOrNot("(.1,3)7."));
        Assertions.assertFalse(ParseClass.goodOrNot("1,3)7"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,37"));
        Assertions.assertFalse(ParseClass.goodOrNot("(.1,3 7"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1.,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(.1,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1,.2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1,2.)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)1,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1,2"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1.,2)(3,4)"));
        Assertions.assertFalse(ParseClass.goodOrNot("1,23,4,4"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1.,2)(5,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1a,3)(1,2)(6,3)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1d,2)(11,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1,2w)(13,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(w,3)(1,2)(1,24)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)2(1,2)(1,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1,2)2(1,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1,2)w(1,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1,2)(w,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1,2)(1,d)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1,2)1,2)"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1,2)(1,2"));
        Assertions.assertFalse(ParseClass.goodOrNot("(1,3)(1,2)(1,}2)"));
        Assertions.assertFalse(ParseClass.goodOrNot(""));
        Assertions.assertFalse(ParseClass.goodOrNot("w"));
    }
    //test dla poprawnych danych dotyczących trójkąta i kwadratu
    @Test
    public void trueForTriagleAndQuadrangle() {
        Double[] testTriangle = new Double[]{1.0,2.0,5.6,3.5,1.0,3.5};
        Double[]testQuadrangle = new Double[]{4.0,3.0,3.0,4.0,4.0,2.5,5.0,4.0};
        Assertions.assertTrue(AddClass.isTriangleOrQuadrangle(testTriangle));
        Assertions.assertTrue(AddClass.isTriangleOrQuadrangle(testQuadrangle));
    }
    //test dla błędnych danych dotyczących trójkąta i kwadratu
    @Test
    public void falseForTriangleAndQuadrangle() {
        Double[] testTriangle1 = new Double[]{1.0,2.0,1.0,2.0,1.0,2.0};
        Double[] testTriangle2 = new Double[]{1.0,2.0,3.0,4.0,1.0,2.0};
        Double[] testTriangle3 = new Double[]{3.0,2.0,3.0,3.5,3.0,3.5};
        Double[] testTriangle4 = new Double[]{1.0,2.0,5.6,2.0,1.0,2.0};
        Double[]testQuadrangle1 = new Double[]{4.0,3.0,4.0,4.0,4.0,2.5,4.0,2.0};
        Double[]testQuadrangle2 = new Double[]{4.0,3.0,5.0,3.0,4.0,3.0,3.0,3.0};
        Double[]testQuadrangle3 = new Double[]{4.0,3.0,4.0,3.0,4.0,6.0,4.0,2.0};
        Double[]testQuadrangle4 = new Double[]{4.0,3.0,4.0,4.0,4.0,2.5,4.0,2.0};
        Double[]testQuadrangle5 = new Double[]{4.0,2.0,4.0,2.0,3.0,2.5,4.0,2.0};
        Double[]testQuadrangle6 = new Double[]{4.0,3.0,5.0,4.0,5.0,2.5,5.0,2.0};

        Assertions.assertFalse(AddClass.isTriangleOrQuadrangle(testTriangle1));
        Assertions.assertFalse(AddClass.isTriangleOrQuadrangle(testTriangle2));
        Assertions.assertFalse(AddClass.isTriangleOrQuadrangle(testTriangle3));
        Assertions.assertFalse(AddClass.isTriangleOrQuadrangle(testTriangle4));
        Assertions.assertFalse(AddClass.isTriangleOrQuadrangle(testQuadrangle1));
        Assertions.assertFalse(AddClass.isTriangleOrQuadrangle(testQuadrangle2));
        Assertions.assertFalse(AddClass.isTriangleOrQuadrangle(testQuadrangle3));
        Assertions.assertFalse(AddClass.isTriangleOrQuadrangle(testQuadrangle4));
        Assertions.assertFalse(AddClass.isTriangleOrQuadrangle(testQuadrangle5));
        Assertions.assertFalse(AddClass.isTriangleOrQuadrangle(testQuadrangle6));
    }
    //test dla danych nie zawierajacych powtórzeń
    @Test
    public void trueForcatchingRepetitions() {
        Double[] testTriangle1 = new Double[]{1.0,2.0,5.6,2.0,1.0,3.0};
        Double[] testTriangle2 = new Double[]{1.0,2.0,1.0,4.0,3.0,5.5};
        Double[] testTriangle3 = new Double[]{5.5,4.0,8.0,2.0,1.0,2.0};
        Double[]testQuadrangle1 = new Double[]{4.0,3.0,5.0,3.0,2.0,2.5,5.0,2.0};
        Double[]testQuadrangle2 = new Double[]{5.0,2.0,4.0,3.0,5.0,1.0,6.0,5.0};
        Double[]testQuadrangle3 = new Double[]{10.0,9.0,7.0,5.0,4.0,24.0,45.0,2.0};
        Double[]testQuadrangle4 = new Double[]{4.0,33.0,6.0,8.0,9.0,21.5,4.0,13.0};

        Assertions.assertTrue(ParseClass.catchingRepetitions(testTriangle1));
        Assertions.assertTrue(ParseClass.catchingRepetitions(testTriangle2));
        Assertions.assertTrue(ParseClass.catchingRepetitions(testTriangle3));
        Assertions.assertTrue(ParseClass.catchingRepetitions(testQuadrangle1));
        Assertions.assertTrue(ParseClass.catchingRepetitions(testQuadrangle2));
        Assertions.assertTrue(ParseClass.catchingRepetitions(testQuadrangle3));
        Assertions.assertTrue(ParseClass.catchingRepetitions(testQuadrangle4));
    }
    //test dla danych zawierajacych powtórzenia
    @Test
    public void falseForcatchingRepetitions() {
        Double[] testTriangle1 = new Double[]{1.0,2.0,5.6,2.0,1.0,2.0};
        Double[] testTriangle2 = new Double[]{1.0,2.0,1.0,2.0,3.0,5.5};
        Double[] testTriangle3 = new Double[]{5.5,4.0,1.0,2.0,1.0,2.0};
        Double[]testQuadrangle1 = new Double[]{4.0,3.0,4.0,3.0,2.0,2.5,5.0,2.0};
        Double[]testQuadrangle2 = new Double[]{5.0,2.0,4.0,3.0,4.0,3.0,6.0,5.0};
        Double[]testQuadrangle3 = new Double[]{10.0,9.0,7.0,5.0,4.0,2.0,4.0,2.0};
        Double[]testQuadrangle4 = new Double[]{4.0,3.0,6.0,8.0,9.0,21.5,4.0,3.0};

        Assertions.assertFalse(ParseClass.catchingRepetitions(testTriangle1));
        Assertions.assertFalse(ParseClass.catchingRepetitions(testTriangle2));
        Assertions.assertFalse(ParseClass.catchingRepetitions(testTriangle3));
        Assertions.assertFalse(ParseClass.catchingRepetitions(testQuadrangle1));
        Assertions.assertFalse(ParseClass.catchingRepetitions(testQuadrangle2));
        Assertions.assertFalse(ParseClass.catchingRepetitions(testQuadrangle3));
        Assertions.assertFalse(ParseClass.catchingRepetitions(testQuadrangle4));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTriangleAndQuadrangleTypeClass {
    //test dla poprawnych typów trójkąta
    @Test
    public void trueForTriangleType() {
        Double[] testeq = {-2.0,4.0,2.0,2.0,1.73,6.46};
        Double[] testaeq = {-4.0,1.0,1.0,-6.0,7.0,5.0};
        Double[] testis = {0.0,0.0,3.0,1.0,1.0,3.0};
        Triangle equilateralTriangle = new Triangle(testeq);
        Triangle anEquilateralTriangle = new Triangle(testaeq);
        Triangle isoscelesTriangle = new Triangle(testis);
        Assertions.assertEquals("equilateral", equilateralTriangle.triangleType);
        Assertions.assertEquals("an equilateral", anEquilateralTriangle.triangleType);
        Assertions.assertEquals("isosceles", isoscelesTriangle.triangleType);

        Double[] testob = {6.0,3.0,1.0,2.0,9.0,8.0};
        Double[] testac = {5.0,5.0,0.0,7.0,2.0,9.0};
        Double[] testrec = {-3.0,-1.0,2.0,-1.0,2.0,3.0};
        Triangle obtuseTriangle = new Triangle(testob);
        Triangle acuteTriangle = new Triangle(testac);
        Triangle rectangularTriangle = new Triangle(testrec);
        Assertions.assertEquals("obtuse", obtuseTriangle.triangleAngleType);
        Assertions.assertEquals("acute", acuteTriangle.triangleAngleType);
        Assertions.assertEquals("rectangular", rectangularTriangle.triangleAngleType);
    }
    //test dla błędnych typów trójkąta
    @Test
    public void falseForTriangleType() {
        Double[] testeq = {-2.0,4.0,2.0,2.0,1.73,6.46};
        Double[] testaeq = {-4.0,1.0,1.0,-6.0,7.0,5.0};
        Double[] testis = {0.0,0.0,3.0,1.0,1.0,3.0};
        Triangle equilateralTriangle = new Triangle(testaeq);
        Triangle anEquilateralTriangle = new Triangle(testis);
        Triangle isoscelesTriangle = new Triangle(testeq);
        Assertions.assertNotEquals("equilateral", equilateralTriangle.triangleType);
        Assertions.assertNotEquals("an equilateral", anEquilateralTriangle.triangleType);
        Assertions.assertNotEquals("isosceles", isoscelesTriangle.triangleType);

        Double[] testob = {6.0,3.0,1.0,2.0,9.0,8.0};
        Double[] testac = {5.0,5.0,0.0,7.0,2.0,9.0};
        Double[] testrec = {-3.0,-1.0,2.0,-1.0,2.0,3.0};
        Triangle obtuseTriangle = new Triangle(testac);
        Triangle acuteTriangle = new Triangle(testrec);
        Triangle rectangularTriangle = new Triangle(testob);
        Assertions.assertNotEquals("obtuse", obtuseTriangle.triangleAngleType);
        Assertions.assertNotEquals("acute", acuteTriangle.triangleAngleType);
        Assertions.assertNotEquals("rectangular", rectangularTriangle.triangleAngleType);
    }
    //test dla poprawnych typów czworokąta
    @Test
    public void trueForQuadrangleType() {
        Figure[] tabOfFigures = new Figure[4];
        Double[] testtr = {-1.0,-5.0,5.0,1.0,1.0,3.0,-2.0,0.0};
        Double[] testpar = {-3.0,5.0,-2.0,-1.0,9.0,-3.0,8.0,3.0};
        Double[] testrec = {5.0,-3.0,-3.0,5.0,-7.0,1.0,1.0,-7.0};
        Double[] testsq = {2.0,1.0,0.0,5.0,-4.0,3.0,-2.0,-1.0};

        tabOfFigures[0] = new Quadrangle(testtr);
        tabOfFigures[1] = new Quadrangle(testpar);
        tabOfFigures[2] = new Quadrangle(testrec);
        tabOfFigures[3] = new Quadrangle(testsq);
        tabOfFigures[0] = AddClass.ChangeQuadrangle(tabOfFigures[0],testtr);
        tabOfFigures[1] = AddClass.ChangeQuadrangle(tabOfFigures[1],testpar);
        tabOfFigures[2] = AddClass.ChangeQuadrangle(tabOfFigures[2],testrec);
        tabOfFigures[3] = AddClass.ChangeQuadrangle(tabOfFigures[3],testsq);

        Assertions.assertEquals("Trapeze", tabOfFigures[0].getFigureType());
        Assertions.assertEquals("Parallelogram", tabOfFigures[1].getFigureType());
        Assertions.assertEquals("Rectangle", tabOfFigures[2].getFigureType());
        Assertions.assertEquals("Square", tabOfFigures[3].getFigureType());
    }
    //test dla błędnych typów czworokąta
    @Test
    public void falseForQuadrangleType() {
        Figure[] tabOfFigures = new Figure[4];
        Double[] testtr = {-1.0,-5.0,5.0,1.0,1.0,3.0,-2.0,0.0};
        Double[] testpar = {-3.0,5.0,-2.0,-1.0,9.0,-3.0,8.0,3.0};
        Double[] testrec = {5.0,-3.0,-3.0,5.0,-7.0,1.0,1.0,-7.0};
        Double[] testsq = {2.0,1.0,0.0,5.0,-4.0,3.0,-2.0,-1.0};

        tabOfFigures[0] = new Quadrangle(testsq);
        tabOfFigures[1] = new Quadrangle(testrec);
        tabOfFigures[2] = new Quadrangle(testpar);
        tabOfFigures[3] = new Quadrangle(testtr);
        tabOfFigures[0] = AddClass.ChangeQuadrangle(tabOfFigures[0],testtr);
        tabOfFigures[1] = AddClass.ChangeQuadrangle(tabOfFigures[1],testpar);
        tabOfFigures[2] = AddClass.ChangeQuadrangle(tabOfFigures[2],testrec);
        tabOfFigures[3] = AddClass.ChangeQuadrangle(tabOfFigures[3],testsq);

        Assertions.assertNotEquals("Trapeze", tabOfFigures[0].getFigureType());
        Assertions.assertNotEquals("Parallelogram", tabOfFigures[1].getFigureType());
        Assertions.assertNotEquals("Rectangle", tabOfFigures[2].getFigureType());
        Assertions.assertNotEquals("Square", tabOfFigures[3].getFigureType());
    }
}

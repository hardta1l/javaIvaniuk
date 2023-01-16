package lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Variant7test {

    @Test(dataProvider = "integerProvider")
    public void integerTest(int p1, int []array) {
        assertEquals(new Variant7().integerNumbersTask(p1), array);
    }
    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 25, new int[] { 7, 10 }}, { 48, new int[] {12, 32 }}, {78, new int[] {15, 56} }};
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeIntegerTest() {
        new Variant7().integerNumbersTask( 100);
    }

    //        ////////////////////////////////////////////////
    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, int p3, boolean p4) {
        assertEquals(new Variant7().booleanTask(p1, p2, p3), p4);
    }
    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 2, 4, 6, true }, { 1, 56, 100, true }, { 12, 1, 13,  false } };
    }

    //        ////////////////////////////////////////////////
    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3) {
        assertEquals(new Variant7().ifTask(p1, p2), p3);
    }
    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 1, 5, 1}, { 4, 1, 2 }, { 23, 40, 1 } };
    }

    //////////////////////////////////////////////////
    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, double p2, double p3) {
        assertEquals(new Variant7().switchTask(p1, p2), p3);
    }
    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 1, 5.5, 5.5 }, { 5, 6.0, 0.06} };
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeSwitchTest() {
        new Variant7().switchTask( 33, 1);
    }

    //        ////////////////////////////////////////////////
    @Test(dataProvider = "forProvider")
    public void forTest(int p1, int p2, int p3) {
        assertEquals(new Variant7().forTask(p1, p2), p3);
    }
    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { {3, 4, 7}, {2, 8, 35}};
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeForTest() {
        new Variant7().forTask( 4, 3);
    }

    //        ////////////////////////////////////////////////
    @Test(dataProvider = "whileProvider")
    public void whileTest(int p1, int p2) {
        assertEquals(new Variant7().whileTask(p1), p2);
    }
    @DataProvider
    public Object[][] whileProvider() {
        Object[][] objects = {{9, 4}, {63, 8}};
        return objects;
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeWhileTest() {
        new Variant7().whileTask( -1);
    }




    //        ////////////////////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] array, int n , int [] result) {
        assertEquals(new Variant7().arrayTask(array, n), result);
    }
    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { new int[] { 1, 2, 3, 4, 5}, 5, new int[] { 5, 4, 3, 2, 1}}, { new int[] { 1, -2, 4, -8}, 4, new int[] { -8, 4, -2, 1}}};
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeArrayTest() {
        new Variant7().arrayTask(new int[]{1, 2}, 0);
    }

    //        ////////////////////////////////////////////////
    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int n, int m, int k, int[] output) {
        assertEquals(new Variant7().twoDimensionArrayTask(input, n, m, k), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {{1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 12, 3, 44, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}};

        int[] output = {1, 12, 3, 44, 5};

        int[][] input1 = {{-98, 8, 1},
                {-98, 8, 1},
                {-98, 8, 1},
                {98, 18, 11}};

        int[] output1 = {98, 18, 11};

        return new Object[][] { {input, 5, 5, 2, output}, {input1, 4, 3, 3, output1} };

    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeMatrixTest() {
        int[][] input = {{1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 12, 3, 44, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}};

        new Variant7().twoDimensionArrayTask(input,  3, 3, 0);
    }


}



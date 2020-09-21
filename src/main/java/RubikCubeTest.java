import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RubikCubeTest {
    private static RubikCube cube1;
    int size = 1;
    @Test
    public void testRubikCubeTop() {
        size = 2;
        cube1 = new RubikCube(size);
        String cube2 =  "O  O     W  W     Y  Y     G  G     B  B     R  R     \n" +
                        "O  O     W  W     Y  Y     G  G     B  B     R  R     \n";
        cube1.toTop(1);
        assertEquals(cube1.toString(), cube2);
        size = 9;
        cube1 = new RubikCube(size);
        cube2 = "W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R     Y  Y  Y  Y  Y  Y  Y  Y  Y     G  G  G  G  G  G  G  G  G     \n" +
                "W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R     Y  Y  Y  Y  Y  Y  Y  Y  Y     G  G  G  G  G  G  G  G  G     \n" +
                "W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R     Y  Y  Y  Y  Y  Y  Y  Y  Y     G  G  G  G  G  G  G  G  G     \n" +
                "W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R     Y  Y  Y  Y  Y  Y  Y  Y  Y     G  G  G  G  G  G  G  G  G     \n" +
                "W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R     Y  Y  Y  Y  Y  Y  Y  Y  Y     G  G  G  G  G  G  G  G  G     \n" +
                "W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R     Y  Y  Y  Y  Y  Y  Y  Y  Y     G  G  G  G  G  G  G  G  G     \n" +
                "W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R     Y  Y  Y  Y  Y  Y  Y  Y  Y     G  G  G  G  G  G  G  G  G     \n" +
                "W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R     Y  Y  Y  Y  Y  Y  Y  Y  Y     G  G  G  G  G  G  G  G  G     \n" +
                "W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R     Y  Y  Y  Y  Y  Y  Y  Y  Y     G  G  G  G  G  G  G  G  G     \n";
        cube1.toTop(5);
        cube1.toTop(2);
        assertEquals(cube1.toString(), cube2);
        size = 13;
        cube1 = new RubikCube(size);
        cube2 = "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B  B  B  B  B  B  B  B     R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W     O  O  O  O  O  O  O  O  O  O  O  O  O     G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     \n";
        cube1.toTop(0);
        cube1.toTop(1);
        cube1.toTop(2);
        cube1.toTop(3);
        cube1.toTop(4);
        cube1.toTop(5);
        assertEquals(cube1.toString(), cube2);
    }

    @Test
    public void testRubikCubeRotate() {
        size = 5;
        cube1 = new RubikCube(size);
        String cube2 =  "B  B  B  B  B     W  W  W  W  W     O  O  O  O  O     G  G  G  G  G     R  R  R  R  R     Y  Y  Y  Y  Y     \n" +
                        "B  B  B  B  B     G  G  G  G  G     R  R  R  R  R     W  W  W  W  W     O  O  O  O  O     Y  Y  Y  Y  Y     \n" +
                        "B  B  B  B  B     W  W  W  W  W     O  O  O  O  O     G  G  G  G  G     R  R  R  R  R     Y  Y  Y  Y  Y     \n" +
                        "B  B  B  B  B     G  G  G  G  G     R  R  R  R  R     W  W  W  W  W     O  O  O  O  O     Y  Y  Y  Y  Y     \n" +
                        "B  B  B  B  B     W  W  W  W  W     O  O  O  O  O     G  G  G  G  G     R  R  R  R  R     Y  Y  Y  Y  Y     \n";
        cube1.rotateRowRight(0);
        cube1.rotateRowRight(2);
        cube1.rotateRowRight(4);
        cube1.rotateRowLeft(1);
        cube1.rotateRowLeft(3);
        assertEquals(cube1.toString(), cube2);
        cube1 = new RubikCube(size);
        String cube3 =  "B  B  B  B  B     W  W  W  W  W     O  O  O  O  O     G  G  G  G  G     R  R  R  R  R     Y  Y  Y  Y  Y     \n" +
                        "B  B  B  B  B     W  W  W  W  W     O  O  O  O  O     G  G  G  G  G     R  R  R  R  R     Y  Y  Y  Y  Y     \n" +
                        "B  B  B  B  B     W  W  W  W  W     O  O  O  O  O     G  G  G  G  G     R  R  R  R  R     Y  Y  Y  Y  Y     \n" +
                        "B  B  B  B  B     W  W  W  W  W     O  O  O  O  O     G  G  G  G  G     R  R  R  R  R     Y  Y  Y  Y  Y     \n" +
                        "B  B  B  B  B     W  W  W  W  W     O  O  O  O  O     G  G  G  G  G     R  R  R  R  R     Y  Y  Y  Y  Y     \n";
        cube1.rotateRowRight(0);
        cube1.rotateRowRight(1);
        cube1.rotateRowRight(2);
        cube1.rotateRowRight(3);
        cube1.rotateRowRight(4);
        assertEquals(cube1.toString(), cube3);
        size = 6;
        cube1 = new RubikCube(size);
        cube3 = "B  B  B  B  B  B     G  G  G  G  G  G     R  R  R  R  R  R     W  W  W  W  W  W     O  O  O  O  O  O     Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B     G  G  G  G  G  G     R  R  R  R  R  R     W  W  W  W  W  W     O  O  O  O  O  O     Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B     G  G  G  G  G  G     R  R  R  R  R  R     W  W  W  W  W  W     O  O  O  O  O  O     Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B     G  G  G  G  G  G     R  R  R  R  R  R     W  W  W  W  W  W     O  O  O  O  O  O     Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B     G  G  G  G  G  G     R  R  R  R  R  R     W  W  W  W  W  W     O  O  O  O  O  O     Y  Y  Y  Y  Y  Y     \n" +
                "B  B  B  B  B  B     G  G  G  G  G  G     R  R  R  R  R  R     W  W  W  W  W  W     O  O  O  O  O  O     Y  Y  Y  Y  Y  Y     \n";
        cube1.rotateRowLeft(0);
        cube1.rotateRowLeft(1);
        cube1.rotateRowLeft(2);
        cube1.rotateRowLeft(3);
        cube1.rotateRowLeft(4);
        assertEquals(cube1.toString(), cube3);
    }

}
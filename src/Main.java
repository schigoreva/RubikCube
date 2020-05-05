import java.util.Scanner;

public class Main {
    private static RubikCube cube;
    private static Scanner console;

    public static void main(String[] args) {
        console = new Scanner(System.in);
        int size = 1;
        do {
            if (size < 1) {
                System.err.println("Please, enter a valid size");
                System.out.print("Enter cube size\n>> ");
            }
            System.out.print("Enter cube size\n>> ");
            while (!console.hasNextInt()) {
                System.err.println("Please, enter an integer");
                System.out.print("Enter cube size\n>> ");
                console.nextLine();
            }
            size = console.nextInt();
        } while (size < 1);
        console.nextLine();
        cube = new RubikCube(size);
        String command = readCommand();
        while (!command.equals("finish")) {
            try {
                cube.apply(command);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
            command = readCommand();
        }
        console.close();
    }

    private static String readCommand() {
        System.out.println(cube.toString());
        System.out.print(">> ");
        return console.nextLine();
    }
}

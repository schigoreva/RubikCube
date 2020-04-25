import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int size = console.nextInt();
        RubikCube cube = new RubikCube(size);
        System.out.println("start");
        String command = console.nextLine();
        while (!command.equals("finish")) {
            if (command.equals("show")) {
                System.out.println(cube.toString());
            } else {
                if (command.length() > 5) {
                    cube.turnVerge(command);
                } else if (command.length() == 5) {
                    cube.turnCubeCommand(command);
                }
            }
            command = console.nextLine();
        }
        console.close();
    }
}

import java.util.Scanner;
public class Menu {
    public enum Command {
        START, SAVE_GAME, LOAD_GAME, HIGH_SCORES, QUIT;
    }
    public static void optionsIfs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza um comando: ");
        String line = scanner.nextLine();
        Command command = Command.valueOf(line);
        if (command == Command.SAVE_GAME) {
            System.out.println("Save");
        } else if (command == Command.LOAD_GAME) {
            System.out.println("Load");
        } else if (command == Command.START) {
            System.out.println("Start");
        } else if (command == Command.HIGH_SCORES) {
            System.out.println("High Scores");
        } else if (command == Command.QUIT) {
            System.out.println("Quit");
        }
        else{
            optionsIfs();
        }
    }
    public static void optionsSwitch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza um comando: ");
        String line = scanner.nextLine();
        Command command = Command.valueOf(line);
        switch(command){
            case START:{
                System.out.println("Start");
                break;
            }
            case LOAD_GAME:{
                System.out.println("Load");
                break;
            }
            case HIGH_SCORES:{
                System.out.println("High Scores");
                break;
            }
            case SAVE_GAME:{
                System.out.println("Save");
                break;
            }
            case QUIT:{
                System.out.println("Quit");
                break;
            }
            default:
                optionsSwitch();
                break;
        }
    }
}
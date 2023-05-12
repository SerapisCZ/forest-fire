import java.util.Scanner;

public class Tui {

    public int forestHeight;
    public int forestWidth;

    public appModes appMode;
    public int numberOfSteps = 10;
    public enum appModes {
        WHILE_BURNING,
        SET_STEPS,
        SHOW_AFTER_STEP
    }

    private Scanner input;

    public Tui(){
        printMainTitle();
    }

    public void getUserPreferences(){
            try{
                System.out.print("Write desired height of the forest (enter for default 10x10): ");
                input = new Scanner(System.in);
                String desiredHeightInput = input.nextLine();
                if (!desiredHeightInput.isEmpty()) {
                    forestHeight = Integer.parseInt(desiredHeightInput);
                    System.out.print("Write desired width of the forest: ");
                    forestWidth = Integer.parseInt(input.nextLine());
                } else {
                    System.out.println("We will be using the default values.");
                }
                System.out.print(System.lineSeparator());
                System.out.println("The application can run in these modes:");
                System.out.println("1) Show next step as long as the forest is burning.");
                System.out.println("2) Show first X number of steps.");
                System.out.println("3) Show state of the forest after X number of steps.");
                System.out.println("What mode do you wish to use? (1 is default) ");
                int appModeInput = Integer.parseInt(input.nextLine());
                if (appModeInput == 1) {
                    appMode = appModes.WHILE_BURNING;
                } else if (appModeInput == 2) {
                    appMode = appModes.SET_STEPS;
                    getNumberOfSteps();
                } else if (appModeInput == 3) {
                    appMode = appModes.SHOW_AFTER_STEP;
                    getNumberOfSteps();
                } else {
                    throw new NumberFormatException();
                }
                System.out.print(System.lineSeparator());
            } catch(NumberFormatException ex){
                System.out.println("Sorry, but this is not valid option. Try again.");
                getUserPreferences();
            }
    }

    private void getNumberOfSteps(){
        System.out.print("Write number of steps: ");
        numberOfSteps = Integer.parseInt(input.nextLine());
    }

    private void printMainTitle(){
        System.out.println("*************************");
        System.out.println("* Forest fire simulator *");
        System.out.println("*************************");
    }
}

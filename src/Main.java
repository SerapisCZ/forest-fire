import java.lang.Thread;

public class Main {
    public static void main(String[] args){
        try{
            Settings.init();

            Tui tui = new Tui();
            tui.getUserPreferences();

            Forest forest = new Forest(tui.forestHeight, tui.forestWidth);
            forest.StartFire(1,1);
            if (tui.appMode == Tui.appModes.WHILE_BURNING){
                forest.ShowForest();
                while (forest.isBurning()){
                    forestCycle(forest);
                }
            } else if (tui.appMode == Tui.appModes.SET_STEPS) {
                for (int i = 0; i < tui.numberOfSteps; i++){
                    forestCycle(forest);
                }
            } else if (tui.appMode == Tui.appModes.SHOW_AFTER_STEP) {
                for (int i = 0; i < tui.numberOfSteps; i++){
                    forest.Burn();
                }
                forest.ShowForest();
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void forestCycle(Forest forest) throws InterruptedException{
        Thread.sleep(1000);
        forest.Burn();
        forest.ShowForest();
    }
}
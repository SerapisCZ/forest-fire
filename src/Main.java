import java.lang.Thread;
public class Main {
    public static void main(String[] args){
        try{
            Tui tui = new Tui();
            tui.getUserPreferences();

            Forest forest = new Forest(tui.forestHeight, tui.forestWidth);
            forest.StartFire(1,1);
            forest.ShowForest();
            //TODO Make it react to application mode
            for (int i = 0; i < 20; i++){
                Thread.sleep(1000);
                forest.Burn();
                forest.ShowForest();
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
import java.io.PrintWriter;

public class Forest {
    ForestTile[][] forest;
    int forestHeight; //TODO Width and height are switched!!!
    int forestWidth;

    int defaultForestHeight = 10;
    int defaultForestWidth = 10;

    boolean isBurning = true;

    public Forest(int height, int width){
        assignForestDimensions(height, width);
        forest = new ForestTile[forestWidth][forestHeight];
        for (int i = 0; i < forestWidth; i++){
            for (int k = 0; k < forestHeight; k++){
                forest[i][k] = new ForestTile();
            }
        }
    }

    public void ShowForest(){
        System.out.println("****************************");
        for (int i = 0; i < forestWidth; i++){
            for (int k = 0; k < forestHeight; k++){
                System.out.print(forest[i][k].print());
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public void StartFire(int width, int height){
        forest[width][height].fireForceSpread();
        step();
    }

    public void Burn(){
        isBurning = false;
        for (int i = 0; i < forestWidth; i++) {
            for (int k = 0; k < forestHeight; k++) {
                if (forest[i][k].isBurning()) {
                    isBurning = true;
                    // UP
                    int upWidth = i - 1;
                    if (upWidth >= 0 && upWidth < forestWidth) {
                        forest[upWidth][k].fireSpread();
                    }
                    // DOWN
                    int downWidth = i + 1;
                    if (downWidth >= 0 && downWidth < forestWidth) {
                        forest[downWidth][k].fireSpread();
                    }
                    // LEFT
                    int leftOffset = k - 1;
                    if (leftOffset >= 0 && leftOffset < forestHeight) {
                        forest[i][leftOffset].fireSpread();
                    }
                    // RIGHT
                    int rightOffset = k + 1;
                    if (rightOffset >= 0 && rightOffset < forestHeight) {
                        forest[i][rightOffset].fireSpread();
                    }
                }
            }
        }
        step();
    }

    private void assignForestDimensions(int height, int width){
        if (height == 0 || width == 0){
            forestHeight = defaultForestHeight;
            forestWidth = defaultForestWidth;
        } else {
            forestHeight = height;
            forestWidth = width;
        }
    }

    private void step(){
        for (int a = 0; a < forestWidth; a++) {
            for (int b = 0; b < forestHeight; b++) {
                forest[a][b].step();
            }
        }
    }
}

public class Forest {
    ForestTile[][] forest;
    int forestHeight;
    int forestWidth;

    int defaultForestHeight = 10;
    int defaultForestWidth = 10;

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
        for (ForestTile[] row: forest){
            for (ForestTile tile: row){
                System.out.print(tile.print() + " ");
            }
            System.out.print(System.lineSeparator());
        }
    }

    public void StartFire(int width, int height){
        forest[width][height].fireForceSpread();
        step();
    }

    public boolean isBurning(){
        for (ForestTile[] row: forest){
            for (ForestTile tile: row){
                if (tile.isBurning()) return true;
            }
        }
        return false;
    }

    public void Burn(){
        for (int i = 0; i < forestWidth; i++) {
            for (int k = 0; k < forestHeight; k++) {
                if (forest[i][k].isBurning()) {
                    // UP
                    int upWidth = i - 1;
                    if (upWidth >= 0 && upWidth < forestWidth) {
                        forest[upWidth][k].fireSpread();
                    }
                    // DOWN
                    int downWidth = i + 1;
                    if (downWidth < forestWidth) {
                        forest[downWidth][k].fireSpread();
                    }
                    // LEFT
                    int leftOffset = k - 1;
                    if (leftOffset >= 0 && leftOffset < forestHeight) {
                        forest[i][leftOffset].fireSpread();
                    }
                    // RIGHT
                    int rightOffset = k + 1;
                    if (rightOffset < forestHeight) {
                        forest[i][rightOffset].fireSpread();
                    }
                }
            }
        }
        step();
    }

    private void assignForestDimensions(int height, int width){
        if (height == 0 || width == 0){
            forestHeight = defaultForestWidth;
            forestWidth = defaultForestHeight;
        } else {
            forestHeight = width;
            forestWidth = height;
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

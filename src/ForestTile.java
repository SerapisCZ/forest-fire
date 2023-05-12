public class ForestTile {

    private Settings.FOREST_TILE_TYPES type;
    private Settings.FOREST_TILE_TYPES nextStepType;
    int burnTime;

    public ForestTile(){
        type = Settings.FOREST_TILE_TYPES.TREE;
        nextStepType = null;
        burnTime = 0;
    }

    public String print(){
        return Settings.FOREST_TILES_STRINGS.get(type);
    }

    public void fireForceSpread() {
        nextStepType = Settings.FOREST_TILE_TYPES.FIRE;
    }

    public void fireSpread() {
        if (type == Settings.FOREST_TILE_TYPES.TREE) {
            int random = (int)(Math.random() * 10 + 1);
            if (random % 2 == 0) nextStepType = Settings.FOREST_TILE_TYPES.FIRE;
        }
    }

    public boolean isBurning(){
        return (type == Settings.FOREST_TILE_TYPES.FIRE);
    }

    public void step(){
        if (nextStepType != null){
            type = nextStepType;
            nextStepType = null;
        }
        if (type == Settings.FOREST_TILE_TYPES.FIRE) burnTime++;
        if (burnTime == 3) type = Settings.FOREST_TILE_TYPES.BURNED;
    }
}

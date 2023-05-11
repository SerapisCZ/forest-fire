public class ForestTile {

    private String type;
    private String nextStepType;
    int burnTime;

    public ForestTile(){
        type = "tree";
        nextStepType = "";
        burnTime = 0;
    }

    public String print(){
        String printed = "E";
        if (type == "tree"){
            printed = new String(Character.toChars(0x0001F332));
        } else if (type == "fire") {
            printed = new String(Character.toChars(0x0001F525));
        } else if (type == "burned") {
            printed = "\u2592\u2592";
        }
        return printed;
    }

    public void fireForceSpread() {
        nextStepType = "fire";
    }

    public void fireSpread() {
        if (type == "tree") {
            int random = (int)(Math.random() * 10 + 1);
            if (random % 2 == 0) nextStepType = "fire";
        }
    }

    public boolean isBurning(){
        return (type == "fire");
    }

    public void step(){
        if (nextStepType != ""){
            type = nextStepType;
            nextStepType = "";
        }
        if (type == "fire") burnTime++;
        if (burnTime == 3) type = "burned";
    }
}

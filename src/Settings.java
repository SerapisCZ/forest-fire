import java.util.HashMap;

public final class Settings {

    public enum FOREST_TILE_TYPES {
        TREE,
        FIRE,
        BURNED
    }

    public static final HashMap<FOREST_TILE_TYPES, String> FOREST_TILES_STRINGS = new HashMap<FOREST_TILE_TYPES, String>();

    public static void init(){
        initForestTilesStrings();
    }

    private static void initForestTilesStrings(){
        FOREST_TILES_STRINGS.put(FOREST_TILE_TYPES.TREE, new String(Character.toChars(0x0001F332)));
        FOREST_TILES_STRINGS.put(FOREST_TILE_TYPES.FIRE, new String(Character.toChars(0x0001F525)));
        FOREST_TILES_STRINGS.put(FOREST_TILE_TYPES.BURNED, "\u2592\u2592");
    }
}

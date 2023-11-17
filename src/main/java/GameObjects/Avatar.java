package GameObjects;

import java.util.HashMap;

public class Avatar {
    private HashMap<Types, String> avatars;
    private final  Types[] names = {Types.WOLF, Types.BOA, Types.FOX, Types.BEAR, Types.EAGLE, Types.HORSE,
            Types.DEER, Types.RABBIT, Types.MOUSE, Types.GOAT, Types.SHEEP, Types.BOAR, Types.BUFFALO,
            Types.DUCK, Types.WORM, Types.GRASS};
    private final String[] avatarStrings = {"\uD83D\uDC3A", " \uD83D\uDC0D", " \uD83E\uDD8A", " \uD83D\uDC3B",
            " \uD83E\uDD85", "\uD83D\uDC0E", " \uD83E\uDD8C", " \uD83D\uDC07", " \uD83D\uDC01", "\uD83D\uDC10",
    " \uD83D\uDC11", " \uD83D\uDC17", " \uD83D\uDC03", " \uD83E\uDD86", "\uD83D\uDC1B", "\uD83C\uDF3F"};
    public Avatar() {
        avatars = new HashMap<>();
        for (int i = 0; i < avatarStrings.length; i++) {
           avatars.put(names[i], avatarStrings[i]);
        }
    }

    public String getAvatarStrings(Types types) {
        return avatars.get(types);
    }
}
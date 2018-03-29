package fps.game;


public class NPC {

    private static int PLAYER_TYPE = 1;
    private static int INFO_TYPE = 2;
    private static int COACH_TYPE = 3;
    private static int AGENT_TYPE = 4;

    private int type;
    private String name;

    public NPC(int type, String name, String skin) {
        this.type = type;
        this.name = name;
        this.skin = skin;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    private String skin;
}

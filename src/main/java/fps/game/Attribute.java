package fps.game;


public class Attribute {

    private String name;
    private int points;
    private String icon;

    public Attribute(String name){
        this.name = name;
        this.points = 50; // sur 100
        this.icon = Image.PATH_TO_IMG+name.toLowerCase()+".png";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", icon='" + icon + '\'' +
                '}';
    }
}

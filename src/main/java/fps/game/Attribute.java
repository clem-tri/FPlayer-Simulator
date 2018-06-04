package fps.game;


public class Attribute {

    private String name;
    private int points;
    private String icon;

    public Attribute(String name){
        this.name = name;
        this.points = 50; // sur 100
        this.icon = name.toLowerCase()+".png";
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
        if(points <= 0)
            this.points = 0;
        else if(points >= 100)
            this.points = 100;
        else
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
        return this.name+": "+this.points+"<br/>";
    }
}

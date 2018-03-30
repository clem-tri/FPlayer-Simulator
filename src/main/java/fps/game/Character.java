package fps.game;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Character {
    private String id;
    private String name;
    private String firstName;
    private int height;
    private int shirtNumber;
    private List<Attribute> attributesList;
    private String skin;
    private Club club;
    private int mood;
    private int energy;
    private int hunger;
    private Date last_updated;
    @Override
    public String toString() {
        String newLine = System.getProperty("line.separator");

        return "<html>"+name+"<br/>"+firstName +"<br/>"+"Moral: "+mood+"<br/>"+"Faim: "+hunger+"<br/>"+"Energie: "+energy+"</html>";
    }

    public Character(String name, String firstName, int height, int shirtNumber, String skin) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.firstName = firstName;
        this.height = height;
        this.shirtNumber = shirtNumber;
        this.skin = skin;
        this.mood = 100;
        this.hunger = 100;
        this.energy = 100;

        this.attributesList = new ArrayList<Attribute>();
        this.attributesList.add(new Attribute("Vitesse"));
        this.attributesList.add(new Attribute("Passe"));
        this.attributesList.add(new Attribute("Physique"));
        this.attributesList.add(new Attribute("Tir"));


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public List<Attribute> getAttributesList() {
        return attributesList;
    }

    public void setAttributesList(List<Attribute> attributesList) {
        this.attributesList = attributesList;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }



}

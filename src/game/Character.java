package game;

import java.util.List;

public class Character {
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

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", height=" + height +
                ", shirtNumber=" + shirtNumber +
                ", attributesList=" + attributesList +
                ", skin='" + skin + '\'' +
                ", club=" + club +
                ", mood=" + mood +
                ", energy=" + energy +
                ", hunger=" + hunger +
                '}';
    }

    public Character(String name, String firstName, int height, int shirtNumber, List<Attribute> attributesList, String skin) {
        this.name = name;
        this.firstName = firstName;
        this.height = height;
        this.shirtNumber = shirtNumber;
        this.attributesList = attributesList;
        this.skin = skin;
        this.mood = 100;
        this.hunger = 100;
        this.energy = 100;
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

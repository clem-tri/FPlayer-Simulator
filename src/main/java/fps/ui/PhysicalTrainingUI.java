package fps.ui;

import fps.game.Character;

import javax.swing.*;
import java.awt.*;

public class PhysicalTrainingUI extends CustomUI {

    private JPanel mainPanel;
    private JPanel contentPanel;
    private JPanel titlePanel;
    private JProgressBar energyBar;
    private JProgressBar hungerBar;
    private JProgressBar moodBar;
    private JProgressBar vitesseBar;
    private JProgressBar passeBar;
    private JProgressBar physiqueBar;
    private JProgressBar tirBar;
    private JPanel menuBtnPanel;
    private JButton retourButton;

    public PhysicalTrainingUI(Character currentCharacter){
        super(currentCharacter);


        setSize(800, 500);
        setTitle("Football Player Simulator - Physique");

        this.setCurrentCharacter(currentCharacter);

        setStatsBars();

        // important!
        setLayout(new GridBagLayout());
        add(mainPanel);

        setResizable(false);
        setLocationRelativeTo(null);

        setVisible(true);


    }


    private void setStatsBars(){
        energyBar.setValue(this.getCurrentCharacter().getEnergy());

        hungerBar.setValue(this.getCurrentCharacter().getHunger());

        moodBar.setValue(this.getCurrentCharacter().getMood());

        //Attributes
        vitesseBar.setValue(this.getCurrentCharacter().getAttributesList().get(0).getPoints());
        passeBar.setValue(this.getCurrentCharacter().getAttributesList().get(1).getPoints());
        physiqueBar.setValue(this.getCurrentCharacter().getAttributesList().get(2).getPoints());
        tirBar.setValue(this.getCurrentCharacter().getAttributesList().get(3).getPoints());


    }
}

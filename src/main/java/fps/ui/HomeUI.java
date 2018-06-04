package fps.ui;


import fps.game.Attribute;
import fps.game.Character;
import fps.game.Image;
import fps.utils.JsonSaveManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HomeUI extends CustomUI {

    private Character currentCharacter;

    private JPanel mainPanel;
    private JPanel contentPanel;
    private JLabel jlbCharacterInfo;
    private JButton passesButton;
    private JButton physiqueButton;
    private JButton vitesseButton;
    private JButton tirsButton;
    private JButton menuButton;
    private JPanel menuBtnPanel;
    private JButton seReposerButton;
    private JButton mangerButton;
    private JPanel titlePanel;
    private JProgressBar energyBar;
    private JProgressBar hungerBar;
    private JProgressBar moodBar;
    private JProgressBar vitesseBar;
    private JProgressBar passeBar;
    private JProgressBar physiqueBar;
    private JProgressBar tirBar;
    private JLabel jlbAttributes;

    public HomeUI(Character currentCharacter){
        super(currentCharacter);
        setSize(1000, 500);
        setTitle("Football Player Simulator");
        Image wallpaper = new Image("menu_wp.jpg");
        setContentPane(new JLabel(new ImageIcon((wallpaper.getImage()))));

        menuButton.addActionListener(retour());
        passesButton.addActionListener(passesUI());
        tirsButton.addActionListener(tirsUI());
        seReposerButton.addActionListener(seReposer());
        mangerButton.addActionListener(manger());

        this.setCurrentCharacter(currentCharacter);
        //jlbCharacterInfo.setText(this.getCurrentCharacter().toString());
        //jlbAttributes.setText(this.getCurrentCharacter().getAttributesListToString());
        this.setStatsBars();


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


    private ActionListener retour() {
        return (ActionEvent e) -> {
            this.dispose();
            new MenuUI();
        };
    }


    private ActionListener seReposer() {
        return (ActionEvent e) -> {

            this.getCurrentCharacter().setEnergy(this.getCurrentCharacter().getEnergy()+40);
            this.getCurrentCharacter().setHunger(this.getCurrentCharacter().getHunger()+30);

            for (Attribute a: this.getCurrentCharacter().getAttributesList()
                 ) {
                a.setPoints(a.getPoints()-5);
            }

            this.setStatsBars();
            saveCharacterJson();
            String message = "\n Faim: +30" +
                    "\n Energie: +40" +
                    "\n Tir: -5" +
                    "\n Physique: -5" +
                    "\n Vitesse: -5" +
                    "\n Passe: - 5";
            JOptionPane.showMessageDialog(this, message  , "",
                    JOptionPane.INFORMATION_MESSAGE);
        };
    }

    private ActionListener manger(){
        return (ActionEvent e) -> {
            this.getCurrentCharacter().setHunger(this.getCurrentCharacter().getHunger()- 40);
            for (Attribute a: this.getCurrentCharacter().getAttributesList()
                    ) {
                a.setPoints(a.getPoints()-5);
            }

            this.setStatsBars();
            saveCharacterJson();
            String message = "\n Faim: -40"+
                    "\n Tir: -5" +
                    "\n Physique: -5" +
                    "\n Vitesse: -5" +
                    "\n Passe: - 5";
            JOptionPane.showMessageDialog(this, message  , "",
                    JOptionPane.INFORMATION_MESSAGE);
        };
    }

    private ActionListener passesUI(){
        return (ActionEvent e) -> {
            this.dispose();
            new PassTrainingUI(this.getCurrentCharacter());
        };
    }

    private ActionListener tirsUI(){
        return (ActionEvent e) -> {
            this.dispose();
            new ShootTrainingUI(this.getCurrentCharacter());
        };
    }

    private void saveCharacterJson(){
        JsonSaveManager jsonSaveManager = new JsonSaveManager();
        try {
            jsonSaveManager.createSave(getCurrentCharacter());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

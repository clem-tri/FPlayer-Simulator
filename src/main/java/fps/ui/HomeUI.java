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
import java.util.ArrayList;

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
    private JButton rejoindreUnClubButton;
    private JLabel jlbAttributes;
    private ArrayList<JButton> trainingButtons;

    public HomeUI(Character currentCharacter){
        super(currentCharacter);
        setSize(1000, 500);


        menuButton.addActionListener(retour());
        passesButton.addActionListener(passesUI());
        physiqueButton.addActionListener(physiqueUI());
        tirsButton.addActionListener(tirsUI());
        vitesseButton.addActionListener(courirUI());
        seReposerButton.addActionListener(seReposer());
        mangerButton.addActionListener(manger());

        this.setCurrentCharacter(currentCharacter);

        if(this.getCurrentCharacter().getClub() == null){
            boolean rejoindreClub = false;
            for (Attribute a: this.getCurrentCharacter().getAttributesList()) {
                rejoindreClub = a.getPoints() >= 60;
                if(!rejoindreClub)
                    break;
            }

            if(rejoindreClub){
                rejoindreUnClubButton.setEnabled(true);
                rejoindreUnClubButton.addActionListener(rejoindreClubUI());
            }

            else{
                rejoindreUnClubButton.setEnabled(false);
                rejoindreUnClubButton.setToolTipText("<html><b>Vous devez avoir 60 points dans tous vos attributs.</b></html>");
            }

        }
        else
            rejoindreUnClubButton.setVisible(false);

        this.trainingButtons = new ArrayList<JButton>() {{
            add(passesButton);
            add(physiqueButton);
            add(tirsButton);
            add(vitesseButton);
        }};

        this.disableTrainings();
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


    private void disableTrainings(){
        if(getCurrentCharacter().getEnergy() == 0 || getCurrentCharacter().getMood() == 0 || getCurrentCharacter().getHunger() == 100){
            for (JButton jb: this.trainingButtons
                 ) {
                jb.setEnabled(false);
                jb.setToolTipText("Votre Energie/Faim/Humeur est trop faible");
            }
        }
        else{
            for (JButton jb: this.trainingButtons
                    ) {
                jb.setEnabled(true);
            }
        }


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
            this.disableTrainings();
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
            this.disableTrainings();
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
           /* this.dispose();
            new PassTrainingUI(this.getCurrentCharacter());*/
           JOptionPane.showMessageDialog(this,"A venir...", "Indisponible", JOptionPane.INFORMATION_MESSAGE);
        };
    }

    private ActionListener physiqueUI(){
        return (ActionEvent e) -> {
          /*  this.dispose();
            new PhysicalTrainingUI(this.getCurrentCharacter());*/
            JOptionPane.showMessageDialog(this,"A venir...", "Indisponible", JOptionPane.INFORMATION_MESSAGE);
        };
    }

    private ActionListener tirsUI(){
        return (ActionEvent e) -> {
            this.dispose();
            new ShootTrainingUI(this.getCurrentCharacter());
        };
    }


    private ActionListener courirUI(){
        return (ActionEvent e) -> {
            this.dispose();
            new RunTrainingUI(this.getCurrentCharacter());
        };
    }

    private ActionListener rejoindreClubUI(){
        return (ActionEvent e) -> {
                JOptionPane.showMessageDialog(this,"A venir...", "Indisponible", JOptionPane.INFORMATION_MESSAGE);
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

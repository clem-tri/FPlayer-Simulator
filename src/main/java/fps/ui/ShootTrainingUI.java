package fps.ui;

import fps.game.Attribute;
import fps.game.Character;
import fps.game.Image;
import fps.utils.JsonSaveManager;
import org.w3c.dom.Attr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ShootTrainingUI extends CustomUI {

    private Character currentCharacter;

    private JPanel mainPanel;
    private JPanel menuBtnPanel;
    private JButton retourButton;
    private JPanel contentPanel;
    private JPanel titlePanel;
    private JProgressBar energyBar;
    private JProgressBar hungerBar;
    private JProgressBar moodBar;
    private JProgressBar vitesseBar;
    private JProgressBar passeBar;
    private JProgressBar physiqueBar;
    private JProgressBar tirBar;
    private JButton upLeftChoice;
    private JButton upRightChoice;
    private JButton downRightChoice;
    private JButton downLeftChoice;
    private int resultat = 0;
    private int essais = 0;
    private JLabel goalKeeper = new JLabel();


    public ShootTrainingUI(Character currentCharacter){

        super(currentCharacter);
        setSize(800, 500);
        setTitle("Football Player Simulator - Tirs");
        Image wallpaper = new Image("shoot/goals.png");
        setContentPane(new JLabel(new ImageIcon((wallpaper.getImage()))));
        this.setCurrentCharacter(currentCharacter);
        this.setStatsBars();


        // Content Panel
        this.contentPanel.setLayout(null);
        this.contentPanel.add(this.goalKeeper);
        // Goalkeeper IMG
        this.setGoalkeeperImg("shoot/gk_standing.png", 340, 100,100, 152);


            // Button choice up-left
        this.upLeftChoice = new JButton("X");
        this.upLeftChoice.addActionListener(shot());
        contentPanel.add(upLeftChoice);
        this.upLeftChoice.setBounds(220,110, 50, 40);
            // Button choice down-left
        this.downLeftChoice = new JButton("X");
        this.downLeftChoice.addActionListener(shot());
        contentPanel.add(downLeftChoice);
        this.downLeftChoice.setBounds(220,200, 50, 40);
            // Button choice up-right
        this.upRightChoice = new JButton("X");
        this.upRightChoice.addActionListener(shot());
        contentPanel.add(upRightChoice);
        this.upRightChoice.setBounds(500,110, 50, 40);
            // Button choice down-left
        this.downRightChoice = new JButton("X");
        this.downRightChoice.addActionListener(shot());
        contentPanel.add(downRightChoice);
        this.downRightChoice.setBounds(500,200, 50, 40);



        this.retourButton.addActionListener(home());
        // important!
        setLayout(new GridBagLayout());
        add(mainPanel);

        setResizable(false);
        setLocationRelativeTo(null);

        setVisible(true);
    }



    private void setGoalkeeperImg(String pathToImg, int boundX, int boundY, int scaleW, int scaleH){
        ImageIcon goalkeeperImg = new ImageIcon(new Image(pathToImg).getImage());
        java.awt.Image gkImage = goalkeeperImg.getImage();
        gkImage = gkImage.getScaledInstance(scaleW,scaleH, java.awt.Image.SCALE_SMOOTH);
        goalkeeperImg = new ImageIcon(gkImage);
        this.goalKeeper.setIcon(goalkeeperImg);
        this.goalKeeper.setBounds(boundX,boundY,goalKeeper.getPreferredSize().width, goalKeeper.getPreferredSize().height);
    }


    private ActionListener home() {
        return (ActionEvent e) -> {
            this.dispose();
            new HomeUI(this.getCurrentCharacter());
        };
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

    private ActionListener shot(){


        return (ActionEvent e) -> {

            int min = 1;
            int max = 4;
            int range = (max - min) + 1;
            int random = (int)(Math.random() * range) + min;
            int choice = 0;
            this.essais += 1;
            this.retourButton.setEnabled(false);

            if(e.getSource() == this.upLeftChoice){
                 choice = 1;
            }
            else if(e.getSource() == this.downLeftChoice){
                 choice = 2;
            }
            else if(e.getSource() == this.upRightChoice){
                 choice = 3;
            }
            else if(e.getSource() == this.downRightChoice){
                 choice = 4;
            }

            JLabel resultLabel = new JLabel();

            if(choice == random){
                resultLabel.setText("✘");
                resultLabel.setForeground(Color.RED);
            }

            else{
                this.resultat += 1;
                resultLabel.setText("✔");
                resultLabel.setForeground(Color.GREEN);
            }


            this.contentPanel.add(resultLabel);
            resultLabel.setBounds(280 + (20 * this.essais) ,50, 20, 20);


            //changement image du gardien
                switch (random){
                    case 1:
                        this.setGoalkeeperImg("shoot/gk_upleft.png",  220, 100,208, 152);
                        break;
                    case 2:
                        this.setGoalkeeperImg("shoot/gk_downleft.png",220, 195,210, 92);
                        break;
                    case 3:
                        this.setGoalkeeperImg("shoot/gk_upright.png", 350, 100,208, 152);
                        break;
                    case 4:
                        this.setGoalkeeperImg("shoot/gk_downright.png",340, 195,210, 92);
                        break;

                }



            if(essais == 10){

                for (Component c: this.contentPanel.getComponents()) {
                    if(c instanceof JButton)
                        if(c != this.retourButton)
                            c.setEnabled(false);
                }

                this.setGoalkeeperImg("shoot/gk_standing.png", 340, 100,100, 152);
                    

                String message ="Vous avez fait un score de "+this.resultat+"/10 tirs" +
                        "\n Energie:  -10" +
                        "\n Faim: +10" +
                        "\n Tir: +"+this.resultat +
                        "\n Moral: +"+this.resultat;


                this.getCurrentCharacter().setEnergy(this.getCurrentCharacter().getEnergy() - 10);
                this.getCurrentCharacter().setHunger(this.getCurrentCharacter().getHunger() + 10);
                this.getCurrentCharacter().setMood(this.getCurrentCharacter().getMood() + this.resultat);
                Attribute atrTir = this.getCurrentCharacter().getAttributesList().get(3);
                atrTir.setPoints(atrTir.getPoints()+this.resultat);
                this.setStatsBars();

                JOptionPane.showMessageDialog(this, message  , "",
                        JOptionPane.INFORMATION_MESSAGE);

                this.retourButton.setEnabled(true);
            }


        };
    }
}

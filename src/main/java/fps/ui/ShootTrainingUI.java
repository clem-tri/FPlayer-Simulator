package fps.ui;

import fps.game.Character;
import fps.game.Image;
import fps.utils.JsonSaveManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ShootTrainingUI extends CustomUI {

    private Character currentCharacter;

    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel jlbCharacterInfo;
    private JPanel menuBtnPanel;
    private JButton retourButton;
    private JPanel contentPanel;
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
        Image wallpaper = new Image("goals.png");
        setContentPane(new JLabel(new ImageIcon((wallpaper.getImage()))));
        this.setCurrentCharacter(currentCharacter);
        this.jlbCharacterInfo.setText(this.getCurrentCharacter().toString());


        // Content Panel
        this.contentPanel.setLayout(null);
        this.contentPanel.add(this.goalKeeper);
        // Goalkeeper IMG
        this.setGoalkeeperImg("shoot/gk_standing.png", 340, 55,100, 152);


            // Button choice up-left
        this.upLeftChoice = new JButton("X");
        this.upLeftChoice.addActionListener(shot());
        contentPanel.add(upLeftChoice);
        this.upLeftChoice.setBounds(220,70, 50, 40);
            // Button choice down-left
        this.downLeftChoice = new JButton("X");
        this.downLeftChoice.addActionListener(shot());
        contentPanel.add(downLeftChoice);
        this.downLeftChoice.setBounds(220,150, 50, 40);
            // Button choice up-right
        this.upRightChoice = new JButton("X");
        this.upRightChoice.addActionListener(shot());
        contentPanel.add(upRightChoice);
        this.upRightChoice.setBounds(500,70, 50, 40);
            // Button choice down-left
        this.downRightChoice = new JButton("X");
        this.downRightChoice.addActionListener(shot());
        contentPanel.add(downRightChoice);
        this.downRightChoice.setBounds(500,150, 50, 40);



        this.retourButton.addActionListener(home());
        // important!
        setLayout(new GridBagLayout());
        add(mainPanel);

        setResizable(false);
        setLocationRelativeTo(null);

        setVisible(true);
    }




    private Character getCurrentCharacter(){
        return  this.currentCharacter;
    }

    private void setCurrentCharacter(Character c){
        this.currentCharacter = c;
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

    private ActionListener shot(){


        return (ActionEvent e) -> {

            int min = 1;
            int max = 4;
            int range = (max - min) + 1;
            int random = (int)(Math.random() * range) + min;
            int choice = 0;
            this.essais += 1;

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
            resultLabel.setBounds(280 + (20 * this.essais) ,0, 20, 20);


            //changement image du gardien
                if(random == 1){
                    this.setGoalkeeperImg("shoot/gk_upleft.png",  220, 55,208, 152);
                }
                else if(random == 2){
                    this.setGoalkeeperImg("shoot/gk_downleft.png",220, 150,210, 92);
                }
                else if(random == 3){
                    this.setGoalkeeperImg("shoot/gk_upright.png", 350, 55,208, 152);
                }
                else if(random == 4){
                    this.setGoalkeeperImg("shoot/gk_downright.png",340, 150,210, 92);
                }



            if(essais == 10){

                for (Component c: this.contentPanel.getComponents()) {
                    if(c instanceof JButton)
                        if(c != this.retourButton)
                            c.setEnabled(false);
                }

                this.setGoalkeeperImg("shoot/gk_standing.png", 340, 55,100, 152);
                    

                String message ="Vous avez fait un score de "+this.resultat+"/10 tirs" +
                        "\n Energie:  -10";

                this.getCurrentCharacter().setEnergy(this.getCurrentCharacter().getEnergy() - 10);
                jlbCharacterInfo.setText(this.getCurrentCharacter().toString());
                JOptionPane.showMessageDialog(this, message  , "",
                        JOptionPane.WARNING_MESSAGE);
            }


        };
    }
}

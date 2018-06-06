package fps.ui;

import fps.game.Attribute;
import fps.game.Character;
import fps.game.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class RunTrainingUI extends CustomUI implements KeyListener{
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
    private JButton commencerButton;
    private JLabel secondsLbl;
    private JLabel leftArrow;
    private JLabel rightArrow;
    private JProgressBar scoreBar;
    private ArrayList<Integer> keysPressed;
    static int interval = 11;
    static int countdownDuration = 3;
    static Timer timer;
    private Image leftArrowImg;
    private Image rightArrowImg;
    private Image crossImg;

    public RunTrainingUI(Character currentCharacter) {
        super(currentCharacter);

        this.keysPressed = new ArrayList<>();

        setSize(800, 500);
        setTitle("Football Player Simulator - Vitesse");
        this.setCurrentCharacter(currentCharacter);
        this.setStatsBars();
        commencerButton.addActionListener(startTimer());
        retourButton.addActionListener(back());

         leftArrowImg = new Image("run/leftarrow.png");

         rightArrowImg = new Image("run/rightarrow.png");

         crossImg = new Image("run/cross.png");




        // important!
        setLayout(new GridBagLayout());
        add(mainPanel);

        setResizable(false);
        setLocationRelativeTo(null);

        setVisible(true);
        addKeyListener(this);
        JOptionPane.showMessageDialog(this,
                "Pour débuter, cliquez sur Commencer, attendez la fin du décompte jusqu'à 3, " +
                        "\npuis appuyez le plus de fpos possible sur les touches fléchées gauche et droite en 10 secondes",
                "Instructions",
                JOptionPane.INFORMATION_MESSAGE);


        setFocusable(true);

    }

    private ActionListener back(){
        return (ActionEvent e) -> {
            this.dispose();
            new HomeUI(this.getCurrentCharacter());
        };
    }



    private ActionListener startTimer(){
        return (ActionEvent e) -> {
            commencerButton.setEnabled(false);
            interval = 11;
            countdownDuration = 3;
            int delay = 1000;
            int period = 1000;


            Timer countdown = new Timer();
            countdown.scheduleAtFixedRate(new TimerTask(){
                public void run() {
                    if(countdownDuration == 1){
                        countdown.cancel();


                        requestFocus();

                        timer = new Timer();
                        timer.scheduleAtFixedRate(new TimerTask() {
                            public void run(){
                                customRun();
                            }
                        }, delay, period);
                    }
                    else
                        secondsLbl.setText(String.valueOf(--countdownDuration));



                }
            },delay,period);

            //




        };

    }

    private static String setInterval() {
        if (interval == 1)
            timer.cancel();
       return String.valueOf(--interval);

    }

    private void customRun() {
        secondsLbl.setText(setInterval());
        if(interval == 0) {
            int points = keysPressed.size()/10;
            Attribute vitesseAtr = this.getCurrentCharacter().getAttributesList().get(0);
            vitesseAtr.setPoints(vitesseAtr.getPoints()+points);

            this.getCurrentCharacter().setMood(this.getCurrentCharacter().getMood()+points);
            this.getCurrentCharacter().setEnergy(this.getCurrentCharacter().getEnergy()-20);
            this.getCurrentCharacter().setHunger(this.getCurrentCharacter().getHunger()+20);
            this.getCurrentCharacter().setMood(this.getCurrentCharacter().getMood()+points);

            this.setStatsBars();

            String message = "Résultat : "+keysPressed.size()
                    + "\nVitesse: +"+String.valueOf(points)
                    + "\nEnergie: -20"
                    +"\nFaim: +20"
                    +"\nMoral: +"+String.valueOf(points);
            JOptionPane.showMessageDialog(this, message,"Score",JOptionPane.INFORMATION_MESSAGE);
        }




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


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(interval > 0 && interval < 11) {

            if(e.getKeyCode() == 37 || e.getKeyCode() == 39){

                if(!this.keysPressed.isEmpty()){

                    if(this.keysPressed.get(this.keysPressed.size()-1) != e.getKeyCode()){
                        if(e.getKeyCode() == 37)
                            leftArrow.setIcon(new ImageIcon(leftArrowImg.getImage()));
                        else
                            rightArrow.setIcon(new ImageIcon(rightArrowImg.getImage()));
                        this.keysPressed.add(e.getKeyCode());

                    }
                    else{
                        if(e.getKeyCode() == 37)
                            leftArrow.setIcon(new ImageIcon(crossImg.getImage()));
                        else
                            rightArrow.setIcon(new ImageIcon(crossImg.getImage()));
                    }
                }
                else
                    this.keysPressed.add(e.getKeyCode());

                this.scoreBar.setValue(this.keysPressed.size());

            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 37)
            leftArrow.setIcon(null);
        else if(e.getKeyCode() == 39)
            rightArrow.setIcon(null);
    }
}

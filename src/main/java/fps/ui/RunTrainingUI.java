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
    private ArrayList<Integer> keysPressed;
    static int interval = 10;
    static Timer timer;

    public RunTrainingUI(Character currentCharacter) {
        super(currentCharacter);

        this.keysPressed = new ArrayList<Integer>();

        setSize(800, 500);
        setTitle("Football Player Simulator - Vitesse");
        this.setCurrentCharacter(currentCharacter);
        this.setStatsBars();
        commencerButton.addActionListener(startTimer());




        // important!
        setLayout(new GridBagLayout());
        add(mainPanel);

        setResizable(false);
        setLocationRelativeTo(null);

        setVisible(true);
        addKeyListener(this);
        JOptionPane.showMessageDialog(this,
                "Pour débuter, cliquez sur Commencer puis appuyez le plus rapidement possible sur les touches fléchées gauche et droite",
                "Instructions",
                JOptionPane.INFORMATION_MESSAGE);


        setFocusable(true);









    }



    private ActionListener startTimer(){
        return (ActionEvent e) -> {
            this.commencerButton.setEnabled(false);
            this.requestFocus();
            int delay = 1000;
            int period = 1000;
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run(){
                   customRun();
                }
            }, delay, period);


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

            String message = "Résultats : "+keysPressed.size()
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

        if(interval > 0) {

            if(e.getKeyCode() == 37 || e.getKeyCode() == 39){

                if(!this.keysPressed.isEmpty()){

                    if(this.keysPressed.get(this.keysPressed.size()-1) != e.getKeyCode()){

                        this.keysPressed.add(e.getKeyCode());

                    }
                }
                else
                    this.keysPressed.add(e.getKeyCode());

            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

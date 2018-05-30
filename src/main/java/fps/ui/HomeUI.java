package fps.ui;


import fps.game.Character;
import fps.game.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUI extends JFrame {

    private Character currentCharacter;

    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel contentPanel;
    private JLabel jlbCharacterInfo;
    private JButton passesButton;
    private JButton physiqueButton;
    private JButton vitesseButton;
    private JButton tirsButton;
    private JButton menuButton;
    private JPanel menuBtnPanel;

    public HomeUI(Character currentCharacter){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setTitle("Football Player Simulator");
        Image wallpaper = new Image("menu_wp.jpg");
        setContentPane(new JLabel(new ImageIcon((wallpaper.getImage()))));
        menuButton.addActionListener(back());
        passesButton.addActionListener(passesUI());
        tirsButton.addActionListener(tirsUI());
        this.setCurrentCharacter(currentCharacter);
        jlbCharacterInfo.setText(this.getCurrentCharacter().toString());
        // important!
        setLayout(new GridBagLayout());
        add(mainPanel);

        setResizable(false);
        setLocationRelativeTo(null);

        setVisible(true);

    }
    private ActionListener back() {
        return (ActionEvent e) -> {
            this.dispose();
            new MenuUI();
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



    private Character getCurrentCharacter(){
        return  this.currentCharacter;
    }

    private void setCurrentCharacter(Character c){
        this.currentCharacter = c;
    }

}

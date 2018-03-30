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
        jlbCharacterInfo.setText(currentCharacter.toString());
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



    private Character getCurrentCharacter(){
        return  this.currentCharacter;
    }

    public void setCurrentCharacter(Character c){
        this.currentCharacter = c;
    }

}

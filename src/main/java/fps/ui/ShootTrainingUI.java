package fps.ui;

import fps.game.Character;
import fps.game.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShootTrainingUI extends JFrame {

    private Character currentCharacter;

    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel jlbCharacterInfo;
    private JPanel menuBtnPanel;
    private JButton retourButton;
    private JPanel contentPanel;


    public ShootTrainingUI(Character currentCharacter){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setTitle("Football Player Simulator - Tirs");
        Image wallpaper = new Image("goals.png");
        setContentPane(new JLabel(new ImageIcon((wallpaper.getImage()))));
        this.setCurrentCharacter(currentCharacter);
        jlbCharacterInfo.setText(this.getCurrentCharacter().toString());

        retourButton.addActionListener(home());
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


    private ActionListener home() {
        return (ActionEvent e) -> {
            this.dispose();
            new HomeUI(this.getCurrentCharacter());
        };
    }
}

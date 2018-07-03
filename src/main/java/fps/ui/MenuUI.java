package fps.ui;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fps.game.Image;

public class MenuUI extends JFrame {
    private JPanel mainPanel;
    private JPanel buttonsPanel;
    private JButton nouvellePartieButton;
    private JButton chargerPartieButton;
    private JButton quitterButton;

    public MenuUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setTitle("Football Player Simulator");
        Image wallpaper = new Image("menu_wp.jpg");
        setContentPane(new JLabel(new ImageIcon((wallpaper.getImage()))));
        Image icon = new Image("icon.png");
        setIconImage(new ImageIcon(icon.getImage()).getImage());
        // important!
        setLayout(new GridBagLayout());
        //
        buttonsPanel.setOpaque(false);
        mainPanel.setOpaque(false);

        nouvellePartieButton.addActionListener(newGame());
        chargerPartieButton.addActionListener(loadGame());
        quitterButton.addActionListener(quit());

        add(mainPanel);

        setResizable(false);
        setLocationRelativeTo(null);

        setVisible(true);

    }



    private ActionListener newGame() {
        return (ActionEvent e) -> {
            this.dispose();
            new CreateGameUI();
        };
    }

    private ActionListener loadGame(){
        return (ActionEvent e) -> {
            this.dispose();
            new LoadGameUI();
        };
    }

    private ActionListener quit() {
        return e -> System.exit(0);
    }

}

package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JFrame {

    private static final String PATH_TO_IMG = System.getProperty("user.dir")+"\\resources\\";

    public void start(){

        setSize(400,200);
        setTitle("Football Player Simulator - Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon(PATH_TO_IMG+"menu_wp.jpg")));

        JPanel flow_panel = new JPanel( new FlowLayout ());
        JPanel border_panel = new JPanel( new BorderLayout ());

        // title
        JLabel title = new JLabel("Football Player Simulator");
        title.setFont(new Font("Poplar Std",Font.PLAIN,30));;
        title.setForeground(Color.ORANGE);
        // buttons and actions
        JButton btnNewGame = new JButton("Nouvelle partie");
        JButton btnLoadGame = new JButton("Charger partie");
        JButton btnQuit = new JButton("Quitter");

        btnNewGame.addActionListener(newGame(this));
        btnQuit.addActionListener(quit());

        flow_panel.setOpaque(false);
        flow_panel.add(title);

        border_panel.add(btnNewGame,BorderLayout.NORTH);
        border_panel.add(btnLoadGame,BorderLayout.CENTER);
        border_panel.add(btnQuit, BorderLayout.SOUTH);
        setLayout(new FlowLayout ());
        add(flow_panel);
        add(border_panel);
        setResizable(false);
        setVisible(true);

    }


    private ActionListener quit(){
        return e -> System.exit(0);
    }

    private ActionListener newGame(JFrame currentFrame){
        return (ActionEvent e) -> {
            currentFrame.setVisible(false);
            CreateGameUI cpUI = new CreateGameUI();
            cpUI.start();
        };
    }


}

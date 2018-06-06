package fps.ui;


import fps.game.Character;
import fps.game.Image;
import fps.utils.JsonSaveManager;
import fps.utils.SavesRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadGameUI extends JFrame {
    private JPanel mainPanel;
    private JPanel savesPanel;
    private JList<Character> savesList;
    private JButton chargerButton;
    private JButton retourButton;


    public LoadGameUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setTitle("Football Player Simulator - Charger partie");
        Image wallpaper = new Image("menu_wp.jpg");
        JsonSaveManager jsonSaveManager = new JsonSaveManager();
        DefaultListModel<Character> files = jsonSaveManager.loadSavesFiles();
        setContentPane(new JLabel(new ImageIcon((wallpaper.getImage()))));
        SavesRenderer renderer = new SavesRenderer();
        savesList.setCellRenderer(renderer);
        retourButton.addActionListener(back());
        chargerButton.addActionListener(load());
        // important!
        setLayout(new GridBagLayout());
        //
        add(mainPanel);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        if(!files.isEmpty())
            savesList.setModel(files);
        else {
            chargerButton.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Aucune sauvegarde disponible", "Infomation", JOptionPane.WARNING_MESSAGE);
        }
    }

    private ActionListener load(){
        return (ActionEvent e) -> {
            if(savesList.getSelectedValue() != null){
                this.dispose();
                new HomeUI(savesList.getSelectedValue());
            }
            else
                JOptionPane.showMessageDialog(this,"Veuillez sélectionner une sauvegarde", "Aucune sauvegarde sélectionné", JOptionPane.WARNING_MESSAGE);
        };
    }

    private ActionListener back() {
        return (ActionEvent e) -> {
            this.dispose();
            new MenuUI();
        };
    }






}

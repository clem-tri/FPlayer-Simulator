package fps.ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fps.game.Character;
import fps.game.Image;
import fps.utils.JsonSaveManager;

public class CreateGameUI extends JFrame  {
    private JPanel mainPanel;
    private JTextField nameTxtField;
    private JTextField fnameTxtField;
    private JComboBox<Integer> heightComboBox;
    private JComboBox<Integer> numComboBox;
    //TODO: sprites pour skin
    private JRadioButton rb1RadioButton;
    private JRadioButton rb2RadioButton;
    private JRadioButton rb3RadioButton;
    private JRadioButton rb4RadioButton;
    //
    private JButton buttonSubmit;
    private JPanel formPanel;
    private JButton cancelButton;


    public CreateGameUI()  {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setTitle("Football Player Simulator - Nouvelle partie");
        Image wallpaper = new Image("menu_wp.jpg");
        setContentPane(new JLabel(new ImageIcon((wallpaper.getImage()))));
        // important!
        setLayout(new GridBagLayout());
        //
        mainPanel.setOpaque(false);
        formPanel.setOpaque(false);

        for (int i = 160; i <= 210; i++) {
            heightComboBox.addItem(i);
        }

        for (int i = 1; i < 100; i++){
            numComboBox.addItem(i);
        }

        buttonSubmit.addActionListener(createPlayer());
        cancelButton.addActionListener(cancel());

        add(mainPanel);


        setResizable(false);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private ActionListener cancel() {
        return (ActionEvent e) -> {
            this.dispose();
            new MenuUI();
        };
    }

    private ActionListener createPlayer()  {
        return (ActionEvent e) -> {
            try {



                String rbValue = null;
                // get rb selected value
                for (Component c : formPanel.getComponents()) {
                    if (c instanceof JRadioButton && ((JRadioButton) c).isSelected()) {
                        rbValue = ((JRadioButton) c).getText();
                    }
                }


                if(!nameTxtField.getText().isEmpty() && !fnameTxtField.getText().isEmpty() && rbValue != null) {

                    buttonSubmit.setEnabled(false);
                    cancelButton.setEnabled(false);

                    Character newC = new Character(
                            nameTxtField.getText(),
                            fnameTxtField.getText(),
                            (int) heightComboBox.getSelectedItem(),
                            (int) numComboBox.getSelectedItem(),
                            rbValue);


                    JsonSaveManager jsonSaveManager = new JsonSaveManager();
                    jsonSaveManager.createSave(newC);

                    JOptionPane.showMessageDialog(this, "Partie créée");
                    this.dispose();
                    new HomeUI(newC);

                }
                else{
                    JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs!", "Champ(s) vide(s)",
                            JOptionPane.WARNING_MESSAGE);
                }


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }


        };
    }


}

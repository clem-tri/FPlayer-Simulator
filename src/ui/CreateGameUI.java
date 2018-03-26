package ui;

import game.Attribute;
import game.Character;
import game.Image;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateGameUI extends JFrame {
    private JPanel mainPanel;
    private JTextField nameTxtField;
    private JTextField fnameTxtField;
    private JFormattedTextField heightTxtField;
    private JFormattedTextField numTxtField;
    //TODO: sprites pour skin
    private JRadioButton rb1RadioButton;
    private JRadioButton rb2RadioButton;
    private JRadioButton rb3RadioButton;
    private JRadioButton rb4RadioButton;
    //
    private JButton buttonSubmit;
    private JPanel formPanel;
    private JButton cancelButton;


    public CreateGameUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setTitle("Football Player Simulator - Nouvelle partie");
        Image wallpaper = new Image("menu_wp.jpg");
        setContentPane(new JLabel(new ImageIcon((wallpaper.getImage()))));
        // important!
        setLayout(new GridBagLayout());
        //
        mainPanel.setOpaque(false);
        formPanel.setOpaque(false);

        // formatted text field
        NumberFormat nf = NumberFormat.getIntegerInstance();
        NumberFormatter nff = new NumberFormatter(nf);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(nff);
        heightTxtField.setFormatterFactory(factory);
        numTxtField.setFormatterFactory(factory);

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

    private ActionListener createPlayer() {
        return (ActionEvent e) -> {
            try {

                String rbValue = null;
                // get rb selected value
                for (Component c : formPanel.getComponents()) {
                    if (c instanceof JRadioButton && ((JRadioButton) c).isSelected()) {
                        rbValue = ((JRadioButton) c).getText();
                    }
                }

                List<Attribute> attributeList = new ArrayList<>();


                Character newC = new Character(
                        nameTxtField.getText(),
                        fnameTxtField.getText(),
                        Integer.parseInt(heightTxtField.getText()),
                        Integer.parseInt(numTxtField.getText()),
                        attributeList,
                        rbValue);

                JOptionPane.showMessageDialog(this, newC);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "error",
                        JOptionPane.ERROR_MESSAGE);
            }


        };
    }


}

package fps.ui;

import fps.game.Character;
import fps.utils.JsonSaveManager;

import javax.swing.*;
import java.io.IOException;

public class CustomUI extends JFrame {


    public CustomUI(Character c){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                JsonSaveManager jsonSaveManager = new JsonSaveManager();
                try {
                    jsonSaveManager.createSave(c);
                    System.exit(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}

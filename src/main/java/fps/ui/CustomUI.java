package fps.ui;

import fps.game.Character;
import fps.game.Image;
import fps.utils.JsonSaveManager;

import javax.swing.*;
import java.io.IOException;

public class CustomUI extends JFrame {

    private JsonSaveManager jsonSaveManager;
    private  Character currentCharacter;


    public CustomUI(Character c){
        setTitle("Football Player Simulator");
        Image wallpaper = new Image("menu_wp.jpg");
        Image icon = new Image("icon.png");
        setIconImage(new ImageIcon(icon.getImage()).getImage());
        setContentPane(new JLabel(new ImageIcon((wallpaper.getImage()))));


        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                jsonSaveManager = new JsonSaveManager();
                try {
                    jsonSaveManager.createSave(c);
                    System.exit(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void dispose(){
        jsonSaveManager = new JsonSaveManager();
        try {
            jsonSaveManager.createSave(this.getCurrentCharacter());
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.dispose();
    }

    public Character getCurrentCharacter() {
        return currentCharacter;
    }

    public void setCurrentCharacter(Character currentCharacter) {
        this.currentCharacter = currentCharacter;
    }
}

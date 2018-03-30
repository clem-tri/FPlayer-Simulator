package fps.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fps.game.Character;

import javax.swing.*;
import java.io.*;

public class JsonSaveManager {

    private static final String PATH_TO_SAVES = System.getProperty("user.dir")+"\\resources\\data\\save\\";

    public void createSave(Character c) throws IOException {
        checkSaveDirectory();
        FileWriter fw = new FileWriter(PATH_TO_SAVES+c.getId()+".json");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(c, fw);
        fw.close();
    }

    public DefaultListModel<Character> loadSavesFiles() {
        checkSaveDirectory();
        DefaultListModel<Character> listModelSaves = new DefaultListModel<>();
        for (final File fileEntry : new File(PATH_TO_SAVES).listFiles()) {
            if (!fileEntry.isDirectory()) {
                Gson gson = new Gson();
                try {
                    Character character = gson.fromJson(new FileReader(PATH_TO_SAVES+fileEntry.getName()), Character.class);
                    listModelSaves.addElement(character);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }

        }
        return listModelSaves;
    }

    private void checkSaveDirectory(){
        new File(PATH_TO_SAVES).mkdirs();
    }





}

package fps.utils;

import fps.game.Character;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SavesRenderer extends JLabel implements ListCellRenderer<Character> {

    private Border border;

    public SavesRenderer()
    {
        // Leave a 10-pixel separator between the flag icon and country name.

        setIconTextGap(10);

        // Swing labels default to being transparent; the container's color
        // shows through. To change a Swing label's background color, you must
        // first make the label opaque (by passing true to setOpaque()). Later,
        // you invoke setBackground(), passing the new color as the argument.

        setOpaque(true);

        // This border is placed around a cell that is selected and has focus.

        border = BorderFactory.createLineBorder(Color.RED, 1);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Character> list, Character value, int index, boolean isSelected, boolean cellHasFocus) {
       setText(value.getFirstName()+" "+value.getName());

        if (isSelected)

        {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }
        else
        {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setFont(list.getFont());

        setEnabled(list.isEnabled());


        return this;

    }
}

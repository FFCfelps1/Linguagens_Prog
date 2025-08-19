package Ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxFrame extends JFrame{
    private JComboBox imagesJComboBox;
    private JLabel label;
    private String names[] = {"gato1.gif", "gato2.gif", "gato3.gif", "gato4.gif"};

    private Icon icons[] = {
        new ImageIcon(getClass().getResource(names[0])),
        new ImageIcon(getClass().getResource(names[1])),
        new ImageIcon(getClass().getResource(names[2])),
        new ImageIcon(getClass().getResource(names[3]))
    };
    public ComboBoxFrame(){
        super("Testing JComboBox");
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(300, 300));

        imagesJComboBox = new JComboBox(names);
        imagesJComboBox.setMaximumRowCount(3);

        imagesJComboBox.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED)
                        label.setIcon(new ImageIcon(getClass().getResource(names[imagesJComboBox.getSelectedIndex()])));
                }
            }
        );

        add(imagesJComboBox);
        label = new JLabel(new ImageIcon(getClass().getResource(names[0])));
        add(label);
    }
}

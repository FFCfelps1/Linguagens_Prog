package Ex1;

import javax.swing.*;
import java.awt.*;

public class PhoneBook extends JFrame {
    JPanel background;
    JLabel label;
    JScrollPane bar;
    Object[][] data = {
            {"21014442", "João", "11 99175-8098", "joão@uol.com"},
            {"21014443", "Maria", "11 99175-8098", "maria@terra.com"},
            {"21014444", "José", "11 99175-8098", "josé@bol.com"},
            {"21014445", "Ana", "11 99175-8098", "ana@bol.com"}
    };
    String[] columns = {"RA", "Nome", "Telefone", "E-mail"};

    public PhoneBook()
    {
        super("Agenda Telefônica");
    }
    public void makeWindow(){
        background = new JPanel();
        background.setLayout(new GridLayout(1,1));
        bar = new JScrollPane(new JTable(data, columns));
        background.add(bar);
        getContentPane().add(background);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 125);
        setVisible(true);
    }
}

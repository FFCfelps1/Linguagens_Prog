import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;



public class TelaExemplo extends JFrame implements ActionListener {
    private JButton bt;
    private JTextField tx;
    private JLabel rt;
    private ResourceBundle bn = null;

    public TelaExemplo()
    {
        int op = Integer.parseInt(JOptionPane.showInputDialog("Idioma - Language - Langue - Lingua\n1-Português\n2-English\n3-Française\n4-Italiano"));

        switch(op)
        {
            case 1: bn = ResourceBundle.getBundle("ex1", Locale.of("pt", "BR")); break;
            case 2: bn = ResourceBundle.getBundle("ex1", Locale.of("en", "US")); break;
            case 3: bn = ResourceBundle.getBundle("ex1", Locale.of("fr", "FR")); break;
            case 4: bn = ResourceBundle.getBundle("ex1", Locale.of("it", "IT")); break;
            default: bn = ResourceBundle.getBundle("ex1"); break;
        }

        //Ecolhe Layout do conteiner
        Container cx = getContentPane();
        cx.setLayout(new FlowLayout());
        //Instanciação dos objetos
        bt = new JButton(bn.getString("tela1.botao.calcular"));
        rt = new JLabel(bn.getString("tela1.rotulo.valor"));
        tx = new JTextField(10);
        //Inclusão no container
        cx.add(rt);
        cx.add(tx);
        cx.add(bt);
        //Registro no listener dos objetos controlados
        bt.addActionListener(this);
        //Ajustes finais do frame
        setTitle(bn.getString("tela1.titulo"));
        setSize(350,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(tx.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null,bn.getString("mensagem.valor.nulo"),bn.getString("tela1.erro.titulo"),JOptionPane.ERROR_MESSAGE);
        }else
        {
            int n = Integer.parseInt(tx.getText());
            n = n*n;
            tx.setText(""+n);
        }
    }
}

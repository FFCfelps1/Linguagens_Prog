// Exemplo de Di�logo por M�todo - Teste
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exemplo2 extends JFrame implements ActionListener
{
   // Bot�o
   JButton b;
   
   // M�todo Construtor
   public Exemplo2()
   {
      // Cria um Conteiner de Tela
      Container c = getContentPane();
   
      // Determina a tela como um FlowLayout
      c.setLayout(new FlowLayout());
      
      // Cria um Bot�o com o texto "Clique"
      b = new JButton("Clique");

      // Adiona o Bot�o no Conteiner 
      c.add(b);
      
      // Adiciona uma a��o ao Bot�o
      b.addActionListener(this);
      
      // Programa o tamanho inicial do FlowLayout em pxls
      setSize(350,75);
      
      // Determina a localiza��o inicial do FlowLayout em pxls
      setLocation(470,50);

      // Determina qual o t�tulo do FlowLayout
      setTitle("Exemplo de Di�logo (M�todo)");
      
      // Estabelece que o FlowLayout ser� vis�vel inicialmente    
      setVisible(true);
   }

   // M�todo de tratamento do evento da a��o do bot�o
   public void actionPerformed(ActionEvent e)
   {
      // Verifica se o evento pertence ao bot�o
      if(e.getSource() == b)
      {
         // Apresenta o atributo valor (de Dialogo)
         JOptionPane.showMessageDialog(null,"Valor Digitado:"+Dialogo2.getValor(this));
     }
   }
      
   // M�todo Principal
   public static void main(String args[])
   {
      // Instancia um objeto de Exemplo
      Exemplo2 prog = new Exemplo2();
      
      // Programa encerramento do Frame no Sair (X)
      prog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}

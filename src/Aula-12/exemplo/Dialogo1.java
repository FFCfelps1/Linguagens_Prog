// Exemplo de Di�logo por Instancia��o
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialogo1 extends JDialog implements ActionListener
{
   // R�tulo
   JLabel lb;
   
   // Campo Texto
   JTextField tf;
   
   // Bot�o
   JButton bt;
   
   // Atributo de valor
   int valor;
  
   // M�todo Construtor
   public Dialogo1(JFrame fr)
   {
      // Invoca o m�todo construtor da superclasse
      super(fr, true);
   
      // Cria um Conteiner de Tela
      Container cp = getContentPane();
      
      // Determina a tela como um FlowLayout
      cp.setLayout(new FlowLayout());
    
      // Cria um R�tulo com o texto "Valor"
      lb = new JLabel("Valor:");
      
      // Adiciona o R�tulo no Conteiner
      cp.add(lb);
            
      // Cria um Campo Texto de largura 10 pxls 
      tf = new JTextField(10);
      
      // Adiciona o Campo Texto no Conteiner
      cp.add(tf);
      
      // Cria um Bot�o com o texto "OK"
      bt = new JButton ("OK");
     
      // Adiona o Bot�o no Conteiner 
      cp.add(bt);
     
      // Adiciona uma a��o ao Bot�o
      bt.addActionListener(this);
     
      // Programa o tamanho inicial do FlowLayout em pxls
      setSize(200,100);
      
      // Determina a localiza��o inicial do FlowLayout em pxls
      setLocation(200,200);
     
      // Determina qual o t�tulo do FlowLayout
      setTitle("Valores");
      
      // Estabelece que o FlowLayout ser� vis�vel inicialmente       
      setVisible(true);
   }

   // M�todo de tratamento do evento da a��o do bot�o
   public void actionPerformed(ActionEvent e)
   {
      // Verifica se o evento pertence ao bot�o
      if (e.getSource() == bt)
      {
         // L� o valor constante no campo texto e o atribui a valor
         valor = Integer.parseInt(tf.getText());
         
         // Fecha e Libera o FlowLayout
         dispose();
      }
   }
   
   // M�todo para acessar o atributo Valor
   public int getValor()
   {
      return   valor;
   }
}


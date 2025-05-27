// CheckBoxFrame.java
// Creating JCheckBox buttons.
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame 
{
   private JTextField textField; // exibe o texto na altera��o de fontes
   private JCheckBox boldJCheckBox; // para selecionar/desselecionar negrito
   private JCheckBox italicJCheckBox; // para selecionar/desselecionar it�lico

   // construtor CheckBoxFrame adiciona JCheckBoxes ao JFrame
   public CheckBoxFrame()
   {
      super( "JCheckBox Test" );
      setLayout( new FlowLayout() ); // configura o layout de frame

      // configura JTextField e sua fonte
      textField = new JTextField( "Watch the font style change", 20 );
      textField.setFont( new Font( "Serif", Font.PLAIN, 14 ) );
      add( textField ); // adiciona textField ao JFrame

      boldJCheckBox = new JCheckBox( "Bold" ); // cria caixa de sele��o p/ negrito
      italicJCheckBox = new JCheckBox( "Italic" ); // cria it�lico
      add( boldJCheckBox ); // adiciona caixa de sele��o de negrito ao JFrame
      add( italicJCheckBox ); // adiciona caixa de sele��o de it�lico ao JFrame

      // listeners registradores para JCheckBoxes
      CheckBoxHandler handler = new CheckBoxHandler();
      boldJCheckBox.addItemListener( handler );       
      italicJCheckBox.addItemListener( handler );     
   } // fim do construtor CheckBoxFrame

   // classe interna private para tratamento de evento ItemListener
   private class CheckBoxHandler implements ItemListener
   {
      private int valBold = Font.PLAIN; // controla o estilo de fonte negrito
      private int valItalic = Font.PLAIN; // controla o estilo de fonte it�lico

      // responde aos eventos de caixa de sele��o
      public void itemStateChanged( ItemEvent event )
      {
         // processa eventos da caixa de sele��o de negrito
         if (event.getSource() == boldJCheckBox)
            valBold = 
               boldJCheckBox.isSelected()? Font.BOLD : Font.PLAIN;
               
         // processa eventos da caixa de sele��o de it�lico
         if (event.getSource() == italicJCheckBox)
            valItalic = 
               italicJCheckBox.isSelected()? Font.ITALIC : Font.PLAIN;

         // configura a fonte do campo de texto
         textField.setFont( 
            new Font( "Serif", valBold + valItalic, 14 ) );
      } // fim do m�todo itemStateChanged
   } // fim da classe CheckBoxHandler interna private
} // fim da classe CheckBoxFrame

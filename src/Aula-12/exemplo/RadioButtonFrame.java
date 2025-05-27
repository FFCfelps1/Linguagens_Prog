// RadioButtonFrame.java
// Criando bot�es de op��o utilizando ButtonGroup e JRadioButton.

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RadioButtonFrame extends JFrame 
{
   private JTextField textField; // utilizado para exibir altera��es de fonte
   private Font plainFont; // fonte para texto simples
   private Font boldFont; // fonte para texto em negrito
   private Font italicFont; // fonte para texto em it�lico
   private Font boldItalicFont; // fonte para texto em negrito e it�lico
   private JRadioButton plainJRadioButton; // seleciona texto simples
   private JRadioButton boldJRadioButton; // seleciona texto em negrito
   private JRadioButton italicJRadioButton; // seleciona texto em it�lico
   private JRadioButton boldItalicJRadioButton; // negrito e it�lico
   private ButtonGroup radioGroup; // buttongroup para armazenar bot�es de op��o

   // construtor RadioButtonFrame adiciona JRadioButtons ao JFrame
   public RadioButtonFrame()
   {
      super( "RadioButton Test" );
      setLayout( new FlowLayout() ); // configura o layout de frame

      textField = new JTextField( "Watch the font style change", 25 );
      add( textField ); // adiciona textField ao JFrame

      // cria bot�es de op��o
      plainJRadioButton = new JRadioButton( "Plain", true );            
      boldJRadioButton = new JRadioButton( "Bold", false );             
      italicJRadioButton = new JRadioButton( "Italic", false );         
      boldItalicJRadioButton = new JRadioButton( "Bold/Italic", false );
      add( plainJRadioButton ); // adiciona bot�o no estilo simples ao JFrame
      add( boldJRadioButton ); // adiciona bot�o de negrito ao JFrame
      add( italicJRadioButton ); // adiciona bot�o de it�lico ao JFrame
      add( boldItalicJRadioButton ); // adiciona bot�o de negrito e it�lico

      // cria relacionamento l�gico entre JRadioButtons
      radioGroup = new ButtonGroup(); // cria ButtonGroup
      radioGroup.add( plainJRadioButton ); // adiciona simples ao grupo
      radioGroup.add( boldJRadioButton ); // adiciona negrito ao grupo
      radioGroup.add( italicJRadioButton ); // adiciona it�lico ao grupo
      radioGroup.add( boldItalicJRadioButton ); // adiciona negrito e it�lico

      // cria fonte objetos
      plainFont = new Font( "Serif", Font.PLAIN, 14 );
      boldFont = new Font( "Serif", Font.BOLD, 14 );
      italicFont = new Font( "Serif", Font.ITALIC, 14 );
      boldItalicFont = new Font( "Serif", Font.BOLD + Font.ITALIC, 14 );
      textField.setFont( plainFont ); // configura a fonte inicial como simples
      
      // registra eventos para JRadioButtons
      plainJRadioButton.addItemListener(            
         new RadioButtonHandler( plainFont ) );     
      boldJRadioButton.addItemListener(             
         new RadioButtonHandler( boldFont ) );      
      italicJRadioButton.addItemListener(           
         new RadioButtonHandler( italicFont ) );    
      boldItalicJRadioButton.addItemListener(       
         new RadioButtonHandler( boldItalicFont ) );
   } // fim do construtor RadioButtonFrame

   // classe interna private para tratar eventos de bot�o de op��o
   private class RadioButtonHandler implements ItemListener
   {
      private Font font; // fonte associada com esse listener

      public RadioButtonHandler( Font f )
      {
         font = f; // configura a fonte desse listener
      } // fim do construtor RadioButtonHandler
           
      // trata eventos de bot�o de op��o
      public void itemStateChanged( ItemEvent event )
      {
         textField.setFont( font ); // configura fonte de textField
      } // fim do m�todo itemStateChanged
   } // fim da classe RadioButtonHandler interna private
} // fim da classe RadioButtonFrame

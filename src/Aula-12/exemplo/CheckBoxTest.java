// CheckBoxTest.java
// Testando CheckBoxFrame.

import javax.swing.JFrame;

public class CheckBoxTest
{
   public static void main( String args[] )
   { 
      CheckBoxFrame checkBoxFrame = new CheckBoxFrame(); 
      checkBoxFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      checkBoxFrame.setSize( 275, 100 ); // configura o tamanho do frame
      checkBoxFrame.setVisible( true ); // exibe o frame
   } // fim de main
} // fim da classe CheckBoxTest
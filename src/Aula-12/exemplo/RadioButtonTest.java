// RadioButtonTest.java
// Testando RadioButtonFrame.
import javax.swing.JFrame;

public class RadioButtonTest  
{
   public static void main( String args[] )
   {
      RadioButtonFrame radioButtonFrame = new RadioButtonFrame();
      radioButtonFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      radioButtonFrame.setSize( 300, 100 ); // configura o tamanho do frame
      radioButtonFrame.setVisible( true ); // exibe o frame
   } // fim de main
} // fim da classe RadioButtonTest

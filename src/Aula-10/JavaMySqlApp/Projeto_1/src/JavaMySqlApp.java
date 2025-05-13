
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class JavaMySqlApp {

    public static void main(String args[]) 
    {   String  sMenu[] = {"Incluir", "Consultar", "Alterar", "Excluir", "Listar", "Sair"};
        ArrayList<User> aLista;
        User    uDraft  = new User();
        Gui     gMenu   = new Gui(sMenu);
        CrudBD  cBD     = new CrudBD();
        int     iOption;
        
        do
        {   uDraft.clearObject();
            iOption = gMenu.getOption();
            switch(iOption)
            {   case 0: // Incluir
                    uDraft.setUser(JOptionPane.showInputDialog(null, "Digite o Usuário:", "Incluir", JOptionPane.QUESTION_MESSAGE));
                    uDraft.setPass(JOptionPane.showInputDialog(null, "Digite a Senha:", "Incluir", JOptionPane.QUESTION_MESSAGE));
                    cBD.incluirReg(uDraft);
                    cBD.consultarReg(uDraft);
                    break;
                                            
                case 1: // Consultar
                    uDraft.setUser(JOptionPane.showInputDialog(null, "Digite o Usuário:", "Consultar", JOptionPane.QUESTION_MESSAGE));
                    cBD.consultarReg(uDraft);
                    break;
                            
                case 2: // Alterar
                    uDraft.setUser(JOptionPane.showInputDialog(null, "Digite o Usuário:", "Alterar", JOptionPane.QUESTION_MESSAGE));
                    uDraft.setPass(JOptionPane.showInputDialog(null, "Digite a Senha:", "Alterar", JOptionPane.QUESTION_MESSAGE));
                    cBD.alterarReg(uDraft);
                    cBD.consultarReg(uDraft);
                    break;
                            
                case 3: // Excluir
                    uDraft.setUser(JOptionPane.showInputDialog(null, "Digite o Usuário:", "Excluir", JOptionPane.QUESTION_MESSAGE));
                    cBD.excluirReg(uDraft);
                    cBD.consultarReg(uDraft);
                    break;
                            
                case 4: // Listar
                    JOptionPane.showMessageDialog(null, "Acione OK para ver no console os usuários e senhas cadastrados!");
                    aLista = cBD.buscarTodos();
                    for (int i = 0; i < aLista.size(); i++)
                    {   uDraft = aLista.get(i);
                    System.out.println(uDraft.getUser() + "-" + uDraft.getPass());
                    }
                    System.out.println("------------------------------");
                    break;
                            
                case 5: // Sair
                    System.exit(0);
                    break;
            }
            JOptionPane.showMessageDialog(null, "Usuário: " + uDraft.getUser() + "\n" + "Senha: " + uDraft.getPass());
        }while(iOption < sMenu.length-1);
    }
}

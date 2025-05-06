import java.util.ArrayList;

public class Rede
{
    private ArrayList<Amigo> amigos;

    public Rede()
    {
        amigos = new ArrayList<Amigo>();
    }

    public void addAmigo(Amigo amigo)
    {
        amigos.add(amigo);
    }

    public boolean blockAmigo(String nome)
    {
        int posicao = buscar(nome);
        if (posicao >= 0)
        {
            amigos.remove(posicao);
            return true;
        }
        else
        {
            return false;
        }
    }

    public int procurarAmigo(String nome)
    {
        return buscar(nome);
    }

    public boolean enviarMensagem(String nome, String mensagem)
    {
        int posicao = buscar(nome);
        if (posicao >= 0)
        {
            Amigo amigo = amigos.get(posicao);
            amigo.setMensagem(mensagem);
            return true;
        }
        else
        {
            return false;
        }
    }

    public Amigo[] procurarVelhos()
    {
        if (amigos.size() == 0)
        {
            return new Amigo[0];
        }

        int maior = amigos.get(0).getIdade();

        for (Amigo amigo : amigos)
        {
            if (amigo.getIdade() > maior)
            {
                maior = amigo.getIdade();
            }
        }

        int qtde = 0;
        for (Amigo amigo : amigos)
        {
            if (amigo.getIdade() == maior)
            {
                qtde++;
            }
        }

        Amigo[] velhos = new Amigo[qtde];
        int k = 0;
        for (int i = 0; i < amigos.size(); i++)
        {
            Amigo amigo = amigos.get(i);
            if (amigo.getIdade() == maior)
            {
                velhos[k++] = amigo;
            }
        }

        return velhos;
    }

    private int buscar(String nome)
    {
        for (int i = 0; i < amigos.size(); i++)
        {
            Amigo amigo = amigos.get(i);
            String nomeAmigo = amigo.getNome();
            if (nome.equals(nomeAmigo))
            {
                return i;
            }
        }
        return -1; // não achou
    }

    public void addAmigo(String nome, String sexo, int idade)
    {
        Amigo amigo = new Amigo();
        amigo.setNome(nome);
        amigo.setSexo(sexo);
        amigo.setIdade(idade);
        amigos.add(amigo);
    }

    public void listarAmigos()
    {
        for (Amigo amigo : amigos)
        {
            System.out.println(amigo);
        }
    }
}

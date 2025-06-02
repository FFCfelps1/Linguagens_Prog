public class Main {
  public static void main(String[] args) {
      try (Connection conn = Conexao.conectar()) {
          Professor p = new Professor("João", 45, 123);
          p.inserir(conn);

          Professor p2 = new Professor(123);
          p2.carregar(conn);
          System.out.println(p2);

          p2.setNome("João Atualizado");
          p2.alterar(conn);

          p2.excluir(conn);

      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
}
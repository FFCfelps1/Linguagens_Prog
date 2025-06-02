public class Agencia {
  private String nome;
  private int numero;
  private int digito;

  public Agencia(String nome, int numero) {
      this.nome = nome;
      this.numero = numero;
      this.digito = calcularDigito(numero);
  }

  private int calcularDigito(int numero) {
      String numStr = String.format("%04d", numero);
      int[] pesos = {4, 6, 8, 2};
      int soma = 0;
      for (int i = 0; i < 4; i++) {
          soma += Character.getNumericValue(numStr.charAt(i)) * pesos[i];
      }
      int resto = soma % 11;
      return resto == 10 ? 0 : resto;
  }

  public String getNome() { return nome; }
  public int getNumero() { return numero; }
  public int getDigito() { return digito; }

  public void setNome(String nome) { this.nome = nome; }

  // Persistência
  public void inserir(Connection conn) throws SQLException {
      String sql = "INSERT INTO agencia (numero, digito, nome) VALUES (?, ?, ?)";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setInt(1, numero);
          stmt.setInt(2, digito);
          stmt.setString(3, nome);
          stmt.executeUpdate();
      }
  }

  public void atualizar(Connection conn) throws SQLException {
      String sql = "UPDATE agencia SET nome = ? WHERE numero = ?";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setString(1, nome);
          stmt.setInt(2, numero);
          stmt.executeUpdate();
      }
  }

  public void excluir(Connection conn) throws SQLException {
      String sql = "DELETE FROM agencia WHERE numero = ?";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setInt(1, numero);
          stmt.executeUpdate();
      }
  }

  public void carregar(Connection conn) throws SQLException {
      String sql = "SELECT nome, digito FROM agencia WHERE numero = ?";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setInt(1, numero);
          try (ResultSet rs = stmt.executeQuery()) {
              if (rs.next()) {
                  this.nome = rs.getString("nome");
                  this.digito = rs.getInt("digito");
              }
          }
      }
  }
}

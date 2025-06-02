public class Cliente {
  private String nome;
  private String cpf;
  private ContaCorrente conta;

  public Cliente(String nome, String cpf, ContaCorrente conta) {
      this.nome = nome;
      this.cpf = cpf;
      this.conta = conta;
  }

  public String getNome() { return nome; }
  public String getCpf() { return cpf; }
  public ContaCorrente getConta() { return conta; }

  public void setNome(String nome) { this.nome = nome; }
  public void setConta(ContaCorrente conta) { this.conta = conta; }

  // Persistência
  public void inserir(Connection conn) throws SQLException {
      String sql = "INSERT INTO cliente (cpf, nome) VALUES (?, ?)";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setString(1, cpf);
          stmt.setString(2, nome);
          stmt.executeUpdate();
      }
  }

  public void atualizar(Connection conn) throws SQLException {
      String sql = "UPDATE cliente SET nome = ? WHERE cpf = ?";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setString(1, nome);
          stmt.setString(2, cpf);
          stmt.executeUpdate();
      }
  }

  public void excluir(Connection conn) throws SQLException {
      String sql = "DELETE FROM cliente WHERE cpf = ?";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setString(1, cpf);
          stmt.executeUpdate();
      }
  }

  public void carregar(Connection conn) throws SQLException {
      String sql = "SELECT nome FROM cliente WHERE cpf = ?";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setString(1, cpf);
          try (ResultSet rs = stmt.executeQuery()) {
              if (rs.next()) {
                  this.nome = rs.getString("nome");
              }
          }
      }
  }
}
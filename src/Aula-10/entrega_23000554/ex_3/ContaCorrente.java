public class ContaCorrente {
  private int numero;
  private int digito;
  private double saldo;
  private Agencia agencia;

  public ContaCorrente(int numero, Agencia agencia) {
      if (numero < 0 || numero > 9999) throw new IllegalArgumentException("Número inválido");
      this.numero = numero;
      this.digito = calcularDigito(numero);
      this.agencia = agencia;
      this.saldo = 0;
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

  public int getNumero() { return numero; }
  public int getDigito() { return digito; }
  public double getSaldo() { return saldo; }
  public Agencia getAgencia() { return agencia; }

  public void depositar(double valor) {
      if (valor > 0) saldo += valor;
  }

  public double sacar(double valor) {
      if (valor <= saldo) {
          saldo -= valor;
          return valor;
      } else {
          System.out.println("Saque não realizado. Saldo insuficiente.");
          return 0;
      }
  }

  public double consultarSaldo() {
      return saldo;
  }

  public void imprimirSaldo() {
      System.out.printf("Conta: %04d-%d | Agência: %04d-%d | Saldo: %.2f\n",
          numero, digito, agencia.getNumero(), agencia.getDigito(), saldo);
  }

  // Persistência
  public void inserir(Connection conn) throws SQLException {
      String sql = "INSERT INTO conta_corrente (numero, digito, saldo, agencia_numero) VALUES (?, ?, ?, ?)";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setInt(1, numero);
          stmt.setInt(2, digito);
          stmt.setDouble(3, saldo);
          stmt.setInt(4, agencia.getNumero());
          stmt.executeUpdate();
      }
  }

  public void atualizar(Connection conn) throws SQLException {
      String sql = "UPDATE conta_corrente SET saldo = ?, agencia_numero = ? WHERE numero = ?";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setDouble(1, saldo);
          stmt.setInt(2, agencia.getNumero());
          stmt.setInt(3, numero);
          stmt.executeUpdate();
      }
  }

  public void excluir(Connection conn) throws SQLException {
      String sql = "DELETE FROM conta_corrente WHERE numero = ?";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setInt(1, numero);
          stmt.executeUpdate();
      }
  }

  public void carregar(Connection conn) throws SQLException {
      String sql = "SELECT digito, saldo, agencia_numero FROM conta_corrente WHERE numero = ?";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setInt(1, numero);
          try (ResultSet rs = stmt.executeQuery()) {
              if (rs.next()) {
                  this.digito = rs.getInt("digito");
                  this.saldo = rs.getDouble("saldo");
                  int agNum = rs.getInt("agencia_numero");
                  this.agencia = new Agencia("", agNum);
                  this.agencia.carregar(conn);
              }
          }
      }
  }
}

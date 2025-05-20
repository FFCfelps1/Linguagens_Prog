public class Circulo
{
   private Ponto centro;
   private double raio;

   public Circulo(Ponto centro, double raio)
   {
      this.centro = centro;
      this.raio = raio;
   }

   public Ponto getCentro()
   {
      return centro;
   }

   public double getRaio()
   {
      return raio;
   }

   public void setCentro(Ponto centro)
   {
      this.centro = centro;
   }

   public void setRaio(double raio)
   {
      this.raio = raio;
   }

   // set coordenadaX
   public void setCoordenadaX(double x)
   {
      centro.setCoordenadaX(x);
   }

   // set coordenadaY
   public void setCoordenadaY(double y)
   {
      centro.setCoordenadaY(y);
   }

   //perimetro
   public double perimetro()
   {
      return 2 * Math.PI * raio;
   }

   // area
   public double area()
   {
      return Math.PI * Math.pow(raio, 2);
   }
}
public class Ponto
{
   private double x;
   private double y;

   public Ponto(double x, double y)
   {
      this.x = x;
      this.y = y;
   }

   public double getX()
   {
      return x;
   }

   public double getY()
   {
      return y;
   }

   public void setCoordenadaX(double x)
   {
      this.x = x;
   }

   public void setCoordenadaY(double y)
   {
      this.y = y;
   }
}
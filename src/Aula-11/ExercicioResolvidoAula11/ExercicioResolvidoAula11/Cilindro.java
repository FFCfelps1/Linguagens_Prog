public class Cilindro
{
   private Circulo base;
   private double altura;

   public Cilindro(Circulo base, double altura)
   {
      this.base = base;
      this.altura = altura;
   }

   public Circulo getBase()
   {
      return base;
   }

   public double getAltura()
   {
      return altura;
   }

   public void setBase(Circulo base)
   {
      this.base = base;
   }

   public void setAltura(double altura)
   {
      this.altura = altura;
   }

   // set coordenadaX
   public void setCoordenadaX(double x)
   {
      base.getCentro().setCoordenadaX(x);
   }

   // set coordenadaY
   public void setCoordenadaY(double y)
   {
      base.getCentro().setCoordenadaY(y);
   }

   // set altura
   public void setRaio(double altura)
   {
      this.altura = altura;
   }

   //perimetro
   public double perimetro()
   {
      return base.perimetro();
   }

   // area
   public double area()
   {
      return base.area();
   }

   // volume
   public double volume()
   {
      return base.area() * altura;
   }

   // area da superficie externa
   public double areaDaSuperficieExterna()
   {
      return 2 * base.area() + base.perimetro() * altura;
   }
}
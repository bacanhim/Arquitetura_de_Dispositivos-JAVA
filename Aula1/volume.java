public class volume
{
  public static int CalcularVolume(int a, int b,int c){
      int volume = a*b*c;
      return volume;
  }
    public static void main(final String[] arguments){
      int lado = 10;
      int comprimento = 5;
      int altura =20;
      int resultado = CalcularVolume(lado,comprimento,altura);
      System.out.println(resultado);
  	  } 
}
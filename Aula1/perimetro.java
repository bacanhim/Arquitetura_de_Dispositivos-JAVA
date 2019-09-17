public class HelloWorld
{
  public static int CalcularPerimetro(int a, int b){
      int perimetro = 2 *(a+b);
      return perimetro;
  }
    public static void main(final String[] arguments){
      int lado1 = 10;
      int lado2 =5 ;
      int soma = CalcularPerimetro(lado1,lado2);
      System.out.println(soma);
  	  } 
}
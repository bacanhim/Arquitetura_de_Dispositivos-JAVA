public class temperatura
{
    public static double CalcularTemperatura(double faranheit) {
        double resultado = (faranheit-32)*5/9;
        return resultado;
    }
    public static void main(final String[] arguments){
        double grau = 77;
        double result = CalcularTemperatura(grau);
        System.out.println(result);
    }
}
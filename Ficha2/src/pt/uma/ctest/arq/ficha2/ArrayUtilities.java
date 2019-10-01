package pt.uma.ctest.arq.ficha2;

public class ArrayUtilities {
    public static String toString(int[] a){
        int i;
        String frase ="";
        for(i=0;i<a.length-1;i++){
            frase+=a[i]+",";
        }
        frase+=a[i];
        return frase;
    }
    public static int maximumOf(int[] a){
        int max=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]>max)
                max=a[i];
        }
        return max;
    }
    public static int minimumOf(int[] a){
        int min=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]<min)
                min=a[i];
        }
        return min;
    }
    public static int[] copyOf(int[] a){
        int[] array=a;
        return array;
    }
    public static boolean contains(int n,int[] a){
        for(int i=0;i<a.length;i++){
            if(a[i]==n)
                return true;
        }
        return false;
    }
    public static int indexOf(int a, int array []){
        if(a>array.length){
            return -1;
        }
        return array[a];
    }
    public static int[] add(int n,int[] a){
        int[] array=new int[a.length+1];
        for(int i=0;i<array.length;i++){
            if(i == array.length-1){
                array[i]=n;
            }
            else{
               array[i]=a[i];
            }
        }
        return array;
    }
    public static int[] remove(int a, int array[]){
        int[] result=new int[array.length-1];
        for (int i = 0; i < array.length; i++) {
            if (a != array[i]){
                result[i]=array[i];
            }
        }
        return result;
    }
}

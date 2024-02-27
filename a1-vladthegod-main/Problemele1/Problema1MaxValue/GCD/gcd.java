package Problemele1.Problema1MaxValue.GCD;

public class gcd {
    public static int gcdiv(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcdiv(b, a % b);
        }
    }
    public static void main(String[] args) {
        int []  nr=new int[args.length];
        int cmmdc=1;
        for(int i=0;i<= args.length-1;i++)
        {
            nr[i]=Integer.parseInt((args[i]));
            if(i==0){
                cmmdc=nr[i];
            }
            if(i>=1){
                cmmdc=gcdiv(nr[i],cmmdc);
            }
        }
        System.out.println(cmmdc);
    }}

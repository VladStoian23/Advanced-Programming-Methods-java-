package Problemele1.Problema1MaxValue.Problema1NrPrime;

public class prime_nr_in_integers {
    //integer comapred to string <- we can use parseInt
    public static void main(String[] arguments) {

        int start = Integer.parseInt(arguments[0]);
        int end = Integer.parseInt((arguments[1]));
        for (int num = start; num <= end; num++) {
            boolean ok = true;
            if (num <= 1)
                ok = false;
            for (int j = 2; j <= num / 2; j++) {
                if (num % j == 0) {
                    ok = false;
                    break;
                }
            }
            if (ok)
                System.out.println(num + "yaay prime");
        }
    }
}
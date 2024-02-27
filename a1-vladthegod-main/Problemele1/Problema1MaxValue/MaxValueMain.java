package Problemele1.Problema1MaxValue;

public class MaxValueMain {
    public static void main(String[] args) {

        if (args.length == 0)
            System.out.println("No double values provided");



        double MAX = Double.MIN_VALUE;

        for(String arguments:args)
        {
            double Value=Double.parseDouble(arguments);
            if(Value>MAX)
                MAX=Value;
        }

        if(MAX==Double.MIN_VALUE)
            System.out.println("No double values provided");
        else
            System.out.println("Maximum value is:"+MAX);

    }
}

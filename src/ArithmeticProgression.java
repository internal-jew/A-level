import java.util.Scanner;

public class ArithmeticProgression {
    private final int initial;
    private  final int step;

    public ArithmeticProgression(int initial, int step) throws ProgressionConfigurationException {
        if (step==0) throw new ProgressionConfigurationException("Step == 0");
        this.initial = initial;
        this.step = step;
    }

    public  int calculate(int n) throws ProgressionConfigurationException{
        if(n<=0) throw new ProgressionConfigurationException("n <0");


        int result=initial;
        for (int i = 0; i < n; i++) {
            result+=step;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scaner=new Scanner(System.in);
        int init=scaner.nextInt();
        int step=scaner.nextInt();
        int n=scaner.nextInt();
        scaner.close();
      //  int r =scaner.nextInt();
        ArithmeticProgression ap=null;
        try {
            ap=new ArithmeticProgression(n,step);
        }
        catch (ProgressionConfigurationException e){
            System.out.println(e);
        }
        try {
            System.out.println(  ap.calculate(n));
        }
        catch (ProgressionConfigurationException e){
            System.out.println(e);
        }

      //  System.out.println(r);
    }
}

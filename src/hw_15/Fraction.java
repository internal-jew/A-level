package hw_15;

public class Fraction {


    int x;
    int y;

    public Fraction(int x, int y) {
        this.x = x;
        this.y = y;
        if(y<0 && x>=0){
            this.x*=-1;
            this.y*=-1;
        }
    }

    @Override
    public String toString() {
        return x + "/" + y;
    }

    public Fraction mult(double fr) {
        if (fr == 0 || this.x == 0 || this.y == 0) {
            return new Fraction(0, 0);
        }
        Fraction second = convert(fr);
        return reduction(new Fraction(this.x * second.x, this.y * second.y));
    }

    public Fraction divide(double fr) {
        if (fr == 0 || this.x == 0 || this.y == 0) {
            System.out.println("Arithmetic Exception - divide by zero");
            return new Fraction(0, 0);
        } else {
            Fraction second = convert(fr);
            return reduction(new Fraction(this.x * second.y, this.y * second.x));
        }


    }

    public static Fraction convert(double fraction) {
        /*int x = (int) fraction;
        double xRest = fraction - x;
        String xStr = Double.toString(xRest);
        int zeroes = xStr.length() - 2;
        int ten = (int) Math.pow(10.0, zeroes);
        return reduction(new Fraction((int) (fraction * ten), ten));
    */
        String xStr=Double.toString(fraction);
        for (int i = 0; i <xStr.length()-1 ; i++) {
            if(xStr.charAt(i)=='.'){
                //  int x=Integer.valueOf(xStr.substring(0,i));
                int zeroes = xStr.length() - i-1;
                int ten = (int) Math.pow(10.0, zeroes);
                return reduction(new Fraction((int)(fraction*ten),1*ten));
                // int y=Integer.valueOf(xStr.substring(i+1));
            }
        }
        return new Fraction(0,0);

    }

    public static Fraction reduction(Fraction fraction) {
        int j=Math.abs(fraction.x);
        for (int i = j; i > 1; i--) {
            if (fraction.x % i == 0 && fraction.y % i == 0) {
                fraction.x /= i;
                fraction.y /= i;
                i=Math.abs(fraction.x);
            }


        }
        return fraction;
    }


    public Fraction sum(Fraction a) {
        return (y == a.y) ? reduction(new Fraction(this.x + a.x, y)) : reduction(new Fraction((this.x * a.y) + (a.x * this.y), this.y * a.y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (x != fraction.x) return false;
        return y == fraction.y && (o.hashCode() == this.hashCode());
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
package at.htlpinkafeld;

import java.lang.Comparable.*;

public interface Taxable extends Comparable{
    public double getTax();

    public default int compareTo(Object o){
        if(o == null)
            return -1;
        if(o instanceof Taxable){
            Taxable t = (Taxable) o;

            double diff = this.getTax() - t.getTax();

            if(diff > -0.02 && diff < 0.02)
                return 0;

            if (this.getTax() > t.getTax())
                return 1;
            else if (this.getTax() < t.getTax())
                return -1;
            else
                return 0;
            }

        return -1;
    }

}

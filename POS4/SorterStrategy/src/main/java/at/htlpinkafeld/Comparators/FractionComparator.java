package at.htlpinkafeld.Comparators;

import at.htlpinkafeld.Classes.Fraction;

public class FractionComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Fraction && o2 instanceof Fraction) {
            Fraction f1 = (Fraction) o1;
            Fraction f2 = (Fraction) o2;

            if (f1.getDenom() == f2.getDenom()) {
                return f1.getNum() - f2.getNum();
            } else {
                double value1 = (double) f1.getNum() / f1.getDenom();
                double value2 = (double) f2.getNum() / f2.getDenom();

                return Double.compare(value1, value2);
            }
        }
        return -2;
    }

}

package at.htlpinkafeld.Comparators;

public class ToStringComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        return o1.toString().compareTo(o2.toString());

    }
}

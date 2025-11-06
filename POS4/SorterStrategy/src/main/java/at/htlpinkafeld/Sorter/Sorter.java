package at.htlpinkafeld.Sorter;

import at.htlpinkafeld.Comparators.Comparator;

import javax.naming.ldap.SortResponseControl;

public class Sorter {

    Comparator comp;

    public Sorter(Comparator comp) {
        this.comp = comp;
    }

    public void setComp(Comparator comp){
        this.comp = comp;
    }

    public Object getMinimum(Object[] arr){

        Object min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(comp.compare(arr[i], min) < 0){
                min = arr[i];
            }
        }
        return min;
    }

    public Object getMaximum(Object[] arr){
        Object max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(comp.compare(arr[i], max) > 0){
                max = arr[i];
            }
        }
        return max;
    }

    public void sort(Object[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (comp.compare(arr[i], arr[j]) > 0) {
                    Object temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


}

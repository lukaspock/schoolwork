package at.htlpinkafeld;

public class Sorter{
    public static Object getMinimum(Comparable[] objects) {
        Comparable min = objects[0];
        for (int i = 1; i < objects.length; i++) {
            if (objects[i].compareTo(min) < 0)
                min = objects[i];
        }
        return min;
    }

    public static Object getMaximum(Comparable[] objects) {
        Comparable max = objects[0];
        for (int i = 1; i < objects.length; i++) {
            if (objects[i].compareTo(max) > 0)
                max = objects[i];
        }
        return max;
    }

    public static void bubbleSort(Comparable[] objects) {
        for (int i = 0; i < objects.length - 1; i++) {
            for (int j = i + 1; j < objects.length; j++) {
                if (objects[i].compareTo(objects[j]) > 0) {
                    Comparable temp = objects[i];
                    objects[i] = objects[j];
                    objects[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] objects = new Comparable[4];
        objects[0] = "STRINGS";
        objects[1] = "ARE";
        objects[2] = "PAIRWISE";
        objects[3] = "COMPARABLE";
        //show the smallest and the greatest Element
        System.out.println("Smallest: " + Sorter.getMinimum(objects));
        System.out.println("Greatest: " + Sorter.getMaximum(objects));
        System.out.println("--");
        //sort and show
        Sorter.bubbleSort(objects);
        for (Comparable cmp: objects)
            System.out.println(cmp);
    }
}




package at.htlpinkafeld;
import java.util.Objects;

public class SoccerField implements Size, Comparable{

    public int getLength() {
        return 105000;
    }
    public int getHeight() {
        return 0;
    }
    public int getWidth() {
        return 70000;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof SoccerField) {
            SoccerField help = (SoccerField) o;

            if (Main.calcArea(this) == Main.calcArea(help)) {
                return 0;
            }
            if (Main.calcArea(this) > Main.calcArea(help)) {
                return 1;
            }
            if (Main.calcArea(this) < Main.calcArea(help)) {
                return -1;
            }
        }
        return -2;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SoccerField; // all soccer fields are equal
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLength(), getWidth(), getHeight());
    }

    @Override
    public String toString() {
        return "SoccerField{" +
                "length=" + getLength() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                '}';
    }
}

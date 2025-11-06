package at.htlpinkafeld;

public class SheetOfPaper implements Size , Comparable{
    private int format; //0=DIN A0, 1=DIN A1, 2=DIN A2, 3=DIN A3, 4=DIN A4

    public SheetOfPaper(int format) {
        this.format = format;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }
    @Override
    public int getWidth() {
        return switch(this.getFormat()) {
            case 0 -> 841;
            case 1 -> 594;
            case 2 -> 420;
            case 3 -> 297;
            case 4 -> 210;
            default -> 0;
        };
    }
    @Override
    public int getLength() {
        return switch(this.getFormat()) {
            case 0 -> 1189;
            case 1 -> 841;
            case 2 -> 594;
            case 3 -> 420;
            case 4 -> 297;
            default -> 0;
        };
    }
    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof SheetOfPaper) {
            SheetOfPaper help = (SheetOfPaper) o;

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
        if (this == o) return true;
        if (!(o instanceof SheetOfPaper)) return false;
        SheetOfPaper that = (SheetOfPaper) o;
        return format == that.format;
    }

    @Override
    public int hashCode() {
        return this.format*12;
    }

    @Override
    public String toString() {
        return "SheetOfPaper{" +
                "format=" + format +
                '}';
    }


}
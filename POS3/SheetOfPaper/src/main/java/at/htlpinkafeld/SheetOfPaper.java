package at.htlpinkafeld;

public class SheetOfPaper implements Size {
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

}
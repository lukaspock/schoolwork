package at.htlpinkafeld.Showable;

public class ShowableDefault implements Showable {
    private Object showObj;

    public ShowableDefault() {              //used with Inheritance
        this.showObj = this;
    }
    public ShowableDefault(Object showObj){ //used with Delegation
        this.showObj = showObj;
    }
    public void show() {
        System.out.println(showObj.toString());
    }
    public void showSimple() {
        System.out.println(showObj.getClass().getSimpleName());
    }
    public void showFull() {
        System.out.println("Class=" + showObj.getClass().getName() +
                "Value=" + showObj.toString());
    }
}

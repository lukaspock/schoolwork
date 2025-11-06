package at.htlpinkafeld.dome;

public abstract class Medium implements Comparable{
    protected String title;
    protected int playingTime;
    protected boolean gotIt;
    protected String comment;

    // Constructor
    Medium(String theTitle, int thePlayingTime) {
        this.title = theTitle;
        this.playingTime = thePlayingTime;
        this.gotIt = false;
        this.comment = "<no comment>";
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }

    public int getPlayingTime() {
        return playingTime;
    }

    public void setOwn(boolean ownIt) {
        gotIt = ownIt;
    }

    public boolean getOwn() {
        return gotIt;
    }

    //public abstract void print();

    public abstract void play();

    @Override
    public int compareTo(Object o){
        if(o == null){
            return -2;
        }
        if(o instanceof Medium){
            Medium r = (Medium)o;
            return this.title.compareTo(r.title);
        }
        return 0;
    }
}

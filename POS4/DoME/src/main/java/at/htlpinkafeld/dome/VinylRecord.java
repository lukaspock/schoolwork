package at.htlpinkafeld.dome;

public class VinylRecord extends Medium{
    int titlesASide;
    int titlesBSide;
    int playingTimeASide;
    int playingTimeBSide;
    int releaseDate;

    VinylRecord(int titlesASide, int titlesBSide, int playingTimeASide, int playingTimeBSide, int releaseDate, String title, boolean gotIt, String comment) {
        super(title,playingTimeASide + playingTimeBSide);
        this.titlesASide = titlesASide;
        this.titlesBSide = titlesBSide;
        this.playingTimeASide = playingTimeASide;
        this.playingTimeBSide = playingTimeBSide;
        this.releaseDate = releaseDate;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }
    public String getComment()
    {
        return comment;
    }
    public void setOwn(boolean ownIt)
    {
        gotIt = ownIt;
    }
    public boolean getOwn()
    {
        return gotIt;
    }

    @Override
    public void play(){
        if(this.gotIt){
            System.out.println("Start Vinyl-Player -- Play: " + this.title + " -- Stop Vinyl-Player");
        }
        else{
            System.out.println("Can't play Vinyl " + this.title + ". Don't own");
        }
    }
    @Override
    public String toString() {
        String retVal;
        retVal = "Vinyl: " + title + " (" + playingTime + " mins)";

        if(gotIt) {
            retVal += '*';
        }
        retVal += '\n';
        retVal += ("    " + comment + '\n' );
        retVal += ("    " + releaseDate + '\n');
        retVal += ("    tracks: " + (titlesASide + titlesBSide) + '\n' );


        return retVal;
    }

}


package at.htlpinkafeld.dome;

public class CD extends Medium
{
    private String artist;
    private int numberOfTracks;

    public CD(String theTitle, String theArtist, int tracks, int time)
    {
        super(theTitle, time);
        artist = theArtist;
        numberOfTracks = tracks;
    }

    //@Override
    public void print()
    {
        System.out.print("CD: " + title + " (" + playingTime + " mins)");
        if(gotIt) {
            System.out.println("*");
        }
	else {
            System.out.println();
        }
        System.out.println("    " + artist);
        System.out.println("    tracks: " + numberOfTracks);
        System.out.println("    " + comment);
    }
    
    @Override
    public String toString(){
        String retVal;
        retVal = "CD: " + title + " (" + playingTime + " mins)";
        
        if(gotIt) {
            retVal += '*';
        }
	    retVal += '\n';
        retVal += ("    " + comment + '\n' );
        retVal += ("    " + artist + '\n');
        retVal += ("    tracks: " + numberOfTracks + '\n' );

        
        return retVal;
    }

    @Override
    public void play()
    {   if(gotIt) {
        System.out.println("Start CD - Player -- Play: <" + this.title + "> -- Stop CD - Player");
        }else
        System.out.println("Can't play CD <" + title + "> -- Play: <" + this.title + ">. Don't own.");
    }
}

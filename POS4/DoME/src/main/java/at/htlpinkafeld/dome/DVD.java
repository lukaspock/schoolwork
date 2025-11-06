package at.htlpinkafeld.dome;

public class DVD extends Medium
{
    private String director;
     // playing time of the main feature

    public DVD(String theTitle, String theDirector, int time)
    {
        super(theTitle, time);
        director = theDirector;
    }

    //@Override
    public void print()
    {
        System.out.print("DVD: " + title + " (" + playingTime + " mins)");
        if(gotIt) {
            System.out.println("*");
        }
	else {
            System.out.println();
        }
        System.out.println("    " + director);
        System.out.println("    " + comment);
    }

    
    @Override
    public String toString(){
        String retVal;
        retVal = "DVD: " + title + " (" + playingTime + " mins)";
        
        if(gotIt) {
            retVal += '*';
        }
	retVal += '\n';
        retVal += ("    " + comment + '\n' );
        retVal += ("    " + director + '\n');
        
        return retVal;
    }

    @Override
    public void play()
    {   if(gotIt) {
        System.out.println("Start DVD - Player -- Play: <" + this.title + "> -- Stop DVD - Player");
    }else
        System.out.println("Can't play DVD <" + title + "> -- Play: <" + this.title + ">. Don't own.");
    }

}

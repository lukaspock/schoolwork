package at.htlpinkafeld.Comparators;


import at.htlpinkafeld.Classes.Article;

public class ArticleComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Article && o2 instanceof Article) {
            Article a1 = (Article)o1;
            Article a2 = (Article)o2;

            if(a1.getTax() > a2.getTax()){
                return 1;
            }
            else if(a1.getTax() < a2.getTax()){
                return -1;
            }
            else if(a1.getTax() == a2.getTax()){
                return a1.toString().compareTo(a2.toString());
            }
            }

        return -2;
        }
    }



package at.htlpinkafeld;

import at.htlpinkafeld.Classes.Article;
import at.htlpinkafeld.Classes.Fraction;
import at.htlpinkafeld.Comparators.ArticleComparator;
import at.htlpinkafeld.Comparators.FractionComparator;
import at.htlpinkafeld.Comparators.ToStringComparator;
import at.htlpinkafeld.Sorter.Sorter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArticleComparator articleComparator = new ArticleComparator();
        FractionComparator fractionComparator = new FractionComparator();
        ToStringComparator toStringComparator = new ToStringComparator();

        Sorter sorter = new Sorter(articleComparator);

        Object[] fractions = {new Fraction(1,2),new Fraction(3,4),new Fraction(5,6)};
        Object[] articles = {new Article("Justini",1.0, Article.Category.FOOD), new Article("Skyr",2.0,Article.Category.FOOD), new Article("Krokodil",500000000.0, Article.Category.FOOD)};
        Object[] strings = {"Flad","Kroko","Justini","Skyr"};

        Object min;
        Object max;

        System.out.println("\nARTICLES\n");

        min = sorter.getMinimum(articles);
        System.out.println("Min Articles: ");
        System.out.println(min);

        max = sorter.getMaximum(articles);
        System.out.println("Max Articles: ");
        System.out.println(max);


        sorter.setComp(fractionComparator);


        System.out.println("\nFRACTIONS\n");

        min = sorter.getMinimum(fractions);
        System.out.println("Min Fractions: ");
        System.out.println(min);

        max = sorter.getMaximum(fractions);
        System.out.println("Max Fractions: ");
        System.out.println(max);


        sorter.setComp(toStringComparator);

        System.out.println("\nSTRINGS\n");

        min = sorter.getMinimum(strings);
        System.out.println("Min strings: ");
        System.out.println(min);

        max = sorter.getMaximum(strings);
        System.out.println("Max strings: ");
        System.out.println(max);

        }

}
package at.htlpinkafeld.Comparators;

import at.htlpinkafeld.Classes.Article;
import at.htlpinkafeld.Classes.Fraction;
import at.htlpinkafeld.Sorter.Sorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArticleComparatorTest {
    private Object[] articles;
    Sorter sorter = new Sorter(new ArticleComparator());

    @BeforeEach
    void setUp() {
        this.articles = new Object[]{new Article("Justini", 1.0, Article.Category.FOOD), new Article("Skyr", 2.0, Article.Category.FOOD), new Article("Krokodil", 500000000.0, Article.Category.FOOD)};
    }

    @org.junit.jupiter.api.Test
    void compareMin() {
        assertEquals(sorter.getMinimum(articles), articles[0]);
    }

    @org.junit.jupiter.api.Test
    void compareMax() {
        assertEquals(sorter.getMaximum(articles), articles[2]);
    }

    @Test
    void sort(){
        sorter.sort(articles);
        Article[] expected = new Article[]{new Article("Justini", 1.0, Article.Category.FOOD), new Article("Skyr", 2.0, Article.Category.FOOD), new Article("Krokodil", 500000000.0, Article.Category.FOOD)};
        assertEquals(Arrays.toString(articles), Arrays.toString(expected));
    }
}
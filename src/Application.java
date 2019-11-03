import java.io.IOException;

public class Application
{

    public static void main(String[] args) throws IOException
    {
        System.out.println("First we are going to count the duplicates\n");
        DuplicateCounter dc = new DuplicateCounter();
        dc.count("problem1.txt");
        dc.write("unique_words_counts.txt");
        System.out.println("Second we are going to remove the duplicates\n");
        DuplicateRemover dr=new DuplicateRemover();
        dr.remove("problem2.txt");
        dr.write("unique_words.txt");
    }

}
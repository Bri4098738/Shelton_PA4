import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter
{
    private Map<String, Integer> wordCounter;

    public DuplicateCounter()
    {
        wordCounter = new HashMap<String,Integer>();
    }

    //counting words
    public void count(String dataFile)
    {
        //prep for lack of file
        Scanner infile = null;
        try
        {
            infile = new Scanner(new File(dataFile));
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            return;
        }
        //prepare to read and count
        infile.useDelimiter("([0-9]|[.,!?:;'\"-]|\\s)+");
        while(infile.hasNext())
        {
            String word = infile.next().toLowerCase();
            Integer count = wordCounter.get(word);
            if(count == null)
                count = 1;
            else
                count = count + 1;
            wordCounter.put(word, count);
        }
        infile.close();
    }


    //write the new file
    public void write(String outputFile){
        System.out.println("Writing to new file\n");
        try {
            PrintWriter outfile = new PrintWriter(new File(outputFile));
            for(String k : wordCounter.keySet()) {
                outfile.println(k + " " + wordCounter.get(k));
            }
            outfile.close();
            System.out.println("File written to existing file\n");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
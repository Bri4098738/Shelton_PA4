import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class DuplicateRemover {

    private Set<String> uniqueWords;

    //remove the words
    public void remove(String dataFile) throws FileNotFoundException
        {
            String word;
            uniqueWords = new HashSet<String>();
            Scanner sc = new Scanner(new File(dataFile));
            while (sc.hasNext())
            {
                word = sc.next();
                uniqueWords.add(word);
            }
            sc.close();
        }

        //create/find the file
        public void write (String outputFile) throws IOException
        {
            File f;
            FileWriter fw = null;

            f = new File(outputFile);

            //already there
            if (f.exists()) {
                fw = new FileWriter(f, true);
                Iterator itr = uniqueWords.iterator();

                while (itr.hasNext()) {
                    String str = (String) itr.next();
                    fw.write(str + "\n");
                }
                fw.close();
                System.out.println("Data written to existing file");
            }
            //new file
            else
                {
                f.createNewFile();
                fw = new FileWriter(f);
                Iterator itr = uniqueWords.iterator();

                while (itr.hasNext()) {
                    String str = (String) itr.next();
                    fw.write(str + "\n");
                }
                fw.close();
                System.out.println("File created with new data");
            }
        }

    }

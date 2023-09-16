import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt1"));

        String text1 = "the day   is sunny the the\n";
        String text2 = "the sunny is       is\n";

        writer.write(text1);
        writer.write(text2);
        writer.close();

        BufferedReader read = new BufferedReader(new FileReader("file.txt1"));

        String c;
        String result = "";

        while ((c = read.readLine()) != null) {
            result = result + c + " ";
        }

        result = result.replaceAll("[\\s]{2,}", " ");

        String[] newResult = result.split(" ");


        Arrays.sort(newResult);

        int count = 0;
        int longOfArrey = newResult.length;
        int s = 0;
        Object[] elem = new Object[longOfArrey];

        Elements elements = new Elements();
        int colichesvo = 0;
        for (int i = 0; i < newResult.length; i++) {
            if (i == 0){
                  elements = new Elements();
                  elements.slovo = newResult[i];
                  elements.colichestvo = 1;
                continue;
            }

            if (newResult[i].equals(elements.slovo)){
                elements.colichestvo = elements.colichestvo + 1;
            }else {
                if (!elements.slovo.isEmpty()) {
                    elem[s] = elements;
                    elements = new Elements();
                    elements.slovo = newResult[i];
                    elements.colichestvo = 1;
                    s = s + 1;
                }
            }
        }
        elem[s] = elements;
        s++;
        String[] resSec = new String[s];

        for (int i = 0; i < s; i++) {

            int col = ((Elements) elem[i]).colichestvo;
            String come = ((Elements) elem[i]).slovo;
            String aboba = Integer.toString(col) + " " + come;
            resSec[i] = aboba;
        }
        Arrays.sort(resSec, Collections.reverseOrder());

        String last = "";
       for (String fin : resSec){
           String fin1[] = fin.split(" ");
           last = fin1[1] + " " + fin1[0];
           System.out.println(last);
       }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader read = new BufferedReader(new FileReader("d:/1/file.txt1"));

        String c;
        String result = "";

        while ((c = read.readLine()) != null) {
            result = result + c + " ";
        }
        System.out.println(result);

        result = result.replaceAll("[\\s]{2,}", " ");

        String[] newResult = result.split(" ");

        System.out.println(Arrays.toString(newResult));

        Arrays.sort(newResult);

        System.out.println(Arrays.toString(newResult));
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

        System.out.println("rrr" + resSec);
        String last = "";
       for (String fin : resSec){
           String fin1[] = fin.split(" ");
           last = fin1[1] + " " + fin1[0];
           System.out.println(last);
       }
    }
}

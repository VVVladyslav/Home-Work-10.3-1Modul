import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new FileReader("file.txt1"));

        String c;
        String result = "";

        while ((c = read.readLine()) != null) {
            result = result + c + " ";
        }

        result = result.replaceAll("[\\s]{2,}", " ");

        String[] newResult = result.split(" ");


        Arrays.sort(newResult);

        int longOfArrey = newResult.length;
        int s = 0;
        String[] elem = new String[longOfArrey];

        int Colichestvo = 0;
        String Slovo = "";

        //Elements elements = new Elements();
        for (int i = 0; i < newResult.length; i++) {
            if (i == 0){
                Slovo = newResult[i];
                Colichestvo = 1;
                continue;
            }

            if (newResult[i].equals(Slovo)){
                Colichestvo = Colichestvo + 1;
            }else {
                    elem[s] =  Colichestvo + " " + Slovo;
                    Slovo = newResult[i];
                    Colichestvo = 1;
                    s = s + 1;
            }
        }
        elem[s] = Colichestvo + " " + Slovo;
        s++;

        String[] lest = new String[s];

        for (int i = 0; i < s; i++) {
            if (elem[i] != null){
                lest[i] = elem[i];
            }
        }
        Arrays.sort(lest, Collections.reverseOrder());

        String last = "";
       for (String fin : lest){
           String fin1[] = fin.split(" ");
           last = fin1[1] + " " + fin1[0];
           System.out.println(last);
       }
    }
}

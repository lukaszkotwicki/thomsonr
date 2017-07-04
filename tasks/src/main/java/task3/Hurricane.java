package task3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Hurricane {

    public static Map<String,Integer> readMaxWindSpeed (String file) {
        Map <String,Integer> result = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null; ) {
                if (line.substring(4,8).equals("2009")) {
                    String name = line.substring(9,28).replaceAll("\\s+","");
                    int maxWindSpeed = 0;
                    for (int lines = Integer.parseInt(line.substring(33,36).replaceAll("\\s+",""));
                         lines > 0; lines--) {
                        line = br.readLine();
                        int lastWindSpeed = Integer.parseInt(line.substring(38,41).replaceAll("\\s+",""));
                        maxWindSpeed = maxWindSpeed < lastWindSpeed ? lastWindSpeed : maxWindSpeed;
                    }
                    result.put(name,maxWindSpeed);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Reader closed prematurely.");
            e.printStackTrace();
        }
        return result;
    }
}

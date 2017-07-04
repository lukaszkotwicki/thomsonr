package task3;

import java.util.Map;

public class Run {

    public static void main(String args[]) {
        String file = "src/main/resources/hurdat2-nepac-1949-2016-041317.txt"; 
        Map<String, Integer> hurricanes = Hurricane.readMaxWindSpeed(file);
        for (Map.Entry<String,Integer> entry : hurricanes.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by seladanghijau on 27/11/2016.
 */
public class NoParallel {
    public static void main(String [] args) {
        Scanner in;
        String fileDir;
        File folder;

        in = new Scanner(System.in);
        System.out.print("Input folder path (which has file to be read): ");
        fileDir = in.next();
        folder = new File(fileDir);

        try {
            double totalTime = 0.0;
            for(final File entry : folder.listFiles()) {
                if(!entry.isDirectory()) {
                    long startTime, endTime;
                    double elapsedTime;
                    StringBuilder strBuilder;
                    BufferedReader reader;
                    String line;

                    strBuilder = new StringBuilder();
                    reader = new BufferedReader(new FileReader(entry));

                    startTime = System.currentTimeMillis();
                    while((line = reader.readLine()) != null) {
                        strBuilder.append(line);
                    }
                    endTime = System.currentTimeMillis();
                    elapsedTime = (endTime - startTime) / 1000.0;
                    totalTime += elapsedTime;

                    System.out.println(entry.getName() + "[Time elapsed: " + elapsedTime + " seconds] :");

                    reader.close();
                }

                System.out.println("\tTotal elapsed time: " + totalTime + " seconds");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}

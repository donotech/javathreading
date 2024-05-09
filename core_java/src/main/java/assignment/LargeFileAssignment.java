package assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LargeFileAssignment {

    public static void main(String[] args) {
        Path filePath = Paths.get("C:\\Users\\sanya\\Downloads\\", "overseas-trade-indexes-December-2021-quarter-provisional-csv.csv");
        final long startTime = System.currentTimeMillis();
        try (Stream<String> lines = Files.lines(filePath)) {
//            List<String> filteredLines = lines
//                    .filter(s -> s.contains("password"))
//                    .collect(Collectors.toList());
            Optional<Double> total =  lines
                    .filter((x) -> !x.startsWith("Series_reference"))
                    .map((line) -> {
                        String[] fields = line.split(",");
                        String data = fields[2].strip();
//                        System.out.println(data);
                        Double d = 0.0;
                        if(data.strip().length() > 0) {
                            d = Double.parseDouble(data);
                        }
                        return d;
                    })
                    .reduce((d, sum) -> {
                        return sum + d;
            });

            System.out.println("Total = " + total.get());
            //filteredLines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final long elapsedTimeMillis = System.currentTimeMillis() - startTime;
        System.out.println("Total Time: " + elapsedTimeMillis);
    }

}

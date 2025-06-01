package adventofcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessor {

    public Map<String, Integer> getWireMap() {
        Map<String, Integer> wireMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProcessor.class.getResourceAsStream("wire_data_input.txt")))) {

            reader.lines()
                    .filter(line -> !line.trim().isEmpty())
                    .forEach(line -> {
                        String[] parts = line.split(":");
                        if (parts.length == 2) {
                            wireMap.put(parts[0].trim(), Integer.parseInt(parts[1].trim()));
                        }
                    });

            // Java 8 way to print
            wireMap.forEach((k, v) -> System.out.println(k + " = " + v));

        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return wireMap;
    }

    public List<WireData> getWireData() {
        List<WireData> wireDataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProcessor.class.getResourceAsStream("wire_data.txt")))) {

            reader.lines()
                    .filter(line -> !line.trim().isEmpty())
                    .forEach(line -> {
                        WireData data = parseLine(line);
                        if (data != null) {
                            wireDataList.add(data);
                        }
                    });

            // Java 8 way to print all parsed data
            wireDataList.forEach(wd ->
                    System.out.println("i1=" + wd.i1 + ", i2=" + wd.i2 + ", op=" + wd.op + ", result=" + wd.result));

        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return wireDataList;
    }

    private WireData parseLine(String line) {
        String[] parts = line.split(" -> ");
        if (parts.length != 2) return null;

        String expression = parts[0].trim();
        String result = parts[1].trim();

        String[] tokens = expression.split(" ");

        if (tokens.length == 1) {
            // e.g., "123 -> x"
            return new WireData(tokens[0], null, "ASSIGN", result);
        } else if (tokens.length == 2) {
            // e.g., "NOT x -> y"
            return new WireData(tokens[1], null, tokens[0], result);
        } else if (tokens.length == 3) {
            // e.g., "x AND y -> z"
            return new WireData(tokens[0], tokens[2], tokens[1], result);
        }

        return null;
    }
}

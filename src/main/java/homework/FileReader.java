package homework;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {

    public String read(String filePath) {
        String result = null;
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            result = content.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}

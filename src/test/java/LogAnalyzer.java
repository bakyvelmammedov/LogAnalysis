import java.io.*;
import java.util.regex.*;

public class LogAnalyzer {

    public static void main(String[] args) {

        File logDir = new File(System.getProperty("user.dir") + "/src/test/resources/LogData");
        File[] logFiles = logDir.listFiles();
        Pattern logLinePattern = Pattern.compile("^([\\d\\-: ]+) \\[(\\w+)] (.*)$");

        for (File logFile : logFiles) {
            if (logFile.isFile()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
                    String line;

                    while ((line = reader.readLine()) != null) {
                        Matcher matcher = logLinePattern.matcher(line);
                        if (matcher.matches()) {
                            String time = matcher.group(1);
                            String username = matcher.group(2);
                            String message = matcher.group(3);
                            System.out.println("time: " + time + ", username: " + username + ", message: " + message);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogFileCreator extends LogRecorder {

    public LogFileCreator(LocalDateTime time, String username, String message) {
        super(time, username, message);
    }

    public static void main(String[] args) {
        String fileName = "logs03.txt";
        File logFile = new File(fileName);

        try {
            FileWriter writer = new FileWriter(logFile);
            List<LogRecorder> logRecords = new ArrayList<>();
            for (int day = 11; day < 221; day++) {
                logRecords.add(new LogRecorder(LocalDateTime.now().plusDays(day), "user3", "this is third log"));
            }

            for(LogRecorder logRecord : logRecords) {
                writer.write(logRecord.toString());
                writer.write("\n");
            }
            writer.close();
            System.out.println("log file created at : " + logFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

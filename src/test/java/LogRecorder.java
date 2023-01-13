import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogRecorder {
    private LocalDateTime time;
    private String username;
    private String message;

    public LogRecorder (LocalDateTime time, String username, String message) {
        this.time = time;
        this.username = username;
        this.message = message;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatter) + " [" + username + "] " + message;
    }

}

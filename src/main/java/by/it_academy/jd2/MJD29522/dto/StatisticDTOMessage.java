package by.it_academy.jd2.MJD29522.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class StatisticDTOMessage {
    private final LocalDateTime time;
    private final String message;

    public StatisticDTOMessage(LocalDateTime time, String message) {
        this.time = time;
        this.message = message;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "StatisticDTOMessage{" +
                "time=" + time +
                ", message='" + message + '\'' +
                '}';
    }



}

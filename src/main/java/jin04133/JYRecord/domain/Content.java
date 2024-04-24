package jin04133.JYRecord.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Content {
    private String id;
    private LocalDateTime date;
    private String title;
    private String text;

    public Content(LocalDateTime date, String title, String text) {
        this.date = date;
        this.title = title;
        this.text = text;
    }
}

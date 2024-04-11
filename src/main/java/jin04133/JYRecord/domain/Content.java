package jin04133.JYRecord.domain;

import java.time.LocalDateTime;

public class Content {
    Long id;
    LocalDateTime date;
    String title;
    String text;
    public Content(Long id, LocalDateTime date, String title, String text) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.text = text;
    }
}

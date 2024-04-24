package jin04133.JYRecord.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
@Data
public class Category {
    private String id;
    private String name;
    private List<String> contentIds;

    public Category(String name) {
        this.name = name;
        this.contentIds = new LinkedList<>();
    }
    public void addContent(String contentId) {
        contentIds.add(contentId);
    }

}


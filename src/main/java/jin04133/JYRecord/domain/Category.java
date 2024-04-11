package jin04133.JYRecord.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Category {
    String id;
    String name;
    List<String> contents;

    public Category(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.contents = new LinkedList<>();
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


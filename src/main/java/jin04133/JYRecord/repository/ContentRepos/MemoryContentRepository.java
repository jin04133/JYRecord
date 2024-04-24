package jin04133.JYRecord.repository.ContentRepos;

import jin04133.JYRecord.domain.Content;
import jin04133.JYRecord.repository.ContentRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class MemoryContentRepository implements ContentRepository {
    private final Map<String, Content> storage = new HashMap<>();
    @Override
    public Optional<Content> findById(String id) {
        Content found = storage.get(id);
        if (found == null) return Optional.empty();
        else return Optional.of(found);
    }
    @Override
    public Optional<Content> delete(String id) {
        Content deleted = storage.remove(id);
        if (deleted == null) return Optional.empty();
        else return Optional.of(deleted);
    }

    @Override
    public Content save(Content content) {
        String id = UUID.randomUUID().toString();
        content.setId(id);
        storage.put(id, content);
        return content;
    }
    @Override
    public void update(String id, Content updateForm) {
        Content target = storage.get(id);
        target.setDate(updateForm.getDate());
        target.setTitle(updateForm.getTitle());
        target.setText(updateForm.getText());
    }
    //test 용으로 repo 비우는 것
    public void clearRepo() {
        storage.clear();
    }
}

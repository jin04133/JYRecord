package jin04133.JYRecord.repository.ContentRepos;

import jin04133.JYRecord.domain.Content;
import jin04133.JYRecord.repository.ContentRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class MemoryContentRepository implements ContentRepository {
    Map<String, Content> storage = new HashMap<>();
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
    public void save(Content content) {
        String id = UUID.randomUUID().toString();
        storage.put(id, content);
    }
}

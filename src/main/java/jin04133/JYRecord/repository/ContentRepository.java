package jin04133.JYRecord.repository;

import jin04133.JYRecord.domain.Content;

import java.util.Optional;

public interface ContentRepository {
    public Optional<Content> findById(String id);
    public Optional<Content> delete(String id);
    public Content save(Content content);
    public void update(String id, Content updateForm);
}

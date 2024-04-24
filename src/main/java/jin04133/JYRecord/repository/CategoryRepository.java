package jin04133.JYRecord.repository;

import jin04133.JYRecord.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    public Optional<Category> findById(String id);
    public List<Category> findAll();
    public Optional<Category> delete(String id);
    public Category save(Category category);
    public void update(String id, Category updateForm);
}

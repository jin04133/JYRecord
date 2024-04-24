package jin04133.JYRecord.repository.CategoryRepos;

import jin04133.JYRecord.domain.Category;
import jin04133.JYRecord.repository.CategoryRepository;

import java.util.*;

public class MemoryCategoryRepository implements CategoryRepository {

    Map<String, Category> storage = new HashMap<>();
    @Override
    public Optional<Category> findById(String id) {
        Category found = storage.get(id);
        if (found == null) return Optional.empty();
        else return Optional.of(found);
    }
    @Override
    public List<Category> findAll() {
        return storage.values().stream().toList();
    }
    @Override
    public Optional<Category> delete(String id) {
        Category removed = storage.remove(id);
        if (removed == null) return Optional.empty();
        return Optional.of(removed);
    }
    @Override
    public Category save(Category category) {
        String id = UUID.randomUUID().toString();
        category.setId(id);
        storage.put(id, category);
        return category;
    }

    @Override
    public void update(String id, Category updateForm) {
        Category target = findById(id).get();
        target.setName(updateForm.getName());
        target.setContentIds(updateForm.getContentIds());
    }
}

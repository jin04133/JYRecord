package jin04133.JYRecord.repository.CategoryRepos;

import jin04133.JYRecord.domain.Category;
import jin04133.JYRecord.repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryCategoryRepositoryTest {
    CategoryRepository repository = new MemoryCategoryRepository();
    @BeforeEach
    void deleteAll() {
        repository.findAll().forEach(category -> {
            repository.delete(category.getId());
        });
    }
    @Test
    @DisplayName("하나 저장")
    void save() {
        //given
        Category created = repository.createNew("IT 분야");
        //when
        Category result = repository.findById(created.getId()).orElseGet(this::defaultValue);
        //then
        assertThat(created.getId()).isEqualTo(result.getId());
    }
    @Test
    @DisplayName("여러개 저장 후 찾기")
    void saveN() {
        //given
        Category created1 = repository.createNew("IT 분야");
        Category created2 = repository.createNew("draw 분야");
        //when
        Category result = repository.findById(created2.getId()).orElseGet(this::defaultValue);
        //then
        assertThat(result.getId()).isEqualTo(created2.getId());
        assertThat(result.getId()).isNotEqualTo(created1.getId());
    }
    @Test
    @DisplayName("없는 거 찾기")
    void findNothing() {
        //given
        Category created1 = repository.createNew("IT 분야");
        Category created2 = repository.createNew("draw 분야");
        //when
        Category category = repository.findById("123").orElseGet(this::defaultValue);
        //then
        assertThat(category.getName()).isEqualTo("기본 값");
    }
    @Test
    @DisplayName("여러개 찾아서 sout 남기기")
    void printAll() {
        //given
        Category created1 = repository.createNew("IT 분야");
        Category created2 = repository.createNew("draw 분야");
        //then
        repository.findAll().forEach(category -> {
            System.out.println("name=" + category.getName());
        });
    }

    Category defaultValue() {
        return new Category("기본 값");
    }

}
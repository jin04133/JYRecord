package jin04133.JYRecord.repository.ContentRepos;

import jin04133.JYRecord.domain.Content;
import jin04133.JYRecord.repository.ContentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemoryContentRepositoryTest {
    MemoryContentRepository repository = new MemoryContentRepository();
    @AfterEach
    void initRepo() {
        repository.clearRepo();
    }

    @Test
    @DisplayName("저장 후 조회")
    void save() {
        //given
        Content content = new Content(LocalDateTime.now(), "new title", "안녕하세요 저는 새로운 content 입니다");
        Content content2 = new Content(LocalDateTime.now(), "new title2", "안녕하세요 저는 새로운 content 입니다2");
        Content saved = repository.save(content);
        //when
        Optional<Content> found = repository.findById(saved.getId());
        //then
        assertThat(found.get()).isSameAs(saved);
    }

    @Test
    @DisplayName("없는 것 조회")
    void findNothing() {
        //given
        //when
        //then
        Optional<Content> found = repository.findById("없는아이디여");
        assertThatThrownBy(() -> found.get()).isInstanceOf(NoSuchElementException.class);

    }
    @Test
    @DisplayName("저장된 것 삭제")
    void delete() {
        //given
        Content content = new Content(LocalDateTime.now(), "new title", "안녕하세요 저는 새로운 content 입니다");
        Content saved = repository.save(content);
        //when
        Content deleted = repository.delete(saved.getId()).get();
        //then
        assertThat(deleted).isEqualTo(saved);
        assertThatThrownBy(() -> repository.findById(deleted.getId()).get()).isInstanceOf(NoSuchElementException.class);
    }
    @Test
    @DisplayName("있는 것 업데이트 하기")
    void update() {
        //given
        Content content = new Content(LocalDateTime.now(), "new title", "안녕하세요 저는 새로운 content 입니다");
        Content saved = repository.save(content);
        //when
        Content updateForm = new Content(LocalDateTime.now(), "updateTitle", "업데이트 한 text");
        repository.update(saved.getId(), updateForm);
        //then
        Content found = repository.findById(saved.getId()).get();
        assertThat(found.getTitle()).isEqualTo(updateForm.getTitle());
        assertThat(found.getText()).isEqualTo(updateForm.getText());
    }
}
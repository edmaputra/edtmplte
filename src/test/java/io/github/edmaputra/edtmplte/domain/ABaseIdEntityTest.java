package io.github.edmaputra.edtmplte.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class ABaseIdEntityTest {

    BaseEntity baseEntity;

    @Test
    public void whenInitializeWithoutParams_shouldContainDefaultValue() {
        baseEntity = new BaseEntity();

        assertThat(baseEntity.getUpdater()).isEqualTo("sys");
        assertThat(baseEntity.getCreator()).isEqualTo("sys");
        assertThat(baseEntity.getUpdatedOn()).isEqualTo(LocalDate.now());
        assertThat(baseEntity.getCreatedOn()).isEqualTo(LocalDate.now());
        assertThat(baseEntity.getVersion()).isEqualTo("1");
        assertThat(baseEntity.isRecorded()).isTrue();
    }

    @Test
    public void whenInitializeWithParamsID_shouldContainDefaultValue() {
        baseEntity = new BaseEntity(
                1L
        );

        assertThat(baseEntity.getUpdater()).isEqualTo("sys");
        assertThat(baseEntity.getCreator()).isEqualTo("sys");
        assertThat(baseEntity.getUpdatedOn()).isEqualTo(LocalDate.now());
        assertThat(baseEntity.getCreatedOn()).isEqualTo(LocalDate.now());
        assertThat(baseEntity.getVersion()).isEqualTo("1");
        assertThat(baseEntity.isRecorded()).isTrue();
        assertThat(baseEntity.getId()).isEqualTo(1L);
    }

    @Test
    public void whenInitializeWithParams_shouldContainDefaultValue() {
        baseEntity = new BaseEntity(
                "2",
                LocalDate.of(2020, Month.JANUARY, 1),
                "admin",
                LocalDate.of(2020, Month.JANUARY, 10),
                "user",
                true,
                1L
        );

        assertThat(baseEntity.getUpdater()).isEqualTo("user");
        assertThat(baseEntity.getCreator()).isEqualTo("admin");
        assertThat(baseEntity.getUpdatedOn()).isEqualTo(LocalDate.of(2020, Month.JANUARY, 10));
        assertThat(baseEntity.getCreatedOn()).isEqualTo(LocalDate.of(2020, Month.JANUARY, 1));
        assertThat(baseEntity.getVersion()).isEqualTo("2");
        assertThat(baseEntity.isRecorded()).isTrue();
        assertThat(baseEntity.getId()).isEqualTo(1L);
    }

    @Test
    public void whenInitializeAndSetWithSetterMethod_shouldReturnCorrectValue() {
        baseEntity = new BaseEntity();

        baseEntity.setRecorded(false);
        baseEntity.setCreatedOn(LocalDate.of(2020, Month.JANUARY, 1));
        baseEntity.setCreator("admin");
        baseEntity.setUpdatedOn(LocalDate.of(2020, Month.JANUARY, 10));
        baseEntity.setUpdater("user");
        baseEntity.setVersion("2");
        baseEntity.setId(3L);

        assertThat(baseEntity.getUpdater()).isEqualTo("user");
        assertThat(baseEntity.getCreator()).isEqualTo("admin");
        assertThat(baseEntity.getUpdatedOn()).isEqualTo(LocalDate.of(2020, Month.JANUARY, 10));
        assertThat(baseEntity.getCreatedOn()).isEqualTo(LocalDate.of(2020, Month.JANUARY, 1));
        assertThat(baseEntity.getVersion()).isEqualTo("2");
        assertThat(baseEntity.getId()).isEqualTo(3L);
        assertThat(baseEntity.isRecorded()).isFalse();

    }

    private static class BaseEntity extends ABaseIdEntity {

        public BaseEntity() {
        }

        public BaseEntity(Long id) {
            super(id);
        }

        public BaseEntity(String version, LocalDate createdOn, String creator, LocalDate updatedOn, String updater, boolean recorded, Long id) {
            super(version, createdOn, creator, updatedOn, updater, recorded, id);
        }
    }
}
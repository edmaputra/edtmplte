package io.github.edmaputra.edtmplte.domain;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;

public class ABaseIdEntityTest {

    BaseEntity baseEntity;

    @Test
    public void whenInitializeWithoutParams_shouldContainDefaultValue() {
        baseEntity = new BaseEntity();

        assertThat(baseEntity.getUpdater()).isEqualTo("sys");
        assertThat(baseEntity.getCreator()).isEqualTo("sys");
        assertThat(baseEntity.getUpdatedOn()).isNotNull();
        assertThat(baseEntity.getCreatedOn()).isNotNull();
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
        assertThat(baseEntity.getUpdatedOn()).isNotNull();
        assertThat(baseEntity.getUpdatedOn()).isInstanceOf(Instant.class);
        assertThat(baseEntity.getCreatedOn()).isNotNull();
        assertThat(baseEntity.getCreatedOn()).isInstanceOf(Instant.class);
        assertThat(baseEntity.getVersion()).isEqualTo("1");
        assertThat(baseEntity.isRecorded()).isTrue();
        assertThat(baseEntity.getId()).isEqualTo(1L);
    }

    @Test
    public void whenInitializeWithParams_shouldContainDefaultValue() {
        baseEntity = new BaseEntity(
                "2",
                LocalDate.of(2020, Month.JANUARY, 1).atStartOfDay(ZoneId.systemDefault()).toInstant(),
                "admin",
                LocalDate.of(2020, Month.JANUARY, 10).atStartOfDay(ZoneId.systemDefault()).toInstant(),
                "user",
                true,
                1L
        );

        assertThat(baseEntity.getUpdater()).isEqualTo("user");
        assertThat(baseEntity.getCreator()).isEqualTo("admin");
        assertThat(baseEntity.getUpdatedOn()).isEqualTo(LocalDate.of(2020, Month.JANUARY, 10).atStartOfDay(ZoneId.systemDefault()).toInstant());
        assertThat(baseEntity.getCreatedOn()).isEqualTo(LocalDate.of(2020, Month.JANUARY, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        assertThat(baseEntity.getVersion()).isEqualTo("2");
        assertThat(baseEntity.isRecorded()).isTrue();
        assertThat(baseEntity.getId()).isEqualTo(1L);
    }

    @Test
    public void whenInitializeAndSetWithSetterMethod_shouldReturnCorrectValue() {
        baseEntity = new BaseEntity();

        baseEntity.setRecorded(false);
        baseEntity.setCreatedOn(LocalDate.of(2020, Month.JANUARY, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        baseEntity.setCreator("admin");
        baseEntity.setUpdatedOn(LocalDate.of(2020, Month.JANUARY, 10).atStartOfDay(ZoneId.systemDefault()).toInstant());
        baseEntity.setUpdater("user");
        baseEntity.setVersion("2");
        baseEntity.setId(3L);

        assertThat(baseEntity.getUpdater()).isEqualTo("user");
        assertThat(baseEntity.getCreator()).isEqualTo("admin");
        assertThat(baseEntity.getUpdatedOn()).isEqualTo(LocalDate.of(2020, Month.JANUARY, 10).atStartOfDay(ZoneId.systemDefault()).toInstant());
        assertThat(baseEntity.getCreatedOn()).isEqualTo(LocalDate.of(2020, Month.JANUARY, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        assertThat(baseEntity.getVersion()).isEqualTo("2");
        assertThat(baseEntity.getId()).isEqualTo(3L);
        assertThat(baseEntity.isRecorded()).isFalse();

    }

    private static class BaseEntity extends ABaseIdEntity<Long> {

        public BaseEntity() {
        }

        public BaseEntity(Long id) {
            super(id);
        }

        public BaseEntity(String version, Instant createdOn, String creator, Instant updatedOn, String updater, boolean recorded, Long id) {
            super(version, createdOn, creator, updatedOn, updater, recorded, id);
        }
    }
}
package io.github.edmaputra.edtmplte.domain;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;

public class ABaseEntityTest {

    BaseEntity baseEntity;

    Instant instant1;

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
    public void whenInitializeWithParams_shouldContainDefaultValue() {
        baseEntity = new BaseEntity(
                "2",
                LocalDate.of(2020, Month.JANUARY, 1).atStartOfDay(ZoneId.systemDefault()).toInstant(),
                "admin",
                LocalDate.of(2020, Month.JANUARY, 10).atStartOfDay(ZoneId.systemDefault()).toInstant(),
                "user",
                true
        );

        assertThat(baseEntity.getUpdater()).isEqualTo("user");
        assertThat(baseEntity.getCreator()).isEqualTo("admin");
        assertThat(baseEntity.getUpdatedOn()).isEqualTo(LocalDate.of(2020, Month.JANUARY, 10).atStartOfDay(ZoneId.systemDefault()).toInstant());
        assertThat(baseEntity.getCreatedOn()).isEqualTo(LocalDate.of(2020, Month.JANUARY, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        assertThat(baseEntity.getVersion()).isEqualTo("2");
        assertThat(baseEntity.isRecorded()).isTrue();
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

        assertThat(baseEntity.getUpdater()).isEqualTo("user");
        assertThat(baseEntity.getCreator()).isEqualTo("admin");
        assertThat(baseEntity.getUpdatedOn()).isEqualTo(LocalDate.of(2020, Month.JANUARY, 10).atStartOfDay(ZoneId.systemDefault()).toInstant());
        assertThat(baseEntity.getCreatedOn()).isEqualTo(LocalDate.of(2020, Month.JANUARY, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        assertThat(baseEntity.getVersion()).isEqualTo("2");
        assertThat(baseEntity.isRecorded()).isFalse();
    }

    private static class BaseEntity extends ABaseEntity {

        public BaseEntity() {
        }

        public BaseEntity(String version, Instant createdOn, String creator, Instant updatedOn, String updater, boolean recorded) {
            super(version, createdOn, creator, updatedOn, updater, recorded);
        }
    }
}
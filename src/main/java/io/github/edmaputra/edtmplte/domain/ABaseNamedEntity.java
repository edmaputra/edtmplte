package io.github.edmaputra.edtmplte.domain;

import io.github.edmaputra.edtmplte.annotation.Filterable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Entity Abstract Class which extending the {@link ABaseIdEntity}.
 * Use for entity that require extra Name Field
 *
 * @author edmaputra
 * @since 1.0
 */
@MappedSuperclass
public abstract class ABaseNamedEntity extends ABaseIdEntity{

    @NotBlank(message = "Name is Blank. Please Fill the Detail")
    @Column(name = "name", length = 70, nullable = false)
    @Filterable
    private String name;

    public ABaseNamedEntity() {
    }

    public ABaseNamedEntity(@NotBlank(message = "Name is Blank. Please Fill the Detail") String name) {
        this.name = name;
    }

    public ABaseNamedEntity(Long id, @NotBlank(message = "Name is Blank. Please Fill the Detail") String name) {
        super(id);
        this.name = name;
    }

    public ABaseNamedEntity(String version, Date createdOn, String creator, Date updatedOn, String updater, boolean recorded, Long id, @NotBlank(message = "Name is Blank. Please Fill the Detail") String name) {
        super(version, createdOn, creator, updatedOn, updater, recorded, id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ABaseNamedEntity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", version='" + version + '\'' +
                ", createdOn=" + createdOn +
                ", creator='" + creator + '\'' +
                ", updatedOn=" + updatedOn +
                ", updater='" + updater + '\'' +
                ", recorded=" + recorded +
                '}';
    }
}

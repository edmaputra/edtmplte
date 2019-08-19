package io.github.edmaputra.edtmplte.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

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
    private String name;

    public ABaseNamedEntity() {
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

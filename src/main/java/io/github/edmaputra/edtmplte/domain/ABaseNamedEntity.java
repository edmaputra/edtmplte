package io.github.edmaputra.edtmplte.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@Data
@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class ABaseNamedEntity extends ABaseIdEntity{

    @NotBlank(message = "Name is Blank. Please Fill the Detail")
    @Column(name = "name", length = 70, nullable = false)
    private String name;

}

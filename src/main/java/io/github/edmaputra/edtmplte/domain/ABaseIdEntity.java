package io.github.edmaputra.edtmplte.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Entity Abstract Class which extending the {@link ABaseEntity}.
 * Have an ID field for Record's Identifier
 *
 * @author edmaputra
 * @since 1.0
 */
@Data
@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class ABaseIdEntity extends ABaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

}

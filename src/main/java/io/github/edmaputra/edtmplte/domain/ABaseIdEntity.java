package io.github.edmaputra.edtmplte.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Entity Abstract Class which extending the {@link ABaseEntity}.
 * Have an ID field for Record's Identifier
 *
 * @author edmaputra
 * @since 1.0
 */
@MappedSuperclass
public abstract class ABaseIdEntity extends ABaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	public ABaseIdEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ABaseIdEntity{" +
				"id=" + id +
				", version='" + version + '\'' +
				", createdOn=" + createdOn +
				", creator='" + creator + '\'' +
				", updatedOn=" + updatedOn +
				", updater='" + updater + '\'' +
				", recorded=" + recorded +
				'}';
	}
}

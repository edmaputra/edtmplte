package io.github.edmaputra.edtmplte.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

/**
 * Entity Abstract Class which extending the {@link ABaseEntity}.
 * Have an ID field for Record's Identifier
 *
 * @author edmaputra
 * @since 1.0
 */
@MappedSuperclass
public abstract class ABaseIdEntity<T> extends ABaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected T id;

	public ABaseIdEntity() {
	}

	public ABaseIdEntity(T id) {
		this.id = id;
	}

	public ABaseIdEntity(String version, LocalDate createdOn, String creator, LocalDate updatedOn, String updater, boolean recorded, T id) {
		super(version, createdOn, creator, updatedOn, updater, recorded);
		this.id = id;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
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

package io.github.edmaputra.edtmplte.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity Abstract Class as domain for database transaction
 * it's implements {@link Serializable}
 * and use Lombok's {@link Data} and {@link NoArgsConstructor} for reduce boilerplate code.
 *
 * @author edmaputra
 * @since 1.0
 */
@MappedSuperclass
public abstract class ABaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 10)
	protected String version = "1";

	@CreationTimestamp
	@Column(name = "created_on")
	protected Date createdOn = new Date();

	@Column(name = "creator", length = 70)
	protected String creator = "sys";

	@UpdateTimestamp
	@Column(name = "updated_on")
	protected Date updatedOn = new Date();

	@Column(name = "updater", length = 70)
	protected String updater = "sys";

	protected boolean recorded = true;

	public ABaseEntity() {
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public boolean isRecorded() {
		return recorded;
	}

	public void setRecorded(boolean recorded) {
		this.recorded = recorded;
	}

	@Override
	public String toString() {
		return "ABaseEntity{" +
				"version='" + version + '\'' +
				", createdOn=" + createdOn +
				", creator='" + creator + '\'' +
				", updatedOn=" + updatedOn +
				", updater='" + updater + '\'' +
				", recorded=" + recorded +
				'}';
	}
}

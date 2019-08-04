package io.github.edmaputra.edtmplte.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
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
 * @author edmaputra
 * @since 1.0-SNAPSHOT
 * @version 0.0.1
 */
@Data
@MappedSuperclass
@NoArgsConstructor
public abstract class ABaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 10)
	protected String version;

	@CreationTimestamp
	protected Date createdOn;

	@Column(name = "creator", length = 70)
	protected String creator;

	@UpdateTimestamp
	protected Date updatedOn;

	@Column(name = "updater", length = 70)
	protected String updater;

	protected boolean recorded = true;

}

package com.nav.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Table(name="MP_JPA_DOCTOR")
@Entity
@Data
public class DoctorEntity {
	//Data properties
	@SequenceGenerator(name="gen1", sequenceName="DID_SEQ", initialValue=10, allocationSize=1)
	@GeneratedValue(generator="gen1", strategy=GenerationType.SEQUENCE)
	@Id
	private Integer did;
	@Column(length=20)
	private String dname;
	@Column(length=20)
	private String specialization;
	private Double fee;
	@Column(length=30)
	private String qlfy;
	
	//More properties
	@Version
	private Integer uodateCount;
	@CreationTimestamp
	@Column(updatable=false, insertable=true)
	private LocalDateTime creataedOn;
	@CreationTimestamp
	@Column(updatable=true, insertable=false)
	private LocalDateTime lastAccessedOn;
	@Column(length=30)
	private String active_SW = "active";
	@Column(length=30, updatable=false)
	private String createdBy;
	@Column(length=30, insertable=false)
	private String updateBy;
}

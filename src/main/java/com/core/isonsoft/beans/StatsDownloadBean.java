package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "statdownloaders")
public class StatsDownloadBean {

	public int id;
	public Timestamp startDT;
	public Timestamp endDT;
	public double duration;
	public String status;
	public String dataSourceId;
	public String errorMessage;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getStartDT() {
		return startDT;
	}

	public void setStartDT(Timestamp startDT) {
		this.startDT = startDT;
	}

	public Timestamp getEndDT() {
		return endDT;
	}

	public void setEndDT(Timestamp endDT) {
		this.endDT = endDT;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	@Lob
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "StatsDownloadBean [id=" + id + ", startDT=" + startDT
				+ ", endDT=" + endDT + ", duration=" + duration + ", status="
				+ status + ", dataSourceId=" + dataSourceId + ", errorMessage="
				+ errorMessage + "]";
	}

}

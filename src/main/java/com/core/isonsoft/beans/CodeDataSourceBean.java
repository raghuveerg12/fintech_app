package com.core.isonsoft.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "codedatasources")
public class CodeDataSourceBean {

	public int id;
	public String url;
	public String staggingTables;
	public String secondaryTables;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "staggingTable")
	public String getStaggingTables() {
		return staggingTables;
	}

	public void setStaggingTables(String staggingTables) {
		this.staggingTables = staggingTables;
	}

	@Column(name = "secondaryTable")
	public String getSecondaryTables() {
		return secondaryTables;
	}

	public void setSecondaryTables(String secondaryTables) {
		this.secondaryTables = secondaryTables;
	}

	@Override
	public String toString() {
		return "CodeDataSourceBean [id=" + id + ", url=" + url
				+ ", staggingTables=" + staggingTables + ", secondaryTables="
				+ secondaryTables + "]";
	}

}

package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagVirCurExVolume")
public class StagVirCurExVolumeBean {

	public int id;

	public String base;
	public String alt;
	public String value;
	public String status;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StagVirCurExVolumeBean [Id=" + id + ", base=" + base + ", alt="
				+ alt + ", value=" + value + ", status=" + status + "]";
	}

	public StagVirCurExVolumeBean(int id, String base, String alt,
			String value, String status) {
		super();
		this.id = id;
		this.base = base;
		this.alt = alt;
		this.value = value;
		this.status = status;
	}

	public StagVirCurExVolumeBean() {

	}

}

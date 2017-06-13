package com.haoyu.file.domain;

import java.io.Serializable;
import javax.persistence.Transient;
import com.haoyu.sip.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;



@ApiModel(value = "PhysicsFile", description = "")
public class PhysicsFile extends BaseEntity<String> implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	
	
	@ApiModelProperty(value = "")
	private	String	path;
	@ApiModelProperty(value = "")
	private	BigDecimal	size;
	
	private String md5;
	
	public String getPath(){
		return path;
	}
			
	public void setPath(String path){
		this.path = path;
	}
	public BigDecimal getSize(){
		return size;
	}
			
	public void setSize(BigDecimal size){
		this.size = size;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}
	
	

}
package com.haoyu.file.domain;

import java.io.Serializable;
import javax.persistence.Transient;
import com.haoyu.sip.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




@ApiModel(value = "VirtualFile", description = "")
public class VirtualFile extends BaseEntity<String> implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	
	
	@ApiModelProperty(value = "")
	private	String	name;
	@ApiModelProperty(value = "")
	private	String	appId;
	@ApiModelProperty(value = "")
	private	String	searchKey;
	@ApiModelProperty(value = "")
	private	String	physicsFileId;
	@ApiModelProperty(value = "")
	private String relationId;
	@ApiModelProperty(value = "")
	private String checkPath;
	
	public String getName(){
		return name;
	}
			
	public void setName(String name){
		this.name = name;
	}
	public String getAppId(){
		return appId;
	}
			
	public void setAppId(String appId){
		this.appId = appId;
	}
	
	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getPhysicsFileId(){
		return physicsFileId;
	}
			
	public void setPhysicsFileId(String physicsFileId){
		this.physicsFileId = physicsFileId;
	}

	public String getCheckPath() {
		return checkPath;
	}

	public void setCheckPath(String checkPath) {
		this.checkPath = checkPath;
	}

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	
	
	

}
package com.haoyu.file.service;

import java.util.List;

import com.haoyu.file.domain.PhysicsFile;

public interface IPhysicsFileService {
	
	int create(PhysicsFile physicsFile);
	
	int update(PhysicsFile physicsFile);
	
	int deletePhysicsById(String id);
	
	PhysicsFile findById(String id);
	
	List<PhysicsFile> findByEntity(PhysicsFile physicsFile);
	
	PhysicsFile findByMd5(String md5);

}

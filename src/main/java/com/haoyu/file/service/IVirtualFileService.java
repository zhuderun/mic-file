package com.haoyu.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.haoyu.file.domain.VirtualFile;
import com.haoyu.sip.domain.Response;

public interface IVirtualFileService {
	
	VirtualFile upload(String appId,String relationId,String name,MultipartFile file);
	
	Response updateCheckPath(String id,String checkPath);
	
	int deletePhysicsById(String id);
	
	VirtualFile findById(String id);
	
	List<VirtualFile> findBySearchKet(String searchKey);
	
}

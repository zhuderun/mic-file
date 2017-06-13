package com.haoyu.file.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.haoyu.file.domain.PhysicsFile;
import com.haoyu.file.domain.VirtualFile;
import com.haoyu.file.event.CreateVirtualFileEvent;
import com.haoyu.file.event.DeleteVirtualFileEvent;
import com.haoyu.file.event.UpdateVirtualFileCheckPathEvent;
import com.haoyu.file.service.IPhysicsFileService;
import com.haoyu.file.service.IVirtualFileService;
import com.haoyu.sip.domain.Response;
import com.haoyu.sip.service.BaseService;

@Service
public class VirtualFileService extends BaseService<VirtualFile, String> implements IVirtualFileService{
	@Resource
	private IPhysicsFileService physicsFileService;
	@Resource
	private IVirtualFileService virtualFileService;
	@Resource
	private ApplicationContext applicationContext;
	
	

	@Override
	public int create(VirtualFile entity) {
		if(StringUtils.isEmpty(entity.getId())){
			entity.setId(UUID.randomUUID().toString());
		}
		return super.create(entity);
	}


	@Override
	public VirtualFile upload(String appId, String relationId,String name,MultipartFile file) {
		if(file ==null || StringUtils.isAnyEmpty(appId,relationId)){
			return null;
		}
		PhysicsFile pf = physicsFileService.findByMd5(fileMd5(file));
		if(pf == null){
			//如果没有物理文件，先保存起来
			pf = new PhysicsFile();
			pf.setId(UUID.randomUUID().toString());
		}
		String fileName = StringUtils.isNotEmpty(name)?name:file.getName();
		VirtualFile vf = new VirtualFile();
		vf.setPhysicsFileId(pf.getId());
		vf.setAppId(appId);
		vf.setSearchKey(relationId);
		vf.setRelationId(relationId);
		vf.setName(fileName);
		int count = create(vf);
		if(count>0){
			applicationContext.publishEvent(new CreateVirtualFileEvent(vf));
		}
		return count>0?vf:null;
	}
	
	
	private String fileMd5(MultipartFile file){
		return "";
	}


	@Override
	public Response updateCheckPath(String id, String checkPath) {
		VirtualFile vf = new VirtualFile();
		vf.setId(id);
		vf.setCheckPath(checkPath);
		int count = this.update(vf);
		if(count>0){
			applicationContext.publishEvent(new UpdateVirtualFileCheckPathEvent(vf));
		}
		return count>0?Response.successInstance():Response.failInstance();
	}


	@Override
	public List<VirtualFile> findBySearchKet(String searchKey) {
		if(StringUtils.isNotEmpty(searchKey)){
			VirtualFile vf = new VirtualFile();
			vf.setSearchKey(searchKey);
			return findByEntity(vf);
		}
		return null;
	}


	@Override
	public int deletePhysicsById(String id) {
		if(StringUtils.isNotEmpty(id)){
			VirtualFile vf = super.findById(id);
			int count = super.deletePhysicsById(id);
			if(count>0){
				applicationContext.publishEvent(new DeleteVirtualFileEvent(vf));
			}
			return count;
		}
		return 0;
	}
	
	

}
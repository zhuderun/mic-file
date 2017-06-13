package com.haoyu.file.service.impl;

import org.springframework.stereotype.Service;
import com.haoyu.file.domain.PhysicsFile;
import com.haoyu.file.service.IPhysicsFileService;
import com.haoyu.sip.service.BaseService;

@Service
public class PhysicsFileService extends BaseService<PhysicsFile, String> implements IPhysicsFileService{

	/* (non-Javadoc)
	 * @see com.haoyu.file.service.IPhysicsFileService#findByMd5(java.lang.String)
	 */
	@Override
	public PhysicsFile findByMd5(String md5) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
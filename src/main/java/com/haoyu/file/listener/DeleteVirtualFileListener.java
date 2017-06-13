/**
 * 
 */
package com.haoyu.file.listener;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

import com.haoyu.file.domain.VirtualFile;
import com.haoyu.file.event.DeleteVirtualFileEvent;

/**
 * @author Administrator
 *
 */
public class DeleteVirtualFileListener implements ApplicationListener<DeleteVirtualFileEvent>{

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	
	private Logger logger = LoggerFactory.getLogger(CreateVirtualFileListener.class);
	
	@Override
	public void onApplicationEvent(DeleteVirtualFileEvent event) {
		//检查该虚拟文件对应的物理文件还有没有被其他虚拟文件引用，没有则删除该物理文件
		if(event.getSource()!=null){
			VirtualFile vf = (VirtualFile) event.getSource();
			String physicsFileId = vf.getPhysicsFileId();
			if(StringUtils.isNotEmpty(physicsFileId)){
				
			}
			
		}
		
	}
	
	

}

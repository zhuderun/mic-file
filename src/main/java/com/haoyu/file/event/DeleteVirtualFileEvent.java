/**
 * 
 */
package com.haoyu.file.event;

import org.springframework.context.ApplicationEvent;

import com.haoyu.file.domain.VirtualFile;

/**
 * @author Administrator
 *
 */
public class DeleteVirtualFileEvent extends ApplicationEvent{

	public DeleteVirtualFileEvent(VirtualFile source) {
		super(source);
	}

	private static final long serialVersionUID = 7045819402436014822L;

}

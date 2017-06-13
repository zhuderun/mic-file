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
public class CreateVirtualFileEvent extends ApplicationEvent{
	public CreateVirtualFileEvent(VirtualFile source) {
		super(source);
	}

	private static final long serialVersionUID = -5080239704695283891L;

}

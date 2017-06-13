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
public class UpdateVirtualFileCheckPathEvent extends ApplicationEvent{

	/**
	 * @param source
	 */
	public UpdateVirtualFileCheckPathEvent(VirtualFile source) {
		super(source);
	}

	private static final long serialVersionUID = -9065746040445820979L;

}

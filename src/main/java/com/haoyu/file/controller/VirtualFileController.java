package com.haoyu.file.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.haoyu.sip.controller.BaseRestController;
import com.haoyu.sip.domain.Response;
import com.haoyu.file.domain.VirtualFile;
import com.haoyu.file.service.IVirtualFileService;

import io.swagger.annotations.Api;

@RefreshScope
@Api(tags={"附件接口"})
@RestController
@RequestMapping("/v1/file")
public class VirtualFileController extends BaseRestController<VirtualFile, String>{
	
	@Autowired
	private IVirtualFileService virtualFileService;
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public VirtualFile uploadFile(String appId,String relationId,String name,MultipartFile file){
		return virtualFileService.upload(appId, relationId,name, file);
	}
	
//	@RequestMapping(value = "upload", method = RequestMethod.POST)
//	public VirtualFile uploadFile(String appId,String relationId,HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "files[]", required = false) MultipartFile[] files){
//		
//		
//		return null;
//	}
	
//	@RequestMapping(value = "{id}" , method=RequestMethod.DELETE)
//	public int deleteFile(@PathParam(value = "id") String id){
//		return virtualFileService.deletePhysicsById(id);
//	}
	
	@RequestMapping(value = "{id}/init_check_path",method=RequestMethod.PUT)
	public Response initCheckPath(@PathVariable String id,String checkPath){
		return virtualFileService.updateCheckPath(id, checkPath);
	}

}

package org.shrio.controller;

import org.shrio.shiro.CustomRelamDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * <p>Title: ClearShiroCache</p>
 * <p>Description: 手动调用controller清除shiro的缓存</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-25下午4:26:14
 * @version 1.0
 */
@Controller
public class ClearShiroCache {
	
	//注入realm
	@Autowired
	private CustomRelamDb customRelamDb;
	
	@RequestMapping("/clearShiroCache")
	public String clearShiroCache(){
		//清除缓存，将来正常开发要在service调用customRealm.clearCached()
		customRelamDb.clearCached();
		return "success";
	}

}

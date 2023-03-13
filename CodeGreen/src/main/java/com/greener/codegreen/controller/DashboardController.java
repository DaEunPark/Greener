package com.greener.codegreen.controller;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.greener.codegreen.dto.ProductViewDTO;
import com.greener.codegreen.service.AdminService;

@Controller 
@RequestMapping("/admin/*")
public class DashboardController {

    @Inject 
    AdminService adminService;
	
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	

	  //목록 불러오기
	  @RequestMapping(value="/dashproductview", method = RequestMethod.GET)
	    public String DashProductview(Model model)throws Exception{
		  
		  logger.info("화면불러오기");
		  
		return "/admin/dash/DashProductView";
	    }
	  
	    @ResponseBody 
	    @RequestMapping(value="/dashproductview", method = RequestMethod.POST)
	    public String dashproductviewpost(Model model) throws Exception {
	        
	    List<ProductViewDTO>list = adminService.DashProductview();
	    //gson객체 생성
	        Gson gson = new Gson();
	        JsonArray jArray = new JsonArray();
	   
	        
	        Iterator<ProductViewDTO> it = list.iterator();
	        while(it.hasNext()) {
	        	ProductViewDTO productViewDTO = it.next();
	            JsonObject object = new JsonObject();
	            String c_name = productViewDTO.getC_name();
	            int p_view = productViewDTO.getP_view();
	            
	            object.addProperty("c_name", c_name);
	            object.addProperty("p_view", p_view);
	            jArray.add(object);
	        }
	        
	        String json = gson.toJson(jArray);
	        logger.info("json변환: "+json);
	        
	        return json;
	    }

}

package com.greener.codegreen.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.greener.codegreen.common.UploadFileUtils;
import com.greener.codegreen.dto.CategoryDTO;
import com.greener.codegreen.dto.ProductDTO;
import com.greener.codegreen.service.AdminService;

@Controller("adminController")
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	

 @Resource(name="uploadPath")
	private String uploadPath;
 
	/**
	 * Admin Index Page
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get index");
	}
	
	/*
	 * Product List
	 */
	@RequestMapping(value = "/product/list")
	public String productList() throws Exception {
		
		return "/admin/product/list";
	}
	/*
	 * Admin Product Register
	 */
	@RequestMapping(value = "/product/register", method = RequestMethod.GET)
	public void getProductRegister(Model model) throws Exception {
		logger.info("get product register");
		
		List<CategoryDTO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	// 상품 등록
	@RequestMapping(value = "/product/register", method = RequestMethod.POST)
	public String postProductRegister(ProductDTO dto, MultipartFile file) throws Exception{
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		dto.setP_img(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		dto.setP_thumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		
		adminService.register(dto);
		
		
		return "redirect:/";
	}
	// --------------------------------------------------------------------------
	// ck 에디터에서 파일 업로드
	// --------------------------------------------------------------------------
 @RequestMapping(value="/product/ckUpload", method = RequestMethod.POST)
 public void ckEditorImgUpload(HttpServletRequest req, HttpServletResponse res,
		 												@RequestParam MultipartFile upload) throws Exception{

			 // 랜덤 문자 생성
			 UUID uid = UUID.randomUUID();
			 
			 OutputStream out = null;
			 PrintWriter printWriter = null;
			   
			 // 인코딩
			 res.setCharacterEncoding("utf-8");
			 res.setContentType("text/html;charset=utf-8");
			 
			 try {
			  
			  String fileName = upload.getOriginalFilename();  // 파일 이름 가져오기
			  byte[] bytes = upload.getBytes();
			  
			  // 업로드 경로
			  String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
			  
			  out = new FileOutputStream(new File(ckUploadPath));
			  out.write(bytes);
			  out.flush();  // out에 저장된 데이터를 전송하고 초기화
			  
			  String callback = req.getParameter("CKEditorFuncNum");
			  printWriter = res.getWriter();
			  String fileUrl = "/ckUpload/" + uid + "_" + fileName;  // 작성화면
			  
			  // 업로드시 메시지 출력
			  printWriter.println("<script type='text/javascript'>"
			     + "window.parent.CKEDITOR.tools.callFunction("
			     + callback+",'"+ fileUrl+"','이미지를 업로드하였습니다.')"
			     +"</script>");
			  
			  printWriter.flush();
			  
			 } catch (IOException e) { e.printStackTrace();
			 } finally {
			  try {
			   if(out != null) { out.close(); }
			   if(printWriter != null) { printWriter.close(); }
			  } catch(IOException e) { e.printStackTrace(); }
			 }
			 
			 return; 
		 }
	
}

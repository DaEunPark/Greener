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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.greener.codegreen.common.UploadFileUtils;
import com.greener.codegreen.dto.CategoryDTO;
import com.greener.codegreen.dto.ProductDTO;
import com.greener.codegreen.dto.ProductViewDTO;
import com.greener.codegreen.service.AdminService;

@Controller("adminController")
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	ProductDTO productDTO;
	@Inject
	AdminService adminService;

	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	
	
	// ---------------------------------------------------------------------------------------
	// 누적판매량 상위 10개 상품 전시(시훈)
	// ---------------------------------------------------------------------------------------
	@PostMapping(value="product")
	@CrossOrigin(origins="http://localhost:8080")
	@ResponseBody
	public List<ProductDTO> top10products(@RequestBody ProductDTO product) throws Exception {
		List<ProductDTO> productList = adminService.top10products();
		return productList;
	} // top10products()
	
	
	
	
	
	/**
	 * 愿�由ъ옄 �럹�씠吏�
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get index");
	}

	/*
	 * �긽�뭹 �벑濡�
	 */
	@RequestMapping(value = "/product/register", method = RequestMethod.GET)
	public void getProductRegister(Model model) throws Exception {
		logger.info("get product register");
		
		List<CategoryDTO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	// 상품등록
	@RequestMapping(value = "/product/register", method = RequestMethod.POST)
	public String postProductRegister( ProductDTO dto, MultipartFile file) throws Exception{

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else{
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		dto.setP_img(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		dto.setP_thumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
	
		adminService.productRegister(dto);
		
		return "redirect:/admin/product/list";
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

 
	// 상품 목록
	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public void getProductList(Model model) throws Exception{
		logger.info("get product list");
		
		List<ProductViewDTO> list = adminService.productList();
		model.addAttribute("list", list);
	}
	
	// 상품 상세 보기
	@RequestMapping(value = "/product/view", method = RequestMethod.GET)
	public void getProductView(@RequestParam("n") int p_number, Model model) throws Exception{
		logger.info("get product view");
		
		ProductViewDTO product = adminService.productView(p_number);
		logger.info("*** getProductView() => " + product);
		model.addAttribute("product", product);
	}
	
	// 상품 수정
	@RequestMapping(value = "/product/modify", method = RequestMethod.GET)
	public void getProductModify(@RequestParam("n") int p_number, Model model) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 p_number에 저장
		
		logger.info("get product modify");
		
		ProductViewDTO product = adminService.productView(p_number);  // productViewDTO 형태 변수 product에 상품 정보 저장
		model.addAttribute("product", product);
		
		List<CategoryDTO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	// 상품 수정
	@RequestMapping(value = "/product/modify", method = RequestMethod.POST)
	public String postProductModify( ProductDTO dto, MultipartFile file) throws Exception{

		logger.info("post product modify");
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else{
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		dto.setP_img(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		dto.setP_thumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		adminService.productModify(dto);
		
		
		return "redirect:/admin/product/list";

		
	}
	
	// 상품 삭제
	@RequestMapping(value = "/product/delete", method = RequestMethod.POST)
	public String postProductDelete(@RequestParam("n") int p_number) throws Exception{
		logger.info("post product delete");
		
		adminService.productDelete(p_number);
		
		return "redirect:/admin/product/list";
	}
	
}

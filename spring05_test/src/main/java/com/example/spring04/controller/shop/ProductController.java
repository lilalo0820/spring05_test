package com.example.spring04.controller.shop;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring04.model.shop.ProductDAO;
import com.example.spring04.model.shop.ProductDTO;

@Controller
@RequestMapping("/shop/product/*")
public class ProductController {
	@Inject 
	ProductDAO productDao;
	
	@RequestMapping("write.do")
	public String write() {
		return "shop/product_write";
	}
	
	@RequestMapping("insert.do")
	public String insert(ProductDTO dto, HttpServletRequest request) {
		String filename = "-";	// 첨부파일이 없을 때 임시로 "-" 로 지정
		if(!dto.getFile1().isEmpty()) { //첨부파일이 있을 때
			filename = dto.getFile1().getOriginalFilename(); //파일이름
			
			try {
				
				// application 서버 전체에서 고유하기 위한 객체 생성
				ServletContext application = request.getSession().getServletContext();
				// 실제 서비스 경로( 배포 위치)
//				상품이미지 urls
				String path = application.getRealPath("/WEB-INF/views/images/");
				// 폴더 없을경우 폴더 생성
				new File(path).mkdir();
				// 서버내 임시 저장된 파일(dto.getFile1())을 희망하는 위치로 이동
				dto.getFile1().transferTo(new File(path +  filename));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dto.setFilename(filename);
		productDao.insert(dto);
		return "redirect:/shop/product/list.do";
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/shop/product_list");
		mav.addObject("list", productDao.list());
		return mav;
	}
	
	@RequestMapping("edit/{product_code}")
	public ModelAndView edit(ModelAndView mav, @PathVariable int product_code) {
		ProductDTO dto = productDao.detail(product_code);
		mav.setViewName("/shop/product_edit");
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping("detail/{product_code}")
	public ModelAndView detail(ModelAndView mav, @PathVariable int product_code) {
		ProductDTO dto = productDao.detail(product_code);
		mav.setViewName("/shop/product_detail");
		mav.addObject("dto", dto);
		return mav;
	}
	
	
	@RequestMapping("update.do")
	public String edit(ProductDTO dto, HttpServletRequest request) {
		String filename = "-";
		if(!dto.getFile1().isEmpty()) { //첨부파일이 있을 때
			filename = dto.getFile1().getOriginalFilename(); //파일이름
			
			try {
				
				// application 서버 전체에서 고유하기 위한 객체 생성
				ServletContext application = request.getSession().getServletContext();
				// 실제 서비스 경로( 배포 위치)
//				상품이미지 urls
				String path = application.getRealPath("/WEB-INF/views/images/");
				// 폴더 없을경우 폴더 생성
				new File(path).mkdir();
				// 서버내 임시 저장된 파일(dto.getFile1())을 희망하는 위치로 이동
				dto.getFile1().transferTo(new File(path +  filename));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setFilename(filename);
		}else {
			ProductDTO dto2 = productDao.detail(dto.getProduct_code());
			dto.setFilename(dto2.getFilename());
		}
		productDao.update(dto);
		return "redirect:/shop/product/list.do";
	}
	
	@RequestMapping("delete.do/{product_code}")
	public String delete(ModelAndView mav, @PathVariable int product_code, HttpServletRequest request) {
		String filename = productDao.file_info(product_code);
		if(filename != null && !filename.contentEquals("-")) {
			ServletContext application = request.getSession().getServletContext();
			String path = application.getRealPath("WEB-INF/views/images/");
			File f = new File(path + filename);
			if(f.exists()) {
				f.delete();
			}
		}
		productDao.delete(product_code);
		return "redirect:/shop/product/list.do";
	}
	
}

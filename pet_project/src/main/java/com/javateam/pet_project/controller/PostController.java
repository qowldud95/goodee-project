package com.javateam.pet_project.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javateam.pet_project.dto.Member;
import com.javateam.pet_project.entity.Comment;
import com.javateam.pet_project.entity.CommentDto;
import com.javateam.pet_project.entity.Shop;
import com.javateam.pet_project.entity.ShopDto;
import com.javateam.pet_project.service.MemberService;
import com.javateam.pet_project.service.ShopService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PostController {

	@Autowired
	private ShopService service;

	@Autowired
	private MemberService memberService;

	/*
	 * localhost:8383/post 
	 * shop - myposts - 글쓰기
	 */
	@RequestMapping(value = "post", method = RequestMethod.GET)
	public String post() {
		return "post";
	}

	@RequestMapping(value = "/postAction", method = RequestMethod.POST)
	public String postAction( ShopDto shop) throws IllegalStateException, IOException {

		log.info("postAction");
		log.info("shop:" + shop);

		log.info("filepath:" + shop.getProductImage().getOriginalFilename());

		String PATH = "C:/baezzi/goodee/works/java1/pet_project/src/main/resources/static/images/";

		if (!shop.getProductImage().getOriginalFilename().isEmpty()) {
			shop.getProductImage().transferTo(new File(PATH + shop.getProductImage().getOriginalFilename()));
		}

		Calendar c = Calendar.getInstance();

		service.productInsert(new Shop(shop.getProductNumber(), shop.getProductName(), shop.getProductPrice(),
				shop.getProductDescription(), shop.getSeller(), c.getTime(),
				shop.getProductImage().getOriginalFilename(), shop.getPetType(), shop.getProductCategory()));

		return "redirect:/myPostView";

	}


	/*
	 * localhost:8383/myPostView 
	 * shop - myposts - 내글목록
	 * 
	 */
	@RequestMapping("/myPostView")
	public String myPostview(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();

		Integer loginedMemberId = (Integer) session.getAttribute("loginedMemberId");
		
		log.info("sessionLoginId " + loginedMemberId);
		
		Member member = memberService.getMemberById(loginedMemberId);
		request.setAttribute("loginedId", member.getMemberId());
		
		log.info("loginedId " + member.getMemberId());
		String loginedId = member.getMemberId();

		 List<Shop> list = service.getListBySeller(loginedId); //mylist로 바꿔주기

		 model.addAttribute("list",list);
		 
		 log.info("list" + list);
		return "myPostView";
	}

	/*
	 * localhost:8383/myPostUpdate 
	 * shop - myposts - 내글목록 - 수정하기
	 * 
	 */
	@RequestMapping("/myPostUpdate")
	public String myPostUpdate(@RequestParam("productName") String productName, Model model) {
		log.info("productName : " + productName);
		List<Shop> list = service.getListDetail(productName);
		model.addAttribute("list", list);
		return "myPostUpdate";
	}

	@RequestMapping(value = "/postUpdateAction", method = RequestMethod.POST)
	public String postUpdateAction(HttpServletRequest request, HttpServletResponse response, ShopDto shop) throws IllegalStateException, IOException {

		log.info("postUpdateAction");
		log.info("shop:" + shop);

		log.info("filepath:" + shop.getProductImage().getOriginalFilename());

		String PATH = "C:/baezzi/goodee/works/java1/pet_project/src/main/resources/static/images/";

		if (!shop.getProductImage().getOriginalFilename().isEmpty()) {
			shop.getProductImage().transferTo(new File(PATH + shop.getProductImage().getOriginalFilename()));
		}

		Calendar c = Calendar.getInstance();

		service.productUpdate(new Shop(shop.getProductNumber(), shop.getProductName(), shop.getProductPrice(),
				shop.getProductDescription(), "baejiyoung", c.getTime(), shop.getProductImage().getOriginalFilename(),
				shop.getPetType(), shop.getProductCategory()));

		return "redirect:/myPostView";

	}

	/*
	 * localhost:8383/myPostUpdate 내글목록 - 상품삭제
	 */
	@RequestMapping("/myPostDelete")
	public String myPostDelete(@RequestParam("productName") String productName, Model model,
			HttpServletResponse response) {
		log.info("productName : " + productName);
		service.productDelete(productName);

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script>alert('삭제되었습니다'); location.href='/myPostView'; </script>");
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/myPostView";

	}
	@RequestMapping(value = "/commentAction", method = RequestMethod.POST)
	public String commentAction(CommentDto comment) {
		
		log.info("commentAction");
		log.info("commentDto:" + comment);
		
		service.commentInsert(new Comment(comment.getCommentNumber(), comment.getMemberId(), comment.getMemberNickname(), comment.getMessage(), comment.getWriteDate(), comment.getProductName())); 
				
		
		//return "redirect:/shopDetail?productName={}";
		return "redirect:/myPostView";
	}
}
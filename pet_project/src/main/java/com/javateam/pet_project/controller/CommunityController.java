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
import com.javateam.pet_project.entity.Pet;
import com.javateam.pet_project.entity.Shop;
import com.javateam.pet_project.entity.Walkingroute;
import com.javateam.pet_project.entity.WalkingrouteDto;
import com.javateam.pet_project.service.MemberService;
import com.javateam.pet_project.service.PetService;
import com.javateam.pet_project.service.RouteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("CommunityController")
public class CommunityController {
	
	@Autowired
	PetService petService;
	
	@Autowired
	RouteService routeService;
	
	@Autowired
	private MemberService memberService;

	/*
	 * localhost:8383/petShow
	 * commnunity - 펫자랑하기
	 */
	@RequestMapping("/petShow") 
	public String PetShow(Model model) {
		
		List<Pet> list = petService.getListPetShow();
		
		model.addAttribute("list", list);
		
		log.info("petShowList : " + list);
		
		return "petShow";
	}
	
	
	/*
	 * localhost:8383/petShowDetail
	 * commnunity - 펫자랑하기 - 상세보기
	 */
	@RequestMapping("/petShowDetail")
	public String petShowDatail(HttpServletRequest request, @RequestParam("petName") String petName, Model model ) {
		
		log.info("petName : " + petName);
		Pet pet = petService.getListPetShowDetail(petName);
		
		log.info("petShowDetail petName : " + pet);
		
		model.addAttribute("pet", pet);
		
		return "petShowDetail";
	}
	
	/*
	 * localhost:8383/petWalkingInfo
	 * commnunity - 펫산책정보 
	 */
	@RequestMapping("/petWalkingInfo")
	public String petWalkingInfo(Model model) {
		List<Walkingroute> list = routeService.getList();
		
		log.info("펫산책경로 list : " + list);
		model.addAttribute("list", list);
		
		return "petWalkingInfo";
	}
	/*
	 * localhost:8383/petWalkingDetail
	 * commnunity - 펫산책정보 - 상세보기
	 */
	@RequestMapping("/petWalkingDetail")
	public String petWalkingDetail(HttpServletRequest request, @RequestParam("routeNumber") int routeNumber, Model model ) {
		log.info("routeNumber : " + routeNumber);
		
		Walkingroute route = routeService.getListByRouteNumber(routeNumber);
		
		log.info("routeDetail route : " + route);
		
		HttpSession session = request.getSession();

		Integer loginedMemberId = (Integer) session.getAttribute("loginedMemberId");
		
		log.info("sessionLoginId " + loginedMemberId);
		
		Member member = memberService.getMemberById(loginedMemberId);
		request.setAttribute("loginedId", member.getMemberId());
		
		log.info("loginedId " + member.getMemberId());
		String loginedId = member.getMemberId();
		
		log.info("route.getWriter() : " +  route.getWriter());
		
		model.addAttribute("route", route);
		
		if(route.getWriter().equals(loginedId)) {
			return "petWalkingDetailMypost";
		}
		
		return "petWalkingDetail";
	}
	
	/*
	 * localhost:8383/petWalkingUpdate
	 * commnunity - 펫산책정보 -수정하기 
	 */
	@RequestMapping("/petWalkingUpdate")
	public String petWalkingUpdate(@RequestParam("routeNumber") int routeNumber, Model model) {
		log.info("petWalkingUpdate!!!!!!!!!");
		log.info("routeNumber : " + routeNumber);
		Walkingroute route = routeService.getListByRouteNumber(routeNumber);
		log.info("route : " + route);
		model.addAttribute("route", route);
		return "petWalkingUpdate";
	}
	
	@RequestMapping(value = "/petWalkingUpdateAction", method = RequestMethod.POST)
	public String petWalkingUpdateAction(WalkingrouteDto walkingroute)throws IllegalStateException, IOException {
		log.info("petWalkingUpdateAction!!!!!!!!!!");
		log.info("walkingrouteDto = " + walkingroute); 
		
		log.info("filepath:" + walkingroute.getRouteImage().getOriginalFilename());

		String PATH = "C:/baezzi/goodee/works/java1/pet_project/src/main/resources/static/images/";

		if (!walkingroute.getRouteImage().getOriginalFilename().isEmpty()) {
			walkingroute.getRouteImage().transferTo(new File(PATH + walkingroute.getRouteImage().getOriginalFilename()));
		}

		Calendar c = Calendar.getInstance();

		routeService.routeUpdate(new Walkingroute(walkingroute.getRouteNumber(),walkingroute.getRouteName(), walkingroute.getRouteDistance(), walkingroute.getRouteStart(), walkingroute.getRouteEnd(), walkingroute.getRouteDescription(), walkingroute.getWriter(), c.getTime(), walkingroute.getRouteImage().getOriginalFilename()));
		
		return "redirect:/petWalkingInfo";
	}
	/*
	 * localhost:8383/petWalkingPost
	 * commnunity - 펫산책정보 - 등록하기
	 */
	@RequestMapping(value = "petWalkingPost", method = RequestMethod.GET)
	public String petWalkingPost() {
		return "petWalkingPost";
	}
	@RequestMapping(value = "petWalkingPostAction", method = RequestMethod.POST)
	public String petWalkingPostAction(WalkingrouteDto walkingroute) throws IllegalStateException, IOException {
		
		log.info("petWalkingPostAction!!!!!!!!!!!!!!!!!");
		log.info("walkingroute:" + walkingroute);
		
		String PATH = "C:/baezzi/goodee/works/java1/pet_project/src/main/resources/static/images/";

		if (!walkingroute.getRouteImage().getOriginalFilename().isEmpty()) {
			walkingroute.getRouteImage().transferTo(new File(PATH + walkingroute.getRouteImage().getOriginalFilename()));
		}

		Calendar c = Calendar.getInstance();

		routeService.routeInsert(new Walkingroute(walkingroute.getRouteNumber(), walkingroute.getRouteName(), walkingroute.getRouteDistance(),
				walkingroute.getRouteStart(), walkingroute.getRouteEnd(), walkingroute.getRouteDescription(), walkingroute.getWriter(), c.getTime(),
				walkingroute.getRouteImage().getOriginalFilename() ));

		return "redirect:/petWalkingInfo";
	}
	
	/*
	 * localhost:8383/petWalkingDelete
	 * commnunity - 펫산책정보 -삭제하기 
	 */
	@RequestMapping("/petWalkingDelete")
	public String petWalkingDelete(@RequestParam("routeNumber") int routeNumber, HttpServletResponse response) {
		log.info("petWalkingDelete");
		routeService.petWalkingDelete(routeNumber);
		
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script>alert('삭제되었습니다'); location.href='/petWalkingInfo'; </script>");
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/petWalkingInfo";
	}
	
}

package com.wg.p1.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wg.p1.model.MemberVO;
import com.wg.p1.service.MemberServiceImpl;

import oracle.net.aso.s;

@Controller
@RequestMapping(value = "member/**")
public class MemberController {
	
	@Inject
	private MemberServiceImpl memberService;
	
	@GetMapping(value = "join")
	public void memberJoin(List<MemberVO> ar) throws Exception{
	
		
	}

	@GetMapping("facebook")
	public ModelAndView facebook(String name,String email, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO= new MemberVO();
		memberVO.setName(name);
		memberVO.setEmail(email);
		memberVO.setSocial("f");
		memberVO.setM_pk(memberVO.getSocial()+"_"+memberVO.getEmail());
		int result = memberService.socialJoin(memberVO);
		
		if(result>0) {

			session.setAttribute("memberVO", memberVO);
		}
		mv.addObject("result", result);
		mv.setViewName("common/common_ajaxResult");
		
		return mv;
	}
	
	
	
	@GetMapping("kakao")
	public ModelAndView kakao(String nickname,String email, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO= new MemberVO();
		memberVO.setName(nickname);
		memberVO.setEmail(email);
		memberVO.setSocial("k");
		memberVO.setM_pk(memberVO.getSocial()+"_"+memberVO.getEmail());
		int result = memberService.socialJoin(memberVO);
		
		 if(result>0) { 
			 session.setAttribute("memberVO", memberVO); 
		 }
		 
		  mv.addObject("result", result);
		  mv.setViewName("common/common_ajaxResult");
		 
		return mv;
	}
	
	
	
	
	@PostMapping(value = "join")
	public ModelAndView memberJoin(MemberVO memberVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
	
		memberVO.setSocial("w");
		memberVO.setM_pk(memberVO.getSocial()+"_"+memberVO.getEmail());
		int result = memberService.memberJoin(memberVO);
		
		String msg="가입실패";
		if(result>0) {
			msg="가입성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "../");
		mv.setViewName("common/common_result");
		memberService.memberLogin(memberVO);
		return mv;
	}
	
	@GetMapping(value = "login")
	public void memberLogin() throws Exception{
		
	}
	
	@PostMapping(value = "login")
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session) throws Exception {
		
		memberVO = memberService.memberLogin(memberVO);
		
		String msg="로그인실패";
		if(memberVO!=null) {
			msg="로그인성공";
			session.setAttribute("memberVO", memberVO);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberVO", memberVO);
		mv.addObject("msg", msg);
		mv.addObject("path", "../");
		mv.setViewName("common/common_result");
				
		return mv;
	}
	
	@RequestMapping(value = "logout")
	public String memberLogout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:../";
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView memberUpdate(MemberVO memberVO, HttpSession session) throws Exception{
		
		int result = memberService.memberUpdate(memberVO);
		
		ModelAndView mv = new ModelAndView();
		
		String msg="수정실패";
		if(result>0) {
			msg="수정성공";
			session.setAttribute("memberVO", memberVO);
		}
		mv.addObject("msg", msg);		
		mv.addObject("path", "../my/mypage");
		mv.setViewName("common/common_result");
		
		return mv;
		
	}
	
	@GetMapping(value = "memberDelete")
	public ModelAndView memberDelete(MemberVO memberVO) throws Exception{
		int result= memberService.memberDelete(memberVO);
		ModelAndView mv = new ModelAndView();
		
		String msg="탈퇴실패";
		if(result>0) {
			msg="탈퇴성공";
			
		}
		mv.addObject("msg", msg);		
		mv.addObject("path", "../");
		mv.setViewName("common/common_result");
		
		return mv;
		
	}
	
}
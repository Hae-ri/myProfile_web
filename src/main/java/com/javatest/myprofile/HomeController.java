package com.javatest.myprofile;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatest.myprofile.dao.IDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value="/join")
	public String join() {
		
		return "join";
	}
	
	@RequestMapping(value="/profile")
	public String profile() {
		
		return "profile";
	}

	@RequestMapping(value="/question")
	public String question() {
		
		return "question";
	}
	
	@RequestMapping(value="/contact")
	public String contact() {
		
		return "contact";
	}
	
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String joinOk(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		int checkIdFlag = dao.checkIdDao(request.getParameter("id")); // join.jsp에서 입력받은 아이디가 DB에 존재하면 1, 아니면 0 반환
		model.addAttribute("checkIdFlag", checkIdFlag); // checkIdFlag=1이면 아이디 사용 중, 0이면 신규 가입가능
		
		if(checkIdFlag != 1 ) {
			dao.joinDao(request.getParameter("id"), request.getParameter("pw"), request.getParameter("name"), request.getParameter("email"));
			
			HttpSession session = request.getSession();
			session.setAttribute("id", request.getParameter("id")); // 가입 성공된 아이디를 세션에 저장하여 로그인까지 하게 함
			
			model.addAttribute("mid", request.getParameter("id"));
			model.addAttribute("mname", request.getParameter("name"));
		}
		
		return "joinOk";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		
		return "logout";
	}
}

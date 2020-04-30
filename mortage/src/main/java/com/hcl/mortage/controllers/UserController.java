package com.hcl.mortage.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.mortage.exceptions.LoginException;
import com.hcl.mortage.exceptions.RegisterExceptions;
import com.hcl.mortage.models.UserDetail;
import com.hcl.mortage.services.UserService;
import com.mysql.cj.Session;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	/* request for for register */
	@RequestMapping(value = "register")
	String viewRegisterForm() {

		return "register";

	}

	/* requesting parameters of register from form */

	@RequestMapping(value = "registeruser", method = RequestMethod.POST)
	String saveUserRegister(Model model, @RequestParam("confirmpassword") String confirmpassword,
			@RequestParam("password") String password, HttpServletRequest request) {
		try {

			if (password.equals(confirmpassword)) {

				UserDetail userDetail = new UserDetail();
				userDetail.setName(request.getParameter("name"));
				userDetail.setUserName(request.getParameter("username"));
				userDetail.setPassword(request.getParameter("password"));
				userDetail.setEmail(request.getParameter("email"));
				userDetail.setMobileNumber(Long.parseLong(request.getParameter("mobilenumber")));
				int saveUser = userService.saveUser(userDetail);
				return "login";
			} else {
				model.addAttribute("user", "password and confirmpassword not matching eachother");
				return "register";
			}
		} catch (RegisterExceptions re) {
			model.addAttribute("error", re);
			return "usererror";
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "usererror";
		}

	}

	@RequestMapping(value = "login")
	String loginForm() {
		return "login";
	}

	@RequestMapping(value = "checkuser", method = RequestMethod.POST)
	String checkUser(Model model, HttpSession sesion, @RequestParam("username") String userName,
			@RequestParam("password") String password) {
		try {
			UserDetail userDetail = new UserDetail();

			userDetail.setUserName(userName);
			userDetail.setPassword(password);
			int userId = userService.checkUser(userDetail);

			sesion.setAttribute("userName", userName);
			sesion.setAttribute("userId", userId);
			return "redirect:/viewuserdetails";

		} catch (LoginException le) {
			model.addAttribute("error", le);
			return "usererror";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("error", e);
			return "usererror";
		}
	}

////logout function
	@RequestMapping("/logout")
	String logout(HttpSession session) {
		session.invalidate();
		return "login";

	}

}

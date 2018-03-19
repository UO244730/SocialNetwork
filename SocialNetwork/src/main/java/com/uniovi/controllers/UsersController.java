package com.uniovi.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.User;
import com.uniovi.services.RolesService;
import com.uniovi.services.SecurityService;
import com.uniovi.services.UsersService;
import com.uniovi.validators.SignUpFormValidator;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private SignUpFormValidator signUpFormValidator;

	@Autowired
	private RolesService rolesService;

	/*
	 * @RequestMapping("/user/list") public String getList() { return
	 * usersService.getUsers().toString(); }
	 */

	@RequestMapping("/user/add")
	public String setUser() {
		return "Adding Mark";
	}

	/*@RequestMapping("/user/list")
	public String getList(Model model) {
		model.addAttribute("userList", usersService.getUsers());
		return "list";
	}*/

	@RequestMapping("/user/list")
	public String getList(Model model, Principal principal,
			@RequestParam(value = "", required = false) String searchText) {
		//String dni = principal.getName(); // DNI es el name de la autenticación
		//User user = usersService.getUserByDni(dni);
		if (searchText != null && !searchText.isEmpty()) {
			model.addAttribute("userList", usersService.searchUsersByEmailAndName(searchText));
		} else {
			model.addAttribute("userList", usersService.getUsers());
		}
		return "list";
	}

	@RequestMapping("/user/details")
	public String getDetail(@RequestParam Long id) {
		return "Getting Details" + id;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "signup";
	}

	/*
	 * @RequestMapping(value="/signup", method = RequestMethod.POST) public String
	 * signup(@ModelAttribute("user")User user, Model model) {
	 * usersService.addUser(user);
	 * System.out.println("whatever"+user+user.getPassword());
	 * securityService.autoLogin(user.getEmail(), user.getPasswordConfirm()); return
	 * "redirect:home"; }
	 */

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String setUser(@Validated User user, BindingResult result, Model model) {
		System.out.println(user);
		user.setEmail("aaa");
		signUpFormValidator.validate(user, result);
		if (result.hasErrors()) {
			return "signup";
		}
		user.setRole(rolesService.getRoles()[0]);
		usersService.addUser(user);
		securityService.autoLogin(user.getEmail(), user.getPasswordConfirm());
		return "redirect:home";
	}
}

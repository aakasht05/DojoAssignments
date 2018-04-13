package com.tony.beltreviewer.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tony.beltreviewer.models.Guild;
import com.tony.beltreviewer.models.Ring;
import com.tony.beltreviewer.models.User;
import com.tony.beltreviewer.services.GuildService;
import com.tony.beltreviewer.services.RingService;
import com.tony.beltreviewer.services.RoleService;
import com.tony.beltreviewer.services.UserService;
import com.tony.beltreviewer.validations.UserValidator;

@Controller
public class UserController {
	private UserService userService;
	@Autowired
	private RoleService roleService;
	private UserValidator userValidator;
	@Autowired
	private RingService ringService;
	@Autowired
	private GuildService guildService;

	public UserController(UserService userService,RoleService roleService,RingService ringService,GuildService guildService,UserValidator userValidator){
		this.userService   = userService;
		this.roleService   = roleService;
		this.userValidator = userValidator;
		this.ringService   = ringService;
		this.guildService  = guildService;
	}
	
	@RequestMapping(value={"/login","/register"})
	public String login(Model model,@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout){
		if(error != null){model.addAttribute("errorMessage","Invalid Credentials.");}
		if(logout != null){model.addAttribute("logoutMessage","Logout Successful");}
		
		model.addAttribute("user",new User());
	
		return "login_register";
	}
	
	@PostMapping("/register")
	public String register(Principal principal,@Valid @ModelAttribute("user") User user,BindingResult res,Model model,HttpServletRequest req,RedirectAttributes flash){
		userValidator.validate(user,res);
		if(res.hasErrors()){return "login_register";}
		if(userService.findByEmail(user.getEmail()) != null){ // Would love to put UserService in UserValidator and validate there, but null pointers.
			flash.addFlashAttribute("emailExists","This email already exists.");
			return "redirect:/register";
		}
		if(userService.findByUsername(user.getUsername()) != null){
			flash.addFlashAttribute("userExists","This username already exists.");
			return "redirect:/register";
		}
		
		if(roleService.findByName("ROLE_ADMIN").getUsers().size() < 1){ // Less than one admin? Make them admin, else user.
			userService.create(new String[]{"ROLE_USER","ROLE_ADMIN"}, user);
		}else{
			userService.create(new String[]{"ROLE_USER"}, user);
		}
		flash.addFlashAttribute("registerSuccess","User Created Successfully. Please Login.");
		
		return "redirect:/register";
	}
	
	@RequestMapping("/admin/{adminId}/updater/{userId}")
	public String showUser(@PathVariable("adminId") long adminId,@PathVariable("userId") long userId,Model model){
		model.addAttribute("admin",adminId);
		model.addAttribute("user",userService.getById(userId));
		return "user_show";
	}
	
	@PostMapping("/admin/{adminId}/updater/{userId}")
	public String updateUser(@PathVariable("adminId") Long adminId,@PathVariable("userId") Long userId,@RequestParam("username") String username,RedirectAttributes flash){
		if(username.length() < 1){
			flash.addFlashAttribute("lenErr","Username cannot be blank.");
			return "redirect:/admin/"+adminId+"/updater/"+userId;
		}
		
		userService.getById(userId).setUsername(username);
		userService.update(userService.getById(userId));
		return "redirect:/admin/"+adminId+"/updater/"+userId;
	}
	
	@PostMapping("/users/{id}/rings/add")
	public String addRing(@PathVariable("id") long userId,@RequestParam("ring") long ringId,RedirectAttributes flash,Model model,HttpSession session){
		if(userService.getById(userId).isAdmin()){flash.addFlashAttribute("userOnly","Only users can acquire rings of power, almighty one!"); return "redirect:/dashboard";}
		
		if(session.getAttribute("pickedUp") != null){
			Double curTime = new Date().getTime()/1000.0;
			Double delay   = 300.0;
			Double diff    = Math.floor(curTime-(Double)session.getAttribute("pickedUp"));
			
			if(diff < delay){ // 5 mins havent passed, deny
				Double remaining = delay-diff;
				flash.addFlashAttribute("ringDelay","You must wait another "+remaining+" seconds before picking up another ring.");
				return "redirect:/dashboard";
			}else{
				session.setAttribute("pickedUp",null);
			}
		}else{
			session.setAttribute("pickedUp",new Date().getTime()/1000.0);
		}
		
		ringService.getById(ringId).setUser(userService.getById(userId));
		ringService.update(ringService.getById(ringId));
		//Switch ring's user to the user who picked it up / transfer ownership? No other logical solution, unless many to many or dont bind to admin on creation and null check.
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/user/{userId}/rings/{ringId}/delete")
	public String destroyRing(@PathVariable("userId") long userId,@PathVariable("ringId") long ringId){
		ringService.destroy(ringId);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/admin")
	public String admin(Principal principal,Model model){		
		model.addAttribute("user",userService.findByEmail(principal.getName()));
		model.addAttribute("users",userService.all());
		return "admin";
	}
		
	@RequestMapping("/admin/{id}/rings/new")
	public String newRing(@PathVariable("id") long userId,@ModelAttribute("ring") Ring ring,Model model){
		model.addAttribute("user",userService.getById(userId));
		return "ring_creator";
	}
	
	@PostMapping("/admin/{id}/rings/new")
	public String createRing(@Valid @ModelAttribute("ring") Ring ring,BindingResult res,@PathVariable("id") long userId,Model model){
		if(res.hasErrors()){return "ring_creator";}		
		ring.setUser(userService.getById(userId));
		ringService.create(ring);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/admin/{id}/guilds/new")
	public String newGuild(@PathVariable("id") long userId,Model model){
		model.addAttribute("user",userService.getById(userId));
		model.addAttribute("users",userService.all());
		model.addAttribute("guilds",guildService.all());
		model.addAttribute("guild",new Guild());
		model.addAttribute("curTime",new Date().getTime());
		return "guild_creator";
	}
	
	@PostMapping("/admin/{userId}/guilds/new")
	public String createGuild(@Valid @ModelAttribute("guild") Guild guild,BindingResult res,@PathVariable("userId") long userId,Model model){
		if(res.hasErrors()){
			model.addAttribute("user",userService.getById(userId));
			model.addAttribute("users",userService.all());
			model.addAttribute("guilds",guildService.all());
			model.addAttribute("curTime",new Date().getTime());
			return "guild_creator";
		}
		guildService.create(guild);
		return "redirect:/admin/"+userId+"/guilds/new";
	}
	
	@PostMapping("/admin/{id}/guilds/add")
	public String addGuild(@PathVariable("id") long adminId,@RequestParam(value="user",required=false) Long userId,@RequestParam(value="guild",required=false) Long guildId,RedirectAttributes flash){
		if(userId == null){
			flash.addFlashAttribute("userErr", "Select A Valid User.");
			return "redirect:/admin/"+adminId+"/guilds/new";
		}
		if(guildId == null){
			flash.addFlashAttribute("guildErr", "Select A Valid Guild.");
			return "redirect:/admin/"+adminId+"/guilds/new";
		}
		if(userService.getById(userId).isInGuild(guildService.getById(guildId))){
			flash.addFlashAttribute("hasGuild", userService.getById(userId).getUsername()+" already belongs to "+guildService.getById(guildId).getName());
			return "redirect:/admin/"+adminId+"/guilds/new";
		}
		if(guildService.getById(guildId).getUsers().size() >= guildService.getById(guildId).getSize()){
			flash.addFlashAttribute("guildFull",guildService.getById(guildId).getName()+" is at maximum capacity.");
			return "redirect:/admin/"+adminId+"/guilds/new";
		}
		
		guildService.getById(guildId).getUsers().add(userService.getById(userId));
		guildService.update(guildService.getById(guildId));
		return "redirect:/admin/"+adminId+"/guilds/new";
	}
	
	@RequestMapping("/admin/{adminId}/guilds/{guildId}")
	public String showGuild(@PathVariable("adminId") long adminId, @PathVariable("guildId") long guildId,Model model){
		model.addAttribute("guild",guildService.getById(guildId));
		model.addAttribute("admin",adminId);
		model.addAttribute("curTime",new Date().getTime());
		
		return "guild_show";
	}
	
	@RequestMapping("/admin/{adminId}/delete/{userId}")
	public String delete(@PathVariable("adminId") long adminId,@PathVariable("userId") Long userId){
		ringService.deleteRingWhere(userId);
		userService.destroy(userId);
		
		return "redirect:/admin/"+adminId+"/guilds/new";
	}
	
	@RequestMapping("/admin/promote/{id}")
	public String promote(@PathVariable("id") long id){
		userService.getById(id).getRoles().add(roleService.findByName("ROLE_ADMIN"));
		userService.update(userService.getById(id));
		
		return "redirect:/admin/"+id+"/guilds/new";
	}
	
	@RequestMapping(value={"/","/dashboard"})
	public String dashboard(Principal principal,Model model){
		User user = userService.findByEmail(principal.getName());
		model.addAttribute("user",user);
		model.addAttribute("rings",ringService.ringsNotPickedUp());

		user.setUpdatedAt(new Date());
		userService.update(user);
		
		return "dashboard";
	}
}

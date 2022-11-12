package com.example.SpringBootApplication.SpringBootStudent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
   public String homeController() {
	   
	   return "Home-page";
   }
}

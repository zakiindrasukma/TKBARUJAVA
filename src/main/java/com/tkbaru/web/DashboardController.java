package com.tkbaru.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tkbaru.model.LoginContext;

@Controller
@RequestMapping(value="/dashboard")
public class DashboardController {
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	private LoginContext loginContextSession;
	
	@RequestMapping(method = RequestMethod.GET)
	public String dashboard(Locale locale, Model model) {
		logger.info("[dashboard] " + "Locale: " + locale.toString());

		model.addAttribute("loginContext", loginContextSession);

		model.addAttribute("test", "testing.from.model");
		
		return "dashboard";
	}
}

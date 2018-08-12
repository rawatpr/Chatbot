package com.nuance.chatbot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nuance.chatbot.databeans.ChatbotRequestBean;
import com.nuance.chatbot.databeans.ChatbotResponseBean;
import com.nuance.chatbot.utils.AppUtils;

/**
 * Handles requests for the Chatbot service.
 */
@Controller
public class ChatbotController {

	private static final Logger logger = LoggerFactory.getLogger(ChatbotController.class);

	@RequestMapping("/greeting")
	public @ResponseBody ChatbotResponseBean getIntent(ChatbotRequestBean requestBean) {
		logger.info("Recieved reqeusts: " + requestBean.getInput1() + ", " + requestBean.getInput2());
		return AppUtils.getPerlOutput(requestBean);
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
}

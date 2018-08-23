package com.nuance.chatbot.controller;

import static com.nuance.chatbot.utils.AppUtils.getPerlOutput;
import static com.nuance.chatbot.utils.AppUtils.getSystemTime;

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

/**
 * Handles requests for the Chatbot service.
 */
@Controller
public class ChatbotController {

	private static final Logger logger = LoggerFactory.getLogger(ChatbotController.class);

	@RequestMapping("/getIntent")
	public @ResponseBody ChatbotResponseBean getIntent(ChatbotRequestBean requestBean) {
		logger.info(getSystemTime() + " Recieved reqeusts for inputText : " + requestBean.getInputText()+", and GrammarFile: "+requestBean.getGramFile());
		ChatbotResponseBean responseBean = new ChatbotResponseBean();
		responseBean.setCallerIntent(getPerlOutput(requestBean));
		logger.info(getSystemTime() + " Returning response for : " + responseBean.getCallerIntent());
		return responseBean;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
}

/**
 * 
 */
package com.nuance.chatbot.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nuance.chatbot.databeans.ChatbotRequestBean;
import com.nuance.chatbot.databeans.ChatbotResponseBean;

/**
 * @author praveen.rawat
 *
 */
public class AppUtils {

	private static final Logger logger = LoggerFactory.getLogger(AppUtils.class);

	/**
	 * Executes the perl command and return the output of the same.
	 * 
	 * @return
	 */
	public static ChatbotResponseBean getPerlOutput(ChatbotRequestBean requestBean) {

		ChatbotResponseBean responseBean = new ChatbotResponseBean();
		BufferedReader reader;
		StringBuffer sb = new StringBuffer();
		try {

			String command = "cmd /c C:\\Strawberry\\perl\\bin\\perl C:\\Users\\praveen.rawat\\eclipse-workspace\\TestCommand\\src\\com\\hello\\mainPL.pl"
					+ " " + requestBean.getInput1() + " " + requestBean.getInput2();
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
			if (process.exitValue() == 0) {
				logger.info("Executed Successfully!!!");
			} else {
				logger.error("Error executing the perl script!!");
			}

			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		responseBean.setCallerIntent(sb.toString());
		return responseBean;
	}
}

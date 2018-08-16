/**
 * 
 */
package com.nuance.chatbot.utils;

import static org.apache.commons.lang.StringUtils.substringBetween;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nuance.chatbot.databeans.ChatbotRequestBean;

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
	public static String getPerlOutput(ChatbotRequestBean requestBean) {

		BufferedReader reader;
		StringBuilder sb = new StringBuilder();

		StringBuilder callerIntentParsed = new StringBuilder();

		try {
			String command = "/usr/local/Nuance/ChatbotScript/GetIntent.sh";
			ProcessBuilder pb = new ProcessBuilder(command, requestBean.getInputText());
			Process process = pb.start();
			process.waitFor();
			if (process.exitValue() == 0) {
				logger.info("Executed Successfully!!!");
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				reader.close();
				callerIntentParsed.append("<?xml version=");
				callerIntentParsed.append(substringBetween(sb.toString(), "<?xml version=", "</result>"));
				callerIntentParsed.append("</result>");

			} else {
				callerIntentParsed.append("Error executing the script for the input: " + requestBean.getInputText());
				logger.error("Error executing the perl script!!");
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return callerIntentParsed.toString();
	}

	public static String getSystemTime() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date date = new Date();
		return df.format(date);
	}
}

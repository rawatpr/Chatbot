package com.nuance.chatbot.databeans;

public class ChatbotRequestBean {

	private String inputText;
	
	private String gramFile;
	/**
	 * @return the gramFile
	 */
	public String getGramFile() {
		return gramFile;
	}

	/**
	 * @param gramFile the gramFile to set
	 */
	public void setGramFile(String gramFile) {
		this.gramFile = gramFile;
	}

	/**
	 * @return the inputText
	 */
	public String getInputText() {
		return inputText;
	}

	/**
	 * @param inputText the inputText to set
	 */
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

}

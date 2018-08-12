<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Chatbot-Nuance</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />"></link>

</head>
<body>
	<div class="chatbox">
		<div class="chatlogs">
			<div class="chat friend">
				<div class="user-photo"><img src="<c:url value="/resources/img/User.jpg" />"/></div>
				<p class="chat-message">What's your name!!!</p>
			</div>
			<div class="chat self"x>
				<div class="user-photo"><img src="<c:url value="/resources/img/Nuance-Chatbot.png" />"/></div>
				<p class="chat-message">Myself Praveen!!!</p>
			</div>
			<div class="chat friend">
				<div class="user-photo"><img src="<c:url value="/resources/img/User.jpg" />"/></div>
				<p class="chat-message">Where are you located. I looking for some recommendation
				How are you. How is the weather!!!!</p>
			</div>
			<div class="chat self">
				<div class="user-photo"><img src="<c:url value="/resources/img/Nuance-Chatbot.png" />"/></div>
				<p class="chat-message">Myself Praveen!!!</p>
			</div>
			<div class="chat friend">
				<div class="user-photo"><img src="<c:url value="/resources/img/User.jpg" />"/></div>
				<p class="chat-message">Where are you located. I looking for some recommendation
				How are you. How is the weather!!!!</p>
			</div>
			<div class="chat friend">
				<div class="user-photo"><img src="<c:url value="/resources/img/User.jpg" />"/></div>
				<p class="chat-message">What's your name!!!</p>
			</div>
			<div class="chat self">
			    <div class="user-photo"><img src="<c:url value="/resources/img/Nuance-Chatbot.png" />"/></div>
				<p class="chat-message">Myself Praveen!!!</p>
			</div>
			<div class="chat friend">
				<div class="user-photo"><img src="<c:url value="/resources/img/User.jpg" />"/></div>
				<p class="chat-message">Where are you located. I looking for some recommendation
				How are you. How is the weather!!!!</p>
			</div>
		</div>
		<div class="chat-form">
			<textarea></textarea>
			<button>Send</button>
		</div>
	</div>
</body>
</html>

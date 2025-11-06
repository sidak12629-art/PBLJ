<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Welcome</title></head>
<body>
  <h2>Welcome, <%= request.getAttribute("user") %>!</h2>
  <p>Login successful. You have entered the system.</p>
</body>
</html>

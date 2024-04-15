<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="signup.css">
</head>
<body>
<h2>Sign Up</h2>
<form action="SignUpServlet" method="post">
    <div class="container">
        <%--@declare id="firstname"--%>
            <%--@declare id="lastname"--%>
            <%--@declare id="username"--%>
            <%--@declare id="password"--%>
            <%--@declare id="address"--%>
            <%--@declare id="contact"--%>
            <label
            for="firstName"><b>First Name</b></label>
        <input type="text" placeholder="Enter First Name" name="firstName" required>

        <label for="lastName"><b>Last Name</b></label>
        <input type="text" placeholder="Enter Last Name" name="lastName" required>

        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <label for="address"><b>Address</b></label>
        <input type="text" placeholder="Enter Address" name="address" required>

        <label for="contact"><b>Contact</b></label>
        <input type="text" placeholder="Enter Contact" name="contact" required>

        <button type="submit">Sign Up</button>
    </div>
</form>
<p>Already have an account? <a href="login.jsp">Log In</a></p> <!-- Log In linki -->
</body>
</html>

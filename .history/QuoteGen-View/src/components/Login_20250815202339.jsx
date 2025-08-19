import React from "react";

const Login = () => {
  const handleLoginSuccess = (credentialResponse) => {
    console.log(credentialResponse);

    // Send token to backend
    fetch("http://localhost:8080/api/auth/google", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ token: credentialResponse.credential }),
    })
      .then((res) => res.json())
      .then((data) => {
        console.log("Backend response:", data);
        // Save JWT or user data in localStorage/cookies
      });
  };

  const handleLoginError = () => {
    console.log("Login Failed");
  };

  return (
    <GoogleLogin onSuccess={handleLoginSuccess} onError={handleLoginError} />
  );
};

export default Login;

import React from "react";
import { GoogleLogin } from "@react-oauth/google";
import { useNavigate } from "react-router-dom";
import jwtDecode from "jwt-decode";

const Login = () => {
    const navigate = useNavigate();
    
    const handleLoginSuccess = (credentialResponse) => {
        const token = credentialResponse.credential;
        const userObject = jwt_decode(token);
        console.log("Login Success", userObject);
        // You can save the userObject to your state or context
        navigate("/");
    };
    
    const handleLoginError = () => {
        console.log("Login Failed");
    };
    
    return (
        <div className="flex items-center justify-center h-screen">
        <GoogleLogin
            onSuccess={handleLoginSuccess}
            onError={handleLoginError}
            theme="filled_black"
            size="large"
        />
        </div>
    );
};

export default Login;

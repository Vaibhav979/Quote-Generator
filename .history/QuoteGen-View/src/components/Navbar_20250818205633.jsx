import React from "react";
import { Link } from "react-router-dom";
import { useState } from "react";
import { GoogleLogin } from "@react-oauth/google";
import { jwtDecode } from "jwt-decode";

const Navbar = () => {
  const [user, setUser] = useState(null);

  const handleLoginSuccess = (credentialResponse) => {
    const idToken = credentialResponse.credential;

    fetch("http://localhost:8080/api/auth/google", {
      method: "POST",
      
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ credential: idToken }),
    })
      .then((res) => res.json())
      .then((data) => {
        localStorage.setItem("user", JSON.stringify(data)); // save user

        // store user data or JWT here
      })
      .catch((err) => console.error("Login error", err));
  };

  return (
    <div className="w-full h-16 bg-gray-800 flex items-center px-6 shadow-md">
      <nav className="flex items-center justify-between w-full">
        <div className="text-white text-2xl font-bold">QuoteGen</div>
        <ul className="list-none flex items-center gap-8 text-white text-lg">
          <li className="hover:text-gray-400 cursor-pointer">Home</li>
          <li className="hover:text-gray-400 cursor-pointer">About</li>
          <li className="hover:text-gray-400 cursor-pointer">Contact</li>
        </ul>

        {!user ? (
          <GoogleLogin
            onSuccess={(credentialResponse) => {
              const decoded = jwtDecode(credentialResponse.credential);
              setUser(decoded);
              console.log("Logged in user:", decoded);

              handleLoginSuccess(credentialResponse);
            }}
            onError={() => {
              console.log("Login Failed");
            }}
          />
        ) : (
          <div>
            <img
              src={user.picture}
              alt="Profile"
              style={{ width: "30px", borderRadius: "50%" }}
            />
            <span>{user.name}</span>
          </div>
        )}
      </nav>
    </div>
  );
};

export default Navbar;

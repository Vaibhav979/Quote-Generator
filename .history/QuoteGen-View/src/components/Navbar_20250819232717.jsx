import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { GoogleLogin } from "@react-oauth/google";
import { jwtDecode } from "jwt-decode";

const Navbar = () => {
  const [user, setUser] = useState(null);

  // Load user from localStorage on component mount
  // useEffect(() => {
  //   const storedUser = localStorage.getItem("user");
  //   if (storedUser) {
  //     setUser(JSON.parse(storedUser));
  //   }
  // }, []);

  const handleLoginSuccess = (credentialResponse) => {
    const idToken = credentialResponse.credential;

    fetch(
      `${
        import.meta.env.VITE_API_URL || "http://localhost:8080"
      }/api/auth/google`,
      {
        method: "POST",
        credentials: "include", // Required for sending cookies
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ credential: idToken }),
      }
    )
      .then((res) => {
        if (!res.ok) throw new Error("Failed to authenticate");
        return res.json();
      })
      .then((data) => {
        localStorage.setItem("user", JSON.stringify(data));
        setUser(data);
      })
      .catch((err) => console.error("Login error", err));
  };

  const handleLogout = () => {
    setUser(null);
    localStorage.removeItem("user");
  };

  return (
    <div className="w-full h-16 bg-gray-800 flex items-center px-6 shadow-md">
      <nav className="flex items-center justify-between w-full">
        <div className="text-white text-2xl font-bold">QuoteGen</div>
        <ul className="list-none flex items-center gap-8 text-white text-lg">
          <li>
            <Link to="/" className="hover:text-gray-400">
              Home
            </Link>
          </li>
          <li>
            <Link to="/about" className="hover:text-gray-400">
              About
            </Link>
          </li>
          <li>
            <Link to="/contact" className="hover:text-gray-400">
              Contact
            </Link>
          </li>
        </ul>

        {!user ? (
          <GoogleLogin
            onSuccess={(credentialResponse) => {
              try {
                handleLoginSuccess(credentialResponse);
              } catch (error) {
                console.error("JWT Decode error:", error);
              }
            }}
            onError={() => {
              console.log("Login Failed");
            }}
          />
        ) : (
          <div className="flex items-center gap-3 text-white">
            <img
              src={user.picture || "default-avatar.png"}
              alt="Profile"
              style={{ width: "30px", height: "30px", borderRadius: "50%" }}
            />
            <span>{user.name || "User"}</span>
            <button
              onClick={handleLogout}
              className="ml-2 px-2 py-1 bg-red-600 text-white rounded hover:bg-red-500 text-sm"
            >
              Logout
            </button>
          </div>
        )}
      </nav>
    </div>
  );
};

export default Navbar;

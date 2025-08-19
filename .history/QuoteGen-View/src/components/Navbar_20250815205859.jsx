import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <div className="w-full h-16 bg-gray-800 flex items-center px-6 shadow-md">
      <nav className="flex items-center justify-between w-full">
        <div className="text-white text-2xl font-bold">MyLogo</div>
        <ul className="list-none flex items-center gap-8 text-white text-lg">
          <li className="hover:text-gray-400 cursor-pointer">Home</li>
          <li className="hover:text-gray-400 cursor-pointer">About</li>
          <li className="hover:text-gray-400 cursor-pointer">Contact</li>
        </ul>
        <h2>My App</h2>

        {!user ? (
          <GoogleLogin
            onSuccess={(credentialResponse) => {
              const decoded = jwt_decode(credentialResponse.credential);
              setUser(decoded);
              console.log("Logged in user:", decoded);
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

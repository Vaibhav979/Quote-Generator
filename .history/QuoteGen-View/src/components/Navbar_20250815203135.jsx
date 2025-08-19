import React from "react";

const Navbar = () => {
  return (
    <div className="w-full h-16 bg-gray-800 flex items-center px-6 shadow-md">
      <navbar className="flex items-center justify-between w-full">
        <div className="text-white text-2xl font-bold">MyLogo</div>
        <ul className="list-none flex items-center gap-8 text-white text-lg">
          <li className="hover:text-gray-400 cursor-pointer">Home</li>
          <li className="hover:text-gray-400 cursor-pointer">About</li>
          <li className="hover:text-gray-400 cursor-pointer">Contact</li>
        </ul>
        <GoogleLogin
            onSuccess={credentialResponse => {
              console.log("Login Success", credentialResponse);
            }}
            onError={() => {
              console.log("Login Failed");
            }}
            theme="filled_black"
            size="medium"
          />
      </navbar>
    </div>
  );
};

export default Navbar;

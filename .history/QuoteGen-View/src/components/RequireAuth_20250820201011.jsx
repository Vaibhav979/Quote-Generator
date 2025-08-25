import { useEffect } from "react";
import { Navigate } from "react-router-dom";
import { toast } from "react-toastify";

const RequireAuth = ({ user, children }) => {
  useEffect(() => {
    if (!user) {
      toast.error("You must be logged in to view dashboard!");
    }
  }, [user]);

  if (!user) {
    return <Navigate to="/" />;
  }

  return children;
  
};

export default RequireAuth;

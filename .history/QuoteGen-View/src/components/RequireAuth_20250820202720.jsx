import { useEffect } from "react";
import { useLocation, Navigate } from "react-router-dom";
import { toast } from "react-toastify";

const RequireAuth = ({ user, children }) => {
  const location = useLocation();

  useEffect(() => {
    if (!user) {
      toast.error("You must be logged in to view dashboard!");
    }
  }, [user, location.pathname]);

  if (!user) {
    return <Navigate to="/" state={{ from: location }} replace />;
  }

  return children;
};

export default RequireAuth;

import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Dashboard = () => {
  const [quotes, setQuotes] = useState([]);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    axios
      .get("/dashboard", { withCredentials: true })
      .then((res) => {
        setQuotes(res.data);
        setLoading(false);
      })
      .catch((err) => {
        if (err.response && err.response.status === 401) {
          navigate("/"); // not logged in
          
        }
        setLoading(false);
      });
  }, []);

  if (loading) return <p>Loading...</p>;

  return (
    <div>
      <h2>My Quotes</h2>
      {quotes.length === 0 ? (
        <p>No quotes added yet.</p>
      ) : (
        <ul>
          {quotes.map((quote, index) => (
            <li key={index}>{quote.content}</li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default Dashboard;

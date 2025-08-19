import React, { useEffect, useState } from "react";

const UserDashboard = ({ user }) => {
  const [quotes, setQuotes] = useState([]);

  useEffect(() => {
    const fetchQuotes = async () => {
      try {
        const res = await fetch("http://localhost:8080/dashboard", {
          credentials: "include",
        });
        if (res.ok) {
          const data = await res.json();
          setQuotes(data);
        }
      } catch (err) {
        console.error("Error fetching user quotes", err);
      }
    };

    fetchQuotes();
  }, []);

  return (
    <div>
      <h2>Welcome, {user?.name}</h2>
      <h3>Your Quotes:</h3>
      {quotes.map((quote, idx) => (
        <div key={idx}>{quote.content}</div>
      ))}
    </div>
  );
};

export default UserDashboard;

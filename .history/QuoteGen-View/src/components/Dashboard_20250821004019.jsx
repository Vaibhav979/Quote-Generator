import React, { useEffect, useState } from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const UserDashboard = ({ user }) => {
  const [quotes, setQuotes] = useState([]);
  const [editingId, setEditingId] = useState(null);
  const [editedQuote, setEditedQuote] = useState("");

  useEffect(() => {
    fetchQuotes();
  }, []);

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

  const handleDelete = async (id) => {
    try {
      const res = await fetch(`http://localhost:8080/quote/delete/${id}`, {
        method: "DELETE",
        credentials: "include",
      });
      if (res.ok) {
        setQuotes(quotes.filter((q) => q.id !== id));
      } else {
        alert("Failed to delete quote");
      }
    } catch (err) {
      console.error("Error deleting quote", err);
    }
  };

  const handleEdit = (id, currentQuote) => {
    setEditingId(id);
    setEditedQuote(currentQuote);
  };

  const handleSave = async (id) => {
    try {
      const res = await fetch(`http://localhost:8080/quote/update/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        credentials: "include",
        body: JSON.stringify({ quote: editedQuote }),
      });

      if (res.ok) {
        setQuotes(
          quotes.map((q) => (q.id === id ? { ...q, quote: editedQuote } : q))
        );
        setEditingId(null);
        setEditedQuote("");
      } else {
        alert("Failed to update quote");
      }
    } catch (err) {
      console.error("Error updating quote", err);
    }
  };

  return (
    <div>
      <h2>Welcome, {user?.name}</h2>
      <h3>Your Quotes:</h3>
      {quotes.map((quote) => (
        <div key={quote.id} style={{ marginBottom: "1rem" }}>
          {editingId === quote.id ? (
            <>
              <input
                type="text"
                value={editedQuote}
                onChange={(e) => setEditedQuote(e.target.value)}
              />
              <button onClick={() => handleSave(quote.id)}>Save</button>
              <button onClick={() => setEditingId(null)}>Cancel</button>
            </>
          ) : (
            <>
              <p>{quote.quote}</p>
              <button onClick={() => handleEdit(quote.id, quote.quote)}>
                Edit
              </button>
              <button onClick={() => handleDelete(quote.id)}>Delete</button>
            </>
          )}
        </div>
      ))}
      <ToastContainer position="top-center" autoClose={3000} />
    </div>
  );
};

export default UserDashboard;

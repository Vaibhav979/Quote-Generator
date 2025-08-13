import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const Quotes = () => {
  const [quote, setQuote] = useState("");

  const fetchQuote = async () => {
    try {
      const res = await fetch("http://localhost:8080/quote");
      const text = await res.text();
      setQuote(text);
    } catch (error) {
      setQuote("Error fetching quote");
    }
  };

  return (
    <>
      <div>
        <h1>Random Quote Generator</h1>
        <button onClick={fetchQuote}>Get Quote</button>
        <p>{quote}</p>
        <br />
        <button onClick={nav}>Add Your Quote!!</button>
      </div>
    </>
  );
};

export default Quotes;

import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";


function App() {
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
      </div>
    </>
  );
}

export default App;

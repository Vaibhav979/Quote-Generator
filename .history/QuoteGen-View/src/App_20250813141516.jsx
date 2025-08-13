import { useState } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";

function App() {
    return (
    <>
      <div>
        <h1>Random Quote Generator</h1>
        <button onClick={fetchQuote}>Get Quote</button>
        <p>{quote}</p>
        <br />
        <button>Add Your Quote!!</button>
      </div>
    </>
  );
}

export default App;

import { useState } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import React from "react";
import AddQuotePage from "./components/AddQuotePage";
import Quotes from "./components/Quotes";
import "./App.css";
import Navbar from "./components/Navbar";
import Login from "./components/Login";

function App() {
  return (
    <>
      <Navbar />
        <Routes>
          <Route path="/" element={<Quotes />} />
          <Route path="/login" element={<Login />} />
          <Route path="/addQuote" element={<AddQuotePage />} />
        </Routes>
    </>
  );
}

export default App;

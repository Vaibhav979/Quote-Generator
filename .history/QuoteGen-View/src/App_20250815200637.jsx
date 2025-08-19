import { useState } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import React from "react";
import AddQuotePage from "./components/AddQuotePage";
import Quotes from "./components/Quotes";
import "./App.css";
import { GoogleOAuthProvider } from "@react-oauth/google";

function App() {
  return (
    <>
    <GoogleOAuthProvider
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Quotes />} />
          <Route path="/addQuote" element={<AddQuotePage />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

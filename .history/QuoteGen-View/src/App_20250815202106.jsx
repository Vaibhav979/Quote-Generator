import { useState } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import React from "react";
import AddQuotePage from "./components/AddQuotePage";
import Quotes from "./components/Quotes";
import "./App.css";


function App() {
  return (
    <>
      <GoogleOAuthProvider clientId="268854021462-45hsdqqb47302gc2gju9ife2gkvviche.apps.googleusercontent.com">
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Quotes />} />
            <Route path="/addQuote" element={<AddQuotePage />} />
          </Routes>
        </BrowserRouter>
      </GoogleOAuthProvider>
    </>
  );
}

export default App;

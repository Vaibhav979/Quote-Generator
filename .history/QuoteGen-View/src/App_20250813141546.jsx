import { useState } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Q
import "./App.css";

function App() {
    return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Quotes />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

import { StrictMode } from 'react'
import React from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { GoogleOAuthProvider } from "@react-oauth/google";

createRoot(document.getElementById('root')).render(
  <GoogleOAuthProvider clientId="268854021462-45hsdqqb47302gc2gju9ife2gkvviche.apps.googleusercontent.com"></GoogleOAuthProvider>
  <StrictMode>
    <App />
  </StrictMode>,
)

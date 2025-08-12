import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [quote, setQuote] = useState("")

  const fetchQuote = async () => {
    try {
      const res = await fetch("http://localhost:8080/quote")
    }
  }

  return (
    <>
      
    </>
  )
}

export default App

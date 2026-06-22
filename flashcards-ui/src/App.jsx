import { useState } from "react";
import axios from "axios";
import Flashcard from "./components/Flashcard";
import "./style.css";

export default function App() {
  const [text, setText] = useState("");
  const [cards, setCards] = useState([]);
  const [loading, setLoading] = useState(false);

  const generateFlashcards = async () => {
    if (!text.trim()) return;

    setLoading(true);
    setCards([]);

    try {
      const res = await axios.post("http://localhost:8080/api/flashcards", {
        text: text,
      });

      setCards(res.data);
    } catch (err) {
      console.log(err);
      alert("Failed to generate flashcards");
    }

    setLoading(false);
  };

  return (
  <div className="container">
    <h1 className="title">🚀 SmartNotes AI</h1>

    <p className="subtitle">
      Generate AI-powered flashcards from notes or any topic
    </p>

    <textarea
      placeholder="Enter notes or a topic (Java, DBMS, Binary Search...)"
      value={text}
      onChange={(e) => setText(e.target.value)}
    />

    <button onClick={generateFlashcards} disabled={loading}>
      {loading ? "Generating..." : "Generate Flashcards"}
    </button>

    {loading && (
      <div className="loading">
        🤖 Generating flashcards...
      </div>
    )}

    <div className="grid">
      {cards.map((card, index) => (
        <Flashcard key={index} card={card} />
      ))}
    </div>
  </div>
);
}


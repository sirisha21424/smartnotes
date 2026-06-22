import { useState } from "react";

export default function Flashcard({ card }) {
  const [flipped, setFlipped] = useState(false);

  return (
    <div
      className="card"
      onClick={() => setFlipped(!flipped)}
    >
      <div className={`inner ${flipped ? "flipped" : ""}`}>
        <div className="front">
          <h3>📝 Question</h3>
          <p>{card.question}</p>
          <small>Click card to flip</small>
        </div>

        <div className="back">
          <h3>✅ Answer</h3>
          <p>{card.answer}</p>
          <small>Click card to flip back</small>
        </div>
      </div>
    </div>
  );
}
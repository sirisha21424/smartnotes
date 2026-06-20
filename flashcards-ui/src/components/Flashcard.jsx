import { useState } from "react";

export default function Flashcard({ card }) {
  const [flipped, setFlipped] = useState(false);

  return (
    <div className={`card ${flipped ? "flipped" : ""}`} onClick={() => setFlipped(!flipped)}>
      <div className="inner">
        
        {/* FRONT */}
        <div className="front">
          <h3>Question</h3>
          <p>{card.question}</p>
        </div>

        {/* BACK */}
        <div className="back">
          <h3>Answer</h3>
          <p>{card.answer}</p>
        </div>

      </div>
    </div>
  );
}
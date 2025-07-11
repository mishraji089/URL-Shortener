import React, { useState } from "react";
import axios from "axios";

function App() {
  const [longUrl, setLongUrl] = useState("");
  const [shortUrl, setShortUrl] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setShortUrl("");

    try {
      const response = await axios.post("http://localhost:8080/shorten", {
        longUrl,
      });
      setShortUrl(response.data.shortUrl);
    } catch (err) {
      setError("Failed to shorten URL. Make sure the backend is running.");
    }
  };

  return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center p-4">
      <div className="max-w-xl w-full bg-white p-6 rounded-2xl shadow-lg">
        <h1 className="text-2xl font-bold mb-4 text-center text-blue-600">
          🔗 URL Shortener
        </h1>

        <form onSubmit={handleSubmit} className="flex flex-col gap-4">
          <input
            type="url"
            placeholder="Enter a long URL"
            className="p-3 border border-gray-300 rounded-lg"
            value={longUrl}
            onChange={(e) => setLongUrl(e.target.value)}
            required
          />
          <button
            type="submit"
            className="bg-blue-600 text-white p-3 rounded-lg hover:bg-blue-700 transition"
          >
            Shorten URL
          </button>
        </form>

        {shortUrl && (
          <div className="mt-6 text-center">
            <p className="text-green-700 font-medium">Short URL:</p>
            <a
              href={shortUrl}
              target="_blank"
              rel="noopener noreferrer"
              className="text-blue-500 underline break-all"
            >
              {shortUrl}
            </a>
          </div>
        )}

        {error && (
          <p className="text-red-600 text-center mt-4">{error}</p>
        )}
      </div>
    </div>
  );
}

export default App;

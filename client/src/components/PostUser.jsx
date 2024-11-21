import React, { useState } from 'react';
import axios from 'axios';

export default function PostUser() {
  const [formData, setFormData] = useState({ name: "", password: "" });
  const [responseMessage, setResponseMessage] = useState("");

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .post("/api/demo/v1", formData)
      .then((response) => {
        setResponseMessage(response.data);
        setFormData({ name: "", password: "" }); // Clear form after submission
      })
      .catch((error) => {
        setResponseMessage(error.response?.data || "An error occurred");
      });
  };

  return (
    <div>
      <h1>Post User Data</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit">Submit</button>
      </form>
      {responseMessage && <p>{responseMessage}</p>}
    </div>
  );
}

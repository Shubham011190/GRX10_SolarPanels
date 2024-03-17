import React, { useState } from 'react';
import axios from 'axios';

const CalculatorForm = () => {
  const [formData, setFormData] = useState({ bill: '', area: '', phoneNo: '' });
  const [result, setResult] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('https://solarpanelsgrx10backend.onrender.com/grx10/api/postData', formData);
      setResult(response.data);
      console.log(response.data);
    } catch (error) {
      console.error('Error:', error);
    }
  };

  const formatNumber = (number) => {
    return new Intl.NumberFormat().format(number);
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4">Solar Panel Calculator</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="bill" className="form-label">Monthly Electricity Bill:</label>
          <input type="text" className="form-control" id="bill" name="bill" value={formData.bill} onChange={handleChange} />
        </div>
        <div className="mb-3">
          <label htmlFor="area" className="form-label">Area Available (sq. ft):</label>
          <input type="text" className="form-control" id="area" name="area" value={formData.area} onChange={handleChange} />
        </div>
        <div className="mb-3">
          <label htmlFor="phoneNo" className="form-label">Phone Number:</label>
          <input type="text" className="form-control" id="phoneNo" name="phoneNo" value={formData.phoneNo} onChange={handleChange} />
        </div>
        <button type="submit" className="btn btn-primary">Calculate</button>
      </form>


      {result && (
        <div className="mt-4">
          <h3>Calculation Result</h3>
          <p>No. of Panels: {result.noOfPanels}</p>
          <p>Area Needed: {formatNumber(result.areaNeeded)}m²</p>
          <p>Capital Needed: ₹{formatNumber(result.capitalneeded)}</p>
          <p>Break Even Years: {result.breakEvenYears.toFixed(2)} years</p>
          <p>Next 25 Years Earnings: ₹{formatNumber(result.next25Earnings)}</p>
        </div>
      )}
    </div>
  );
};

export default CalculatorForm;

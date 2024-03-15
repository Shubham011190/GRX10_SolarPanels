import React, { useState } from 'react';

function UserForm() {
  const [user, setUser] = useState({ bill: '', area: '', phoneNo : ''  });

  const handleSubmit = (event) => {
    event.preventDefault();
    fetch('http://localhost:8080/grx10/api/postData', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(user),
    }) 
    .then(response => response.json())
    .then(data => console.log('User created:', data))
    .catch(error => console.error('Error creating user:', error));
    console.log(JSON.stringify(user));
  };

  const handleChange = (event) => {
    const { name, value } = event.target;
    setUser(prevUser => ({ ...prevUser, [name]: value }));
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        name="bill"
        value={user.bill}
        onChange={handleChange}
        placeholder="Bill"
      />
      <input
        type='number'
        name="area"
        value={user.area}
        onChange={handleChange}
        placeholder="Area"
      />
      <input
      type='number'
      name="phoneNo"
      value={user.phoneNo}
      onChange={handleChange}
      placeholder="Phone No."
      />
      <button type="submit">Submit</button>
    </form>
  );
}

export default UserForm;

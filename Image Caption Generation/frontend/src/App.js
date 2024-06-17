import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './Login';
import Register from './Register';
import ImageUpload from './ImageUpload';
import Logout from './Logout';

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/login" component={Login} />
          <Route path="/register" component={Register} />
          <Route path="/image-upload" component={ImageUpload} />
          <Route path="/logout" component={Logout} />
          {/* Add other routes as needed */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;

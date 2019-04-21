import React, { Component } from 'react';
import './App.css';
import QuotesForm from './components/QuotesForm'

class App extends Component {
  render() {
    return (
      <div className="App">
        <QuotesForm/>
      </div>
    );
  }
}

export default App;

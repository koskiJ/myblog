import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

  constructor (props) {
    super(props)
    this.state = {'post': "temp"}
    this.getPosts = this.getPosts.bind(this)
  }

  async getPosts() {
    const response = await fetch('/api/posts')
    const body = await response.json()
    console.log("Getting posts")
    console.log(body)
    let result = ""
    for (let value of body) {
      for (let field in value) {
        result += field + ":" + value[field] + " "
      }
      result += "/// "
    }
    this.setState({'post': <p>{result}</p>})
  }

  componentDidMount() {
    this.getPosts()
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
          {this.state.post}
        </header>
      </div>
    );
  }
}

export default App;

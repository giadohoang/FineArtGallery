"use strict";
import Index from "./index";

const React = require("react");
const ReactDOM = require("react-dom");
const client = require("./client");

class Portfolio extends React.Component {
  constructor(props) {
    super(props);
    this.state = { gallery: [], userName: "" };
    this.handleBlur = this.handleBlur.bind(this);
    this.handleClick = this.handleClick.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {}

  handleBlur(event) {
    if (event.target.name == "userName") {
      this.setState({ userName: event.target.value });
    }
  }

  handleSubmit(event) {}

  handleClick(event) {
    if ((event.target.name = "edit")) {
      console.log("Editing: ", event.target.id);
    } else {
      console.log("deleting: ", event.target.id);
    }
  }

  render() {
    return <div>Portfolio</div>;
  }
}

ReactDOM.render(<Portfolio />, document.getElementById("portfolio"));

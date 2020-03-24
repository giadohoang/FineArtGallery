"use strict";

const React = require("react");
const ReactDOM = require("react-dom");
const client = require("./client");
class Index extends React.Component {
  constructor(props) {
    super(props);
    this.state = { employees: [] };
    this.handleBlur = this.handleBlur.bind(this);
    this.handleClick = this.handleClick.bind(this);
  }

  componentDidMount() {
    client({ method: "GET", path: "/allArts" }).done(response => {
      console.log("success getting data: ", response);
      this.setState({ employees: response.entity });
    });
  }

  handleBlur(event) {}

  handleClick(event) {
    if ((event.target.name = "edit")) {
      console.log("Editing: ", event.target.id);
    } else {
      console.log("deleting: ", event.target.id);
    }
  }

  render() {
    return (
      <EmployeeList
        employees={this.state.employees}
        handleBlur={this.handleBlur}
      />
    );
  }
}

class EmployeeList extends React.Component {
  render() {
    const employees = this.props.employees.map(employee => (
      <Employee
        key={employee.id}
        employee={employee}
        handleClick={this.props.handleClick}
        handleBlur={this.props.handleBlur}
      />
    ));
    return (
      <table>
        <tbody>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Description</th>
            <th>Action</th>
          </tr>
          {employees}
        </tbody>
      </table>
    );
  }
}

class Employee extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }
  render() {
    console.log("rending component");
    return (
      <tr>
        <td>
          <input
            name="firstName"
            className={"form-control"}
            defaultValue={this.props.employee.firstName}
            onBlur={this.props.handleBlur}
          />
        </td>
        <td>
          <input
            name="lastName"
            className={"form-control"}
            defaultValue={this.props.employee.lastName}
            onBlur={this.props.handleBlur}
          />
        </td>
        <td>
          <input
            name="description"
            className={"form-control"}
            defaultValue={this.props.employee.description}
            onBlur={this.props.handleBlur}
          />
        </td>
        <td>
          <button
            id={this.props.employee.id}
            name="edit"
            onClick={this.handleClick}
          >
            Edit
          </button>
          <button
            id={this.props.employee.id}
            name="delete"
            onClick={this.props.handleClick}
          >
            Delete
          </button>
        </td>
      </tr>
    );
  }
}
export default Index;
//ReactDOM.render(<Index />, document.getElementById("react"));

'use strict';

// tag::vars[]
const React = require('react'); // <1>
const ReactDOM = require('react-dom'); // <2>
const client = require('./client'); // <3>
// end::vars[]

// tag::app[]
class Index extends React.Component { // <1>

    constructor(props) {
        super(props);
        this.state = {employees: []};
        this.handleBlur =this.handleBlur.bind(this);
        this.handleClick = this.handleClick.bind(this);

    }


    componentDidMount() { // <2>
        client({method: 'GET', path: '/api/emps'}).done(response => {
            console.log("success 123: ", response);
            this.setState({employees: response.entity});
        });
    }

    handleBlur(event){
        // console.log("blurring");
        // var temp = event.target.value;

        // this.setState((state,props) => {
        // 	return{
        // 		[boo] : temp
        // 	};
        // });
        // console.log(this.state.employees);
    }

    handleClick(event){
        if(event.target.name="edit"){
            console.log("Editing: " , event.target.id);
        } else {
            console.log("deleting: ", event.target.id);
        }
    }

    render() { // <3>
        return (
            <EmployeeList employees={this.state.employees} handleBlur={this.handleBlur}/>
    )
    }
}
// end::app[]

// tag::employee-list[]
class EmployeeList extends React.Component{

    render() {
        const employees = this.props.employees.map(employee =>
            <Employee key={employee.id} employee={employee} handleClick={this.props.handleClick} handleBlur={this.props.handleBlur}/>
    );
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
    )
    }
}
// end::employee-list[]

// tag::employee[]
class Employee extends React.Component{
    constructor(props) {
        super(props);
        this.state = {};


    }
    render() {
        console.log("rending component");
        return (
            <tr >
            <td>
            <input name="firstName" className={'form-control'} defaultValue={this.props.employee.firstName} onBlur={this.props.handleBlur}/>
        </td>
        <td>
        <input name="lastName" className={'form-control'} defaultValue={this.props.employee.lastName} onBlur={this.props.handleBlur}/>
        </td>
        <td>
        <input name="description" className={'form-control'} defaultValue={this.props.employee.description} onBlur={this.props.handleBlur}/>
        </td>
        <td>
        <button id={this.props.employee.id}  name="edit" onClick={this.handleClick}>Edit</button >
            <button  id={this.props.employee.id} name="delete" onClick={this.props.handleClick}>Delete</button >
            </td>
            </tr>
    )
    }
}
// end::employee[]

// tag::render[]
ReactDOM.render(
<Index />,
    document.getElementById('react')
)
// end::render[]

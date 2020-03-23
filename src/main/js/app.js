'use strict';

// tag::vars[]
const React = require('react'); // <1>
const ReactDOM = require('react-dom'); // <2>
const client = require('./client'); // <3>
// end::vars[]

// tag::app[]
class App extends React.Component { // <1>

	constructor(props) {
		super(props);
		this.state = {gallery: []};
		this.handleBlur =this.handleBlur.bind(this);
		this.handleClick = this.handleClick.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}


	componentDidMount() { // <2>
		// client({method: 'GET', path: '/api/emps'}).done(response => {
		// 	console.log("success 123: ", response);
		// 	this.setState({employees: response.entity});
		// });
	}

	handleBlur(event){
		
	}

	handleSubmit(event){
		console.log("user submit");
		client({method: 'GET', path: '/user/login/' + "buyer1"}).done(response => {
            console.log("success 123: ", response);
            this.setState({gallery: response.entity});
        });
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
			<div>
				<h1>Login</h1>
				<form >
        <label>
          Name:
          <input type="text" name="userName" />
        </label>
        <button type="button" onClick={this.handleSubmit}>Submit</button>
      </form>
			</div>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)


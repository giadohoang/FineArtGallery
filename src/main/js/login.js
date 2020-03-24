class Login extends React.Component {
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

  handleSubmit(event) {
    console.log("user submit: ", event.target);
    client({ method: "GET", path: "/login/" + this.state.name }).done(
      response => {
        console.log("success 123: ", response);
        this.setState({ gallery: response.entity });
      }
    );
    event.preventDefault();
  }

  handleClick(event) {
    if ((event.target.name = "edit")) {
      console.log("Editing: ", event.target.id);
    } else {
      console.log("deleting: ", event.target.id);
    }
  }

  render() {
    // <3>
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <h3>Login</h3>
          <label>
            Name:
            <input type="text" name="userName" onBlur={this.handleBlur} />
          </label>
          <input type="submit" value="Submit" />
        </form>
      </div>
    );
  }
}
export default Login;

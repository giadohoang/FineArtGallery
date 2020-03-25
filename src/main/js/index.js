"use strict";

const React = require("react");
const ReactDOM = require("react-dom");
const client = require("./client");
class Index extends React.Component {
  constructor(props) {
    super(props);
    this.state = { combinedData: [], arts: [], users: [], purchases: [] };
    this.handleBlur = this.handleBlur.bind(this);
    this.handleClick = this.handleClick.bind(this);
  }

  componentDidMount() {
    client({ method: "GET", path: "/allArts" }).done(response => {
      console.log("success getting data: ", response);
      console.log("response.entity: ", response.entity);
      this.setState({ arts: response.entity });
    });
    client({ method: "GET", path: "/allUsers" }).done(response => {
      console.log("success getting data: ", response);
      console.log("response.entity: ", response.entity);
      this.setState({ users: response.entity });
    });
    client({ method: "GET", path: "/allPurchases" }).done(response => {
      console.log("success getting data: ", response);
      console.log("response.entity: ", response.entity);
      this.setState({ purchases: response.entity });
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
      <ArtList
        arts={this.state.arts}
        purchases={this.state.purchases}
        handleBlur={this.handleBlur}
      />
    );
  }
}

class ArtList extends React.Component {
  render() {
    const arts = this.props.arts.map(art => (
      <Art
        key={art.id}
        art={art}
        handleClick={this.props.handleClick}
        handleBlur={this.props.handleBlur}
        isArtist={true}
        purchase={
          this.props.purchases &&
          this.props.purchases.find(purchase => purchase.art.id === art.id)
        }
      />
    ));
    return (
      <table>
        <tbody>
          <tr>
            <th>Preview</th>
            <th>Name</th>
            <th>Artist</th>
            <th>Year</th>
            <th>Description</th>
            <th>Price</th>
            <th>Dimention</th>
            <th>Buyer</th>
          </tr>
          {arts}
        </tbody>
      </table>
    );
  }
}

class Art extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }
  render() {
    console.log("rending component with buyer: ", this.props.purchase);
    var disable = !this.props.isArtist;
    return (
      <tr>
        <td>
          <img
            name="url"
            className={"form-control"}
            // defaultValue={this.props.art.name}
            //onBlur={this.props.handleBlur}
            src={this.props.art.url}
            style={{ maxHeight: "400px", maxWidth: "400px" }}
          />
        </td>
        <td>
          <input
            name="name"
            className={"form-control"}
            defaultValue={this.props.art.name}
            onBlur={this.props.handleBlur}
            disabled={disable}
          />
        </td>
        <td>
          <input
            name="artist"
            className={"form-control"}
            defaultValue={
              this.props.art.user.firstName + " " + this.props.art.user.lastName
            }
            onBlur={this.props.handleBlur}
            disabled={true}
          />
        </td>
        <td>
          <input
            name="year"
            className={"form-control"}
            defaultValue={this.props.art.year}
            onBlur={this.props.handleBlur}
            disabled={disable}
          />
        </td>
        <td>
          <textarea
            name="description"
            className={"form-control"}
            defaultValue={this.props.art.description}
            onBlur={this.props.handleBlur}
            disabled={disable}
          />
        </td>
        <td>
          <input
            name="price"
            className={"form-control"}
            defaultValue={"$" + this.props.art.price}
            onBlur={this.props.handleBlur}
            disabled={disable}
          />
        </td>
        <td>
          <input
            name="dimention"
            className={"form-control"}
            defaultValue={
              this.props.art.width + "w x" + this.props.art.height + "h"
            }
            onBlur={this.props.handleBlur}
            disabled={disable}
          />
        </td>
        <td>
          <input
            name="buyer"
            className={"form-control"}
            defaultValue={
              this.props.purchase &&
              this.props.purchase.user &&
              this.props.purchase.user.firstName +
                " " +
                this.props.purchase.user.lastName
            }
            onBlur={this.props.handleBlur}
            disabled={disable}
          />
        </td>
        {/* <td>
          {this.props.isArtist && (
            <button
              id={this.props.art.id}
              name="delete"
              onClick={this.handleClick}
            >
              Delete
            </button>
          )}
          {!this.props.isArtist && (
            <button
              id={this.props.art.id}
              name="Buy"
              onClick={this.props.handleClick}
            >
              Buy
            </button>
          )}
        </td> */}
      </tr>
    );
  }
}

export default Index;
//ReactDOM.render(<Index />, document.getElementById("react"));

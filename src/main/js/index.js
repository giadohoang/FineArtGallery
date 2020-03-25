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
    this.bindData = this.bindData.bind(this);
  }

  componentDidMount() {
    client({ method: "GET", path: "/allData" }).done(response => {
      this.bindData(response.entity);
    });
  }

  handleBlur(event) {}

  bindData(data) {
    if (data) {
      //console.log("combinedData 1: ", data);

      var combinedData = [];
      var arts = [...data.artService];
      var purchases = [...data.purchaseService];
      var users = [...data.userService];

      this.setState({
        arts: arts,
        purchases: purchases
      });
    }
  }

  handleClick(event) {
    if ((event.target.name = "edit")) {
    } else {
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
      <table className="table">
        <thead>
          <tr className="thead">
            <th>Preview</th>
            <th>Name</th>
            <th>Artist</th>
            <th>Year</th>
            <th>Description</th>
            <th>Price</th>
            <th>Dimention</th>
            <th>Buyer</th>
          </tr>
        </thead>
        <tbody className="tbody">{arts}</tbody>
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
    var disable = !this.props.isArtist;
    return (
      <tr>
        <td>
          <img
            name="url"
            src={this.props.art.url}
            style={{ maxHeight: "500px", maxWidth: "500px" }}
          />
        </td>
        <td name="name">{this.props.art.name}</td>
        <td name="artist">
          {this.props.art.user.firstName + " " + this.props.art.user.lastName}
        </td>
        <td name="year">{this.props.art.year}</td>
        <td name="description">{this.props.art.description}</td>
        <td name="price">{"$ " + this.props.art.price}</td>
        <td name="dimention">
          {this.props.art.width + "w x" + this.props.art.height + "h"}
        </td>
        {this.props.purchase && (
          <td name="buyer">
            {this.props.purchase.user &&
              this.props.purchase.user.firstName +
                " " +
                this.props.purchase.user.lastName}
          </td>
        )}

        {!this.props.purchase && (
          <td name="buyer">
            <button
              className="btn btn-success btn-block "
              style={{ borderRadius: "6px" }}
            >
              Buy
            </button>
          </td>
        )}

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

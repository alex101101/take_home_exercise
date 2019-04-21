import React, { Component } from 'react'
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider'
import AppBar from 'material-ui/AppBar'
import TextField from 'material-ui/TextField'
import RaisedButton from 'material-ui/RaisedButton'
import QuotesDetails from './QuotesDetails';
import fetch from 'isomorphic-fetch';

export class QuotesForm extends Component {
  state = {
    priceList: [],
    loading: false,
    pickupPostcode: '',
    deliveryPostcode: '',
    vehicle: ''
  }

  // Load resource
  getQuote = quoteRequest => e =>  {
    e.preventDefault();
    this.setState({
      loading: true
    }, () => {
      fetch("http://localhost:8080/quote", {
        method: "POST",
        dataType: "JSON",
        body: JSON.stringify(quoteRequest),
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        }
      })
      .then((resp) => {
        if (!resp.ok) {
          throw Error(resp.statusText);
        }
        return resp.json();
      }) 
      .then((json) => {
        this.setState({
            priceList: json.priceList
        })                    
      })
      .catch((error) => {
        console.log(error, "Error retrieving quote" + error)
      })
      .finally(() => {
        this.setState({
          loading: false
        })
      })
    })
  }

  clearForm = () => {
    // const { step } = this.state;
    // this.setState({
    //   step: step + 1
    // })
  }

  // Handle fields change
  handleChange = input => e => {
    this.setState({[input]: e.target.value});
  }

  render() {
    const { loading, priceList } = this.state
    const loadValues = {loading, priceList}
    const { pickupPostcode, deliveryPostcode, vehicle } = this.state;
    const values = {pickupPostcode, deliveryPostcode, vehicle}
    
    return (
      <MuiThemeProvider>
        <React.Fragment>
          <AppBar title="Get Quotes"/>
          <TextField
            hintText="Enter Parcel Pickup Postcode"
            floatingLabelText="Pickup Postcode"
            onChange={this.handleChange('pickupPostcode')}
            defaultValue={values.pickupPostcode}
          />
          <br/>
          <TextField
            hintText="Enter Parcel Delivery Postcode"
            floatingLabelText="Delivery Postcode"
            onChange={this.handleChange('deliveryPostcode')}
            defaultValue={values.deliveryPostcode}
          />
          <br/>
          <TextField
            hintText="Enter Delivery Vehicle"
            floatingLabelText="Vehicle"
            onChange={this.handleChange('vehicle')}
            defaultValue={values.vehicle}
          />
          <br/>
          <RaisedButton 
            label="Get a Quote"
            primary={true}
            style={styles.button}
            onClick={this.getQuote(values)}
          />
          <br/>
          <br/>
          <QuotesDetails
            loadValues = {loadValues}
          />
        </React.Fragment>
      </MuiThemeProvider>
    )
  }
}

const styles = {
    button: {
      margin: 15
    }
  }

export default QuotesForm

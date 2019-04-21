import React, { Component } from 'react'
import {List, ListItem} from 'material-ui/List'

export class QuotesDetails extends Component {
  render() {
    const { loadValues: { loading, priceList } } = this.props;

    if (loading) {
      return <div>Loading... </div>
    } else {
      if (priceList.length === 0) {
        return <div>No prices found. Please enter a new quote request.</div>
      } else {
        return (
          <React.Fragment>
            <List>
              {priceList.map(item => (
                <ListItem
                  key={item.service + item.deliveryTime}
                  primaryText={item.service}
                  secondaryText={"Price: " + item.price + " Delivery Time: " + item.deliveryTime } 
                />
              ))}
            </List>
          </React.Fragment>
        )
      }
    }
  }
}

export default QuotesDetails

# Quote Engine Task
### Requirements:
- Java 8+
- Gradle (v4.8 works)
- npm (6.9.0 works)
- Chrome
### Running Front and Back-end (linux/mac):
In Project root directory run:
```
    gradle bootRun
    cd webapp/quoting-engine-frontend
    # Chrome window will open
    npm start
```

Can now send quote requests via the web page or directly.

### Call api directoy

REQUEST:
```$xslt
echo '{"pickupPostcode":"SW1A1AA","deliveryPostcode":"EC2A3LT","vehicle":"bicycle"}' | \
curl -d @- http://localhost:8080/quote --header "Content-Type:application/json"
```

RESPONSE:
```$xslt
{
  "pickupPostcode": "SW1A1AA",
  "deliveryPostcode": "EC2A3LT",
  "vehicle": "bicycle",
  "priceList": [
    {
      "service": "OOPS",
      "price": 348,
      "deliveryTime": 12
    },
    {
      "service": "Hercules",
      "price": 373,
      "deliveryTime": 10
    },
    {
      "service": "RoyalPackages",
      "price": 380,
      "deliveryTime": 3
    },
    {
      "service": "RoyalPackages",
      "price": 393,
      "deliveryTime": 1
    },
    {
      "service": "CollectTimes",
      "price": 401,
      "deliveryTime": 5
    }
  ]
}
```
# superMarketExample
Example application to price a basket of goods, accounting for special offers


#Requirements

- Windows 10
- java 1.8
- gradle 4.3

#Instructions

##Installation

from terminal, at the root directory run:

`gradle build fatJar`

##Execution

from terminal, at the root directory run:

`PriceBasket item1 item2 item3`


For instance,

`PriceBasket Bread Soup`



#Future extensions

- Add more products
- add more currencies
- add different packaging options
- add detection of near-spelled words
- detect errors and recommend advise
- add expiration date for products
- add support for multiplies (e.g., 2Bread, instead of 'Bread Bread')
- implement recommendation system
    - recommend offers to customer
    - recommend new offers for the super market, based on stock size
    - recommend similar products
- check availability of products in the stock
- deploy as a services on the cloud
- add statistics/preferences
- link to a web-based environment with user/accounts, so as to monitor and extract preferences
- implement a REST API
- link to a database for better persistence
- implement as multi-threading
- support other operating systems (e.g., Linux)
- support backwards compatibility with other systems in the family
- support other forms of input (e.g., JSON files)
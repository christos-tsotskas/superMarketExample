# superMarketExample
Example application to price a basket of goods, accounting for special offers


#Requirements

Currently, testing on:

- Windows 10, 64 bit
- java 1.8
- gradle 4.3
- (optionally) IDE: Intellij 2017.2.5

#Instructions

##Installation

from the terminal, at the root directory run:

`gradle build fatJar`

##Execution

from the terminal, at the root directory run:

`PriceBasket item1 item2 item3`


For instance,

`PriceBasket Bread Soup`



#Future extensions

## Business Improvement
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
- add statistics/preferences
- link to a web-based environment with user/accounts, so as to monitor and extract preferences
- link to a database for better persistence
- support backwards compatibility with other systems in the family
- predict demand based on historical records


## Technology Improvement

- Software Development Life Cycle
    - Requirements
        - More detailed requirements, according to IEEE ISO for Software/Systems Engineering
    - Design
        - Auto-generated architecture
        - call-graphs
    - Implementation
        - support other forms of input (e.g., JSON files)
        - implement a REST API
        - implement as multi-threading
    - Testing
        - link to automated test server
        - set up automated DevOps environment (with Auto-QA, QA, Staging, Production)
        - after successful testing, deploy jar on an artifact server
    - Deployment
        - notification of new services to subscribed users
        - hash, for versioning
        - deploy as a services on the cloud
        - add automated discovery of new settings during deployment
        - deploy under a licensing scheme to monitor usage
    - Maintenance
        - support other operating systems (e.g., Linux)
        - optimise memory usage
        

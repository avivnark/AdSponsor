Product-Campaign Advertising Module
This document outlines the functionalities and APIs of a module designed for managing product campaigns and serving targeted ads.

Entities:

Product: Represents a product with the following attributes:
title: String, the product name.
category: String, a category classifying the product.
price: Float, the product's price.
product_serial_number: String/int, a unique identifier for the product.
Campaign: Represents a group of products promoted together with the following properties:
name: String, a unique identifier for the campaign.
start_date: Datetime, the date the campaign becomes active.
bid: Float, the price the seller is willing to pay per click on an ad for this campaign.
products: List of product identifiers promoting this campaign.

APIs:

Create Campaign:

Parameters:
name: String (required), the campaign name.
start_date: Datetime (required), the date the campaign becomes active.
product_ids: List of strings/ints (required), identifiers of the products to promote.
bid: Float (required), the price per click the seller is willing to pay.
Expected result: Creates a new campaign with the specified properties.
Response: JSON object representing the created campaign, including:
name: String, the campaign name.
start_date: Datetime, the campaign's start date.
bid: Float, the campaign's bid per click.
product_ids: List of strings/ints, the IDs of the promoted products.

Serve Ad:

Parameter:
category: String (required), the category of products to search for.
Expected result: Returns a single promoted product from the specified category, meeting the following criteria:
Highest bid: Among active campaigns promoting products in the specified category, the product with the highest bid is chosen.
Active campaign: If no campaigns for the specified category are active (within 10 days of their start date), the product with the highest bid from any active campaign is returned.
Random selection: If multiple products meet the criteria above, the first or a randomly selected product is returned.
Response: JSON object representing the chosen product, including:
title: String, the product name.
category: String, the product's category.
price: Float, the product's price.
product_serial_number: String/int, the product's unique identifier.
campaign_name: String, the name of the campaign promoting the product (optional, if applicable).

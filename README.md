# SupermarketStoreRestAPI

## PROJECT STRUCTURE

The project contains four packages; Domain, Api, Data and Service.

Domain 
- Contains the entities; 
		Vendor - vendor details, 
		Store - items from the vendor
		Supermarket - items released from the store go into the supermarket
 		ItemsReturned - faulty items are returned to the vendor from the store
- Contains the corresponding Repositories to the above entities.
	Store Repository 
	- Has a method to find Items received within a Date Range using the Between predicate. This method can be used to
		fetch Items received in the last week or month by providing the appropriate Date Range (startDate and endDate),
	- Has a method to find Items created today.

	Supermarket Repository
	- Has a method to find Items released to supermarket today.


Api
- Contains all the controllers for CRUD and other operations.

Data
- Contains all the Data Transfer Objects (DTO), mapped where necessary.

Service
- Contains the logic for the project.

## TESTING THE APIs
I have provided a Postman Collection to aid in testing the APIs.
The basic order for testing is as follows:

1. Create a Vendor
2. Create a Store Item
3. Release Item to Supermarket
4. Return spoilt Item to Vendor
5. List Items created today
6. List Items by Date Range 

N.B - The Vendor should be created first since we need to know where the Items have come from in order to return them if not in good condition.

12FEB - Buildings Registry

Create a Building class representing a building, with these properties:

&nbsp;- category (possible values: residential, office, hospital, religious) --> use an enum for the values of category field

&nbsp;- price

&nbsp;- neighborhood

Create a BuildingRegistry class, containing these static methods (each receives a List<Building> as an input parameter, and you need to decide on their return type):

&nbsp;- categoriesCount() - returns the number of categories (of the actual buildings, not all possible categories)

&nbsp;- neighborhoodsList() - returns the list of names of unique neighborhoods, sorted alphabetically (hint: may use a Set)

&nbsp;- averagePriceForOneCategory() - returns the average price for buildings from only one category (given as a 2nd input param to the method)

&nbsp;- averagePricePerCategory() - returns the average price for each building category (note: for the defined categories that don't have any buildings now, you may either not return any key in map, or you may return a key but with value 0, as you like)

&nbsp;- averagePricePerNeighborhood() - returns the average price for each neighborhood.


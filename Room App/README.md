22FEB - Room app
Create a class Room, modeling a room which may contain multiple persons:

&nbsp;- the room has a field named capacity (showing the maximum number of persons that can be in the room at the same time)

&nbsp;- this property is mandatory and should always be required when a new Room instance is built (hint: need to handle it in a constructor)

&nbsp;- once a room is built, the capacity cannot be changed, but it should be readable from outside (hint: need a getter, but no setter; also, you could use 'final' for capacity field)

&nbsp;- the room should be able to store multiple objects of type Person (up to its max capacity)

Hint: you'll need a field holding an array of Person objects (also initialized in the constructor, based on the given room capacity)

The room should have these methods defined:

&nbsp;- int getCount() - returns the number of persons currently in the room;

&nbsp;- void printAll() - should print the room's max capacity, the number of persons currently in the room, and the details of each person (printed one per row, using Person.toString() method);

&nbsp;- void enter(Person person) - should add the given person to the room, if there is still space left (current number of persons < max capacity), or else print an error message and ignore this add request;

Hint: you may need to have a separate field to count the actual number of persons in the room (personsCount, which may be different/lower than the max room capacity)

\[Optional]: add a validation so we don't accept in the room persons with the exact same name (in that case just print an error message and ignore the request to add the new person with duplicate name)

&nbsp;- boolean isPresent(String personName) - should return true only if a person with the specified name is currently present in the room;

&nbsp;- String getOldest() - returns the name+age of the oldest person in the room, as a single String value (format: "<name>(<birthYear>)"), or empty string if no person found 

Note: if there are multiple persons that are the oldest in the room (have the same max age), is ok to return the name of any of them.

String\[] getNames(String hairColor) - returns an array with the names of all persons in room that have the hairColor property equal to the given color;

&nbsp;- void exit(String personName) - search and remove from room the person(s) that have the specified name;

Hint1: once a person is found and should be removed, you need to update the array so all persons coming after it should be moved one position lower (towards the beginning of the array); also, the current persons counter needs to be updated after this

Hint2: you may want to define a helper method 'int indexOf(String name)' which searches for the first person with that name and returns its index, or -1 if not found; this would have some code very similar to the one in isPresent() method, so you should avoid duplication and make isPresent() use this helper method; you could then easily use this helper method in the exit() method


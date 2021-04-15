# binary-search-tree
Class Assignment for Data Structures and Algorithms to demonstrate proficiency in Binary Search Trees and auto-balancing AVL trees

You will be creating a new class called an IntegerSet.  Here are the characteristics of the IntegerSet type.

1.	Integers stored are unique. (No duplicates).

2.	The IntegerSets are ordered.

The IntegerSet class is given to you to complete.  

•	magnitude() - This one is completed and returns the size of the set.

•	toString() - You must write the code for this method.  Use an inorder traversal to create the string. Will require a recursive method that utilizes the StringBuffer class.

•	contains() - You must write the code for this method.  This method returns whether a value is in the set. It must have an average BigO(log n).  If the value is in the set then a True is returned otherwise False.

•	union() - You must write the code for this method.  This is the mathematical union on two sets which creates a new set that contains all the elements from both sets.  For example, [1, 2, 3] U [2, 3, 5, 6] results in a new set [1, 2, 3, 5, 6].

•	Intersection() - You must write the code for this method.  This is the mathematical intersection operation on two sets that returns a new set that contains elements that belong to both sets.  For example, [1, 2, 3]  [2, 3, 4, 5, 6] results in a new set [2, 3].

•	add() - You must write the code for this method.  Adds a new integer to the set.  Duplicates are not allowed.  Returns a true if an element was added otherwise returns false.
For each method you need to complete can be done with a poor O(N2) time, but the methods must at least be O(NlogN) time (So no brute force algorithms).  
The integer set must be represented as a binary search tree.

What you need to complete
Finish the toString, add, contains, union, and intersection methods.
Constructors
There are two constructors.  The default empty constructor which can be used to create an empty IntegerSet and a constructor that accepts an int array that takes the elements from the array and constructs the binary search tree from these elements.

public IntegerSet() - Empty constructor.  Results in an empty IntegerSet.
public IntegerSet(int array[]) - Accepts an int array and constructs the necessary Binary Search Tree from it.

Set Methods

contains()
This method returns true or false if a given value is in the set.  Must be done in logN time on average.  Here is an example,
IntegerSet iS1 = new IntegerSet([2, 3, 4, 1]);
iS1.contains(3); //returns true
iS2.contains(6); //returns false

intersection()
This method takes another IntegerSet object and intersects it with the calling IntegerSet object.  Returns a new IntegerSet object.  Here is an example:
IntegerSet iS1 = new IntegerSet([2, 4, 3, 1]); 
IntegerSet iS2 = new IntegerSet([5, 7, 6, 3, 4]);
iS1.intersection(iS2) //a new IntegerSet([3, 4]);

union()
The union method takes another IntegerSet object and returns a new IntegerSet object that contains the unique elements of both sets.  Returns a new IntegerSet object.  Here is an example,
IntegerSet iS1 = new IntegerSet([2, 1, 3]); 
IntegerSet iS2 = new IntegerSet([3,6]);
 
iS1.intersection(iS2) //a new IntegerSet([1, 2, 3, 6]);

NOTE 1: Union and intersection return a new integer set.  They do not modify the caller or the parameter.
NOTE 2: The methods not explicitly mentioned here (toString and add) still require you to implement them.
This project is a demonstration about how you might utilize a data structure to implement other abstract concepts.  You are creating a library for handling mathematical models of integer sets.  
You may add any additional private utility methods and classes to help you accomplish the task.
You may not use a built-in tree Java library.  You must implement your own tree.
Final Step
Just a Binary Search tree will have an average case of BigO(Log N) on searches but will have a worst case of BigO(N).  The data could be sorted before being passed in which will result in linked list like behavior.  For the last 15 points, convert the Binary Search Tree to an AVL tree.  You will need to auto-balance the tree anytime a new value is added.

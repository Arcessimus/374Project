# 374Project


#Design
The various ClassVisitor subclasses will make two passes through the classes given to the generator.

On the first pass, an internal representation will be created by having the ClassTraverser method decorate each of the classes so that the decorated object can accept the visitor classes.
Then and internal representation that implements the IClass/IMethod/IField interfaces will be created.

After we have an internal representation, the program will make a second pass, this time with all of the classes implementing ITraverser (in the style of Lab 3-1). Then the class
representations will be translated into a GraphViz file via the GraphVizOutputStream.


#Ashok
Added picture of lab 1-3 UML
Added lab 1-3 files
Finalized the UML Diagram
Took a stab at trying to implement ASM parsing

#Derrick
Set up the repository and the project
Did the Readme
Created a rough version of the project UML
Created a test suite for all tests and for all milestone 1 tests
Created a few dummy classes for unit testing purposes
Also took a stab at trying to implement ASM parsing

#Status
We did not get all that far for this Milestone. It is very clear that the part that is tripping us up is the ASM parsing portion of the Milestone. We plan on talking to Chandan and
meeting on both Tuesday evening and Wednesday in order to get back on track.
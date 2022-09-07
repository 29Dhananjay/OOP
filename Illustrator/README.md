CS5001: Practical 4 - Vector Drawing


Basic requirements:
====================================
Achieved all the basic requirements: 
1. Straight line 
2. Rectangle 
3. Ellipse  
4. Diagonal cross 
5. Undo/Redo
6. Colours



Advanced requirements
=======================================================================================
Achieved the following advanced requirements:

1. Shapes can be filled with a colour before drawing them

2. Added more shapes: (triangles, parallelogram)

3. Support for drawing circles and squares by locking the aspect ratio:	
 (press the 'A' key to lock the aspect ratio: can draw squares and circles)
 (press the 'SHIFT' key to unlock the aspect ratio: can draw rectangles and ellipses)



Instructions for compiling the Vector Drawing program 
=======================================================================
1. Enter terminal.

2. Change to the directory which contains the src and the tests folder.

3. Compile the Vector Drawing program: javac src/*.java

4. Open the src file: cd src/

4. Run the Vector Drawing program: java Main


Instructions for compiling and running the Junit tests (MAC)
=====================================================================================================

1. Enter the terminal.

2. Change to the directory which contains the src and the tests folder.

3. Compile JUnit tests: javac -cp junit.jar:hamcrest.jar:./tests/:. tests/*.java

4. Run JUnit tests: java -cp junit.jar:hamcrest.jar:./tests/:. org.junit.runner.JUnitCore ModelTest



Instructions for compiling and running the Junit tests (Windows)
=====================================================================================================

1. Enter the command line.

2. Change to the directory which contains the src and the tests folder.

3. Compile JUnit tests: javac -cp junit.jar;hamcrest.jar;.\tests\;. tests\*.java

4. Run JUnit tests: java -cp junit.jar;hamcrest.jar;.\tests\;. org.junit.runner.JUnitCore ModelTest


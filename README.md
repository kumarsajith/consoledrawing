
# Author SAJITH KUMAR ARIMBRA (April 28, 2019)


# Console Based Drawing Board

This is console version of a drawing canvas. 
The current version can be used to create a Canvas, Draw lines, Rectangle and fill an area with a given color symbol.
the app can be downloaded from https://github.com/kumarsajith/consoledrawing.git

## Getting Started

The below instructions will get you a copy of the project and also executable version of the app.

### Prerequisites
You need Java version 1.8 or above to run the application.


###Installing the application
download the archive as zip file.
Unzip to a folder

### Running the application

Open a command prompt and then move to the location where you have unzipped the  file.
Go to "target" folder and type below command to start the application. There will be guide given in the application for how  to use

java -cp canvas-0.0.1-SNAPSHOT.jar canvas.DrawApp

The above will open the command line interface to start the application. 

Use the drawing commands to play with the application.

###Command Guide

You can use below commands to draw in the application.

C <rows> <columns>	[Create a canvas with dimension as given by <rows> by <columns>. e.g C 30 40]
L x1 y1 x2 y2	[Draw a line from (x1,y1) to (x2,y2). Points should be within canvas boundaries. e.g L 5 4 10 20]
R x1 y1 x2 y2	[Draw a Rectangle from (x1,y1) to (x2,y2). Points should be within canvas boundaries. e.g R 5 4 10 20]
B x y c	[Fill the area surrounding the point (x,y) with given color c. x, y should be within canvas boundaries and c should be a single character. e.g B 2 3 r]
Q	[Quit the application. e.g Q]


### Developer Guidelines for extending the application.

The project is developed with Maven and this is a dependency to develop further.

If you want to develop a new command, then extend the AbstractCommand interface and provide implementations.
After the implementation are done, update the CommandCompiler class with new command and the implementation class.

### Known Issues

The display of the graph will be wrapped in case the terminal window is smaller than graph size.
The line command also supports other lines apart from horizontal and vertical lines. The line function is implemented as an approximation of step functions in case of Non horizontal or vertical lines.



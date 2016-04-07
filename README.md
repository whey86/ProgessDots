# Progressdots
Progressdots is a small android library to visualize the progress in a step progress.

## Example
#### You are on step 1

![Step 1](http://i.imgur.com/ZDgBZUT.png) 

#### You finished step one and now on step 2

![Step 2](http://i.imgur.com/vniKtPl.png)

#### You finished step 1 & 2 and are now on step 3

![Step 3](http://i.imgur.com/gyfQg5k.png)

## How to use it

##### 1. Add the library to project
##### 2. Add view to XML, example:
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        custom:pdSize="3"
        custom:pdRadius="20"
        custom:colorDone="@color/colorAccent"
        custom:colorUndone="@android:color/darker_gray"/>

Attributes are opional but at least pdSize should be set or else default values will be used. The view have 4 custom attributes:

1. pdSize -> Number of steps(dots)

2. pdRadius -> Radius of the dots

3. colorDone -> Color of a finished step

4. colorUndone -> Color of a non finished step

##### 2. Update ProgressDots:
ProgressDots have two methods to update the ProgressDotsBar:

1. next(); -> Move to next step

2. back(); -> Move back to previous step



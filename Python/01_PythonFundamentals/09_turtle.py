
import turtle
# the distance we want the pointer to travel each time
distance = 100
for x in range(0,6):
    print "x", x
    for y in range(1,5):
        print "y", y
        
        # advance according to set distance
        turtle.forward(distance)
        turtle.right(30)
        
    # add to set distance
    

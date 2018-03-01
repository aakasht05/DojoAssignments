class Bike (object):
    def __init__(self, price, max_speed):
        self.price = price
        self.max_speed = max_speed
        self.miles = 0
        
    def displayInfo(self):
        print "Price:", self.price
        print "Max Speed:", self.max_speed
        print "Total Miles Driven:", self.miles
        return self

    def ride(self):
        print "Riding"
        self.miles += 10
        return self
    
    def reverse(self):
        print "Reversing"
        if self.miles > 0:
            self.miles -= 5
        return self

bike1 = Bike(25,250)
bike1.ride().ride().ride()
bike1.reverse()
bike1.displayInfo()

bike2 = Bike(40, 300)
bike2.ride().ride()
bike2.reverse().reverse()
bike2.displayInfo()

bike3 = Bike(50,100)
bike3.reverse().reverse().reverse()
bike3.displayInfo()
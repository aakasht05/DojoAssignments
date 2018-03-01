class Car(object):
    def __init__(self, price, speed, fuel, mileage):
        self.price = price
        self.speed = speed
        self.fuel = fuel
        self.mileage = mileage
        if price > 10000:
            self.tax = 0.15
        else:
            self.tax = 0.12
    
    def displayAll(self):
        print "The price is:", self.price
        print "The speed is:", self.speed
        print "The fuel is:", self.fuel
        print "The mileage is:", self.mileage
        print "The tax is:", self.tax
        print
        return self

firstCar = Car(12000, "120mph","Full","30mpg")
secondCar = Car(9000, "90mph","Not Full","60mpg")
thirdCar = Car(10000, "90mph","Emptyl","20mpg")
fourthCar = Car(20000, "140mph","Kind of Full","40mpg")
fifthCar = Car(1000, "60mph", "Full", "20mpg" )
sixthCar = Car(100000, "200mph","Empty","18mpg")

firstCar.displayAll()
secondCar.displayAll()
thirdCar.displayAll()
fourthCar.displayAll()
fifthCar.displayAll()
sixthCar.displayAll()


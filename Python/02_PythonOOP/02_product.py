class Product(object):
    def __init__(self, price, itemName, weight, brand, status):
        self.price = price
        self.itemName = itemName
        self.weight = weight
        self.brand = brand
        self.status = status
    
    def sell(self):
        self.status = "sold"
        return self

    def tax(self,tax):
        self.price = (self.price * tax) + self.price
        return self

    def displayInfo(self):
        print self.price
        print self.itemName
        print self.weight
        print self.brand
        print self.status
        print

    def returnItem(self,reason):
        if (reason == "defective"):
            self.status = "defective"
            self.price = 0
        elif (reason == "like new" ):
            self.status = "for sale"
        elif (reason == "openbox"):
            self.status = "used"
            self.price = (self.price - (self.price * .20))
        return self

product1 = Product(5,"shirt",2,"TH","notsold")
product1.displayInfo()

product1.tax(0.07)
product1.sell()
product1.displayInfo()

product1.returnItem("openbox")
product1.displayInfo()
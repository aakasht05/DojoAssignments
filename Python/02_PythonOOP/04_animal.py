class Animal(object):
    def __init__(self, name, health):
        self.name = name
        self.health = health
    
    def walk(self):
        self.health -= 1
        return self

    def run(self):
        self.health -= 5
        return self

    def displayHealth(self):
        print self.health
        return self

class Dog(Animal):
    def __init__(self, name):
        super(Dog, self).__init__(self, name)
        self.health = 150
    
    def pet(self):
        self.health += 5
        return self

class Dragon(Animal):
    def __init__(self,name):
        super(Dragon, self).__init__(self, name)
        self.health = 170

    def fly(self):
        self.health -= 10
        return self
    
    def displayHealth(self):
        super(Dragon,self).displayHealth()
        print "I AM A DRAGON"
        return self

firstAnimal = Animal("Aakash", 100)
firstAnimal.displayHealth()

firstDog = Dog("Ella")
firstDog.displayHealth()
firstDog.walk().run().pet().displayHealth()

firstDragon = Dragon("Blue Eyes")
firstDragon.displayHealth().fly().displayHealth()   
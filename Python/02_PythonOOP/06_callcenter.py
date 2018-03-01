from datetime import datetime

class Call(object):
    def __init__(self, id, name, number, reason):
        self.id = id
        self.name = name
        self.number = number
        self.reason = reason
        self.time = datetime.now()

    def displayInfo(self):
        print "ID:", self.id
        print "Name:", self.name
        print "Number:", self.number
        print "Reason:", self.reason
        print "Time:", self.time
        return self
    
	def __repr__(self):
		return "{} {}".format(self.name, self.number)

class CallCenter(Call):
    def __init__(self):
        self.calls = []
        self.queueSize = 0
    
    def addCall(self, call):
        self.calls.append(call)
        self.queueSize += 1
        return self

    def remove(self):
		del self.calls[0]
		self.queueSize -= 1
		return self

    def info(self):
	    print "There are ", self.queueSize," calls waiting."
	    for call in self.calls:
	        call.displayInfo() 
	    return self
        

callOne = Call(111, "Ghostbusters", "123-4567", "There's a ghost")
callOne.displayInfo()

callTwo = Call(222, "Ghosts", "523-45e7", "There's a ghostbuster")
callTwo.displayInfo()

center1 = CallCenter()
center1.addCall(callOne).addCall(callTwo).info().remove().info()

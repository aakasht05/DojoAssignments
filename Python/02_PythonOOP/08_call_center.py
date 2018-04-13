calls = []

class Call(object):
    def __init__(self,name,phone,time,reason):
        self.uid    = len(calls)
        self.name   = name
        self.phone  = phone
        self.time   = time
        self.reason = reason
        calls.append(self)
    def display(self):
        for i in vars(self).items():
            print i[0]+":",i[1]

call  = Call("Jonathan","123-546-1231","1:30PM","My first Phone Call")
call2 = Call("Sally","732-694-8240","2:30PM","I'm having a baby")
call3 = Call("Jacob","732-789-1230","5:30PM","There is a problem with your account")

class CallCenter(object):
    def __init__(self):
        self.calls = []
        self.queue = len(self.calls)
    def add(self,call):
        if type(call) != Call:return
        self.calls.append(call)
        self.queue = len(self.calls)
    def remove(self,phone):
        call = 0
        for ind in range(0,len(self.calls)-1):
            call = self.calls[ind]

            if call.phone == phone:
                print "Removed call from: {}\n".format(call.name)
                self.calls.pop(ind)
                self.queue = len(self.calls)
        
    def info(self):
        for call in self.calls:
            print call.display(),"queue:{}".format(self.queue),"\n"

callCenter = CallCenter()
callCenter.add(call)
callCenter.add(call2)
callCenter.add(call3)
callCenter.info()
callCenter.remove("732-694-8240")
callCenter.info()
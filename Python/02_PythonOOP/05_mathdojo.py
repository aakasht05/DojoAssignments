class MathDojo(object):
    def __init__(self):
        self.val = 0
   
    def add(self,*args):
        for i in args:
            if (type(i) == (list)) or (type(i) == (tuple)):     
                for j in range(0,len(i)):
                    self.val += i[j]
            else:
                self.val += i
        return self
    
    def subtract(self,*args):
        for i in args:
            if (type(i) == (list)) or (type(i) == (tuple)):
                for j in range(0,len(i)):
                    self.val -= i[j]
            else:
                self.val -= i
        return self

    def displayVal(self):
        print "Sum:", self.val
        return self

md = MathDojo()
md.add(2).add(2,5).subtract(3,2).displayVal()
md.add([1],3,4).add([3,5,7,8], [2,4.3,1.25],(4,3,5,6)).subtract(2, [2,3], (4,3,2,1),[1.1,2.3]).displayVal()

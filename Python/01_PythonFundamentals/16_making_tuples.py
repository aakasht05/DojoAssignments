my_dict = {
  "Speros": "(555) 555-5555",
  "Michael": "(999) 999-9999",
  "Jay": "(777) 777-7777"
}

#function output
# [("Speros", "(555) 555-5555"), ("Michael", "(999) 999-9999"), ("Jay", "(777) 777-7777")]

def listOfTuple(myDictionary):
    newTuple = ()
    for i in myDictionary:
        newTuple = newTuple + (i, myDictionary[i])

    print newTuple 
            
listOfTuple(my_dict)
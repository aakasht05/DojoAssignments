listOne = ['magical unicorns',19,'hello',98.98,'world']
listTwo = [2,3,1,7,4,12]
listThree = ['magical','unicorns']

def typeList(x):
    sum = 0
    sumCount = 0
    newString = ""
    stringCount = 0

    for i in range(0,len(x)):
        if (type(x[i]) == int):
            sum += x[i]
            sumCount += 1
        elif (type(x[i]) == str):
            newString += (" " + x[i])
            stringCount += 1
        
    if ((sumCount > 0) & (stringCount > 0)):
        print ("The list is mixed")
        print ("String:" + newString)
        print ("Sum:", sum)
    elif (sumCount > 0):
        print ("The list has integers")
        print ("Sum:", sum)
    elif (stringCount > 0):
        print ("The list has strings")
        print ("String:" + newString)

typeList(listOne)
typeList(listTwo)
typeList(listThree)
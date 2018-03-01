words = "It's thanksgiving day. It's my birthday,too!"
listOne = [5, -4, 9, 10, 2, 0, 4]

def findAndReplace(str):
    print str.find("day")
    print str.replace("day","month")
    return;
def minMax(list):
    print min(list)
    print max(list)
    return;

def firstAndLast(list):
    print list[0]
    print list[len(list)-1]
    return;

def newList(list):
    list.sort()
    print list
    firstList = list[ :len(list)/2]
    secondList = list[len(list)/2: ] 
    secondList.insert(0, firstList)
    print secondList
    return;

findAndReplace(words)
minMax(listOne)
firstAndLast(listOne)
newList(listOne)
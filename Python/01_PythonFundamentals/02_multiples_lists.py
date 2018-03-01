listOne = [5, -4, 9, 10, 2, 0, 4]

def for1000():
    for i in range(1, 1001, 2): 
        print i

def for5000():
    for i in range(5, 5001, 5): 
        print i


def sumList(list):
    sum = 0
    for i in range(0, len(list)-1):
        sum += list[i]
    print sum

def avgList(list):
    sum = 0
    for i in range(0, len(list)-1):
        sum += list[i]
    avg = sum/len(list)
    print avg

for1000()
for5000()
sumList(listOne)
avgList(listOne)
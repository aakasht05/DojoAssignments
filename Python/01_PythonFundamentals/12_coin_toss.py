import random

def coinToss():
    headsCount = 0
    tailsCount = 0

    print "Starting the program"
    for i in range(0,5001):
        randNum = random.randint(0,1)
        
        if (randNum == 0):
            headsCount += 1
            print "Attempt #{}: Throwing a coin...It's a heads!...Got {} head(s) so far and {} tail(s) so far".format(i,headsCount,tailsCount)
        else:
            tailsCount += 1
            print "Attempt #{}: Throwing a coin...It's a tails!...Got {} head(s) so far and {} tail(s) so far".format(i,headsCount,tailsCount)

    print "Ending the program. Thank you!"    
       
coinToss()
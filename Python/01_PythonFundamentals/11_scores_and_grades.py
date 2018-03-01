import random

def scoresGrades():
    print "Scores and Grades"
    for i in range(0,10):
        randNum = random.randint(60,100)

        if (randNum >= 90):
            print "Score {}; Your grade is A".format(randNum)
        elif(randNum >= 80):
            print "Score {}; Your grade is B".format(randNum)
        elif(randNum >= 70):
            print "Score {}; Your grade is C".format(randNum)
        elif(randNum >= 60):
            print "Score {}; Your grade is D".format(randNum)

    print "End of program. Bye!"

scoresGrades()
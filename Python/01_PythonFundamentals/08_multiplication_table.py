def multiplicationTable():
    firstString = ""
    
    for x in range(0, 13):
        if x == 0:
            firstString += "x  "
        else:
            firstString += "{}".format(x) + "  "
    print firstString

    for i in range(1,13):
        string = ""
        for j in range(0,13):
            if j == 0:
                string += "{}".format(i) + "  "
            else:
                string += "{}".format(i * j) + "  "          
        print string


multiplicationTable()
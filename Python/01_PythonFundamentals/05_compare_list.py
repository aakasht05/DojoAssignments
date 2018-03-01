list_one = [1,2,5,6,2]
list_two = [1,2,5,6,2]

list_three = [1,2,5,6,5]
list_four = [1,2,5,6,5,3]

list_five = [1,2,5,6,5,16]
list_six = [1,2,5,6,5]

list_seven = ['celery','carrots','bread','milk']
list_eight = ['celery','carrots','bread','cream']

def compareList(x,y):
    x.sort()
    y.sort()
    count = 0

    if (len(x) == len(y)):
        for i in range(0,len(x)):
            if (x[i] == y[i]):
                count += 1
            else:
                break
        if (count == len(x)):
            print ("The lists match")
        else:
            print ("The lists are different")
    else:
        print("The lists are different")

compareList(list_one,list_two)
compareList(list_three,list_four)
compareList(list_five,list_six)
compareList(list_seven,list_eight)
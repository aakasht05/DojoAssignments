word_list = ['hello','world','my','name','is','Anna']
char = 'o'


def findChars(x,y):
    new_list = []

    for i in range(0,len(x)):
        if (y in x[i]):
            new_list.append(x[i])
            
    print new_list



findChars(word_list,char)
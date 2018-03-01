def odd_evens():
    for i in range(1,2001):
        if (i % 2 == 0):
            print "Number is {}. This is an even number.".format(i)
        else:
            print "Number is {}. This is an odd number.".format(i)


def multiply(x,num):
    for i in range(0,len(x)):
        x[i] *= num
    return x

def layered_multiples(arr):
    new_array = []
    for i in range(0,len(arr)):
        oneString = ""
        for j in range(0,arr[i]):
            oneString += "1"

        new_array.append(oneString)
    
    return new_array


odd_evens()

a = [2,4,10,16]
b = multiply(a, 5)
print b

x = layered_multiples(multiply([2,4,5],3))
print x


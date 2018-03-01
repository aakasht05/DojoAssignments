x = [4, 6, 1, 3, 5, 7, 25]
x2 = [4, "Tom", 1, "Michael", 5, 7, "Jimmy Smith"]

def draw_stars(input_list):

    for i in input_list:
        if (type(i) == int): 
            print "*" * i
        elif(type(i) == str):
            print (i[0] * len(i)).lower()
        

draw_stars(x)
draw_stars(x2)
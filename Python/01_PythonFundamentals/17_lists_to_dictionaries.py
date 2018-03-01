name = ["Anna", "Eli", "Pariece", "Brendan"]
favorite_animal = ["horse", "cat", "spider", "giraffe", "ticks", "dolphins", "llamas", ]

def make_dict(list1, list2):
    new_dict = {}

    if (len(list2) > len(list1)):
        new_dict = zip(list2,list1)
    else:
        new_dict = zip(list1,list2)
    
    print new_dict
    return new_dict


make_dict(name,favorite_animal)
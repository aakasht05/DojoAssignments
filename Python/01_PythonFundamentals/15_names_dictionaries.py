students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'},
     {'first_name' : 'Mark', 'last_name' : 'Guillen'},
     {'first_name' : 'KB', 'last_name' : 'Tonel'}
]

users = {
 'Students': [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'},
     {'first_name' : 'Mark', 'last_name' : 'Guillen'},
     {'first_name' : 'KB', 'last_name' : 'Tonel'}
  ],
 'Instructors': [
     {'first_name' : 'Michael', 'last_name' : 'Choi'},
     {'first_name' : 'Martin', 'last_name' : 'Puryear'}
  ]
 }


def studentsDictionary1(student_dictionary):
    for i in student_dictionary:
        print i["first_name"], i["last_name"]



def studentsDictionary2(student_dictionary):
    for i in student_dictionary:
        print i
        count = 1
        for j in student_dictionary[i]:
            print count, " - ", j["first_name"].upper(), j["last_name"].upper(), " - ", (len(j["first_name"]) + len(j["last_name"]))
            count += 1
       

studentsDictionary1(students)
studentsDictionary2(users)
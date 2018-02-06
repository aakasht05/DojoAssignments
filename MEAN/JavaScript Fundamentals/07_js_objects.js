let students = [
    {name: 'Remy', cohort: 'Jan'},
    {name: 'Genevieve', cohort: 'March'},
    {name: 'Chuck', cohort: 'Jan'},
    {name: 'Osmund', cohort: 'June'},
    {name: 'Nikki', cohort: 'June'},
    {name: 'Boris', cohort: 'June'}
];

let users = {
    employees: [
        {'first_name':  'Miguel', 'last_name' : 'Jones'},
        {'first_name' : 'Ernie', 'last_name' : 'Bertson'},
        {'first_name' : 'Nora', 'last_name' : 'Lu'},
        {'first_name' : 'Sally', 'last_name' : 'Barkyoumb'}
    ],
    managers: [
       {'first_name' : 'Lillian', 'last_name' : 'Chambers'},
       {'first_name' : 'Gordon', 'last_name' : 'Poe'}
    ]
 };

for(let i in students){
    let name = students[i].name
    let cohort = students[i].cohort
    console.log(`Name:  ${name}, Cohort: ${cohort}`);
};

for (let i in users) {
    let lineNumber = 1;
    console.log(i.toUpperCase());
    for (let j in users[i]) {
        let firstName = users[i][j].first_name
        let lastName = users[i][j].last_name;
        let nameLength = firstName.length + lastName.length;
        console.log(`${lineNumber} - ${firstName} ${lastName} - ${nameLength}`);
        lineNumber++;
    }
}
//Number 1
var myString: string;
// I can assign myString like this:
myString = "Bee stinger";
// Why is there a problem with this? What can I do to fix this?
//cast the integer to a String type
myString = String(9);

console.log(myString);

//Number 2
function sayHello(name: string){
   return `Hello, ${name}!`;
}
// This is working great:
console.log(sayHello("Kermit"));
// Why isn't this working? I want it to return "Hello, 9!"
//cast 9 to String type
console.log(sayHello(String(9)));

//Number 3
function fullName(firstName: string, lastName: string, middleName?: string){

    if (middleName == undefined){
        var fullName = `${firstName} ${lastName}`;
    }?

    else{
        var fullName = `${firstName} ${middleName} ${lastName}`;
    }
    
    return fullName;
 }
 // This works:
 console.log(fullName("Mary", "Moore", "Tyler"));


 // What do I do if someone doesn't have a middle name?
 //Had to add a ? to the middleName parameter to indicate it is an optional parameter
 console.log(fullName("Jimbo", "Jones"));
//Number 4
interface Student {
   firstName: string;
   lastName: string;
   belts: number;
}
function graduate(ninja: Student){
   return `Congratulations, ${ninja.firstName} ${ninja.lastName}, you earned ${ninja.belts} belts!`;
}
const christine = {
   firstName: "Christine",
   lastName: "Yang",
   belts: 2
}
const jay = {
   firstName: "Jay",
   lastName: "Patel",
   belts: 4
}
// This seems to work fine:
console.log(graduate(christine));
// This one has problems:
//the attribute for belts in jay was spelled incorrectly
console.log(graduate(jay));

//Number 5
class Ninja {
    fullName: string;
    constructor(
       public firstName: string,
       public lastName: string){
          this.fullName = `${firstName} ${lastName}`;
       }
 }
 // This is not making an instance of Ninja, for some reason:
 //had to remove () as Ninja is not a method
 const shane = Ninja;
 
 // Since I'm having trouble making an instance of Ninja, I decided to do this:

 const turing = {
     fullName: "Alan Turing",
     firstName: "Alan",
     lastName: "Turing"
 }
 
 // Now I'll make a study function, which is a lot like our graduate function from above:
 function study(programmer: Ninja){
    return `Ready to whiteboard an algorithm, ${programmer.fullName}?`
 }
 // Now this has problems:
 //had to remove the debug method in Ninja class
 console.log(study(turing));
 
 //Number 6
var increment = x => x + 1;
// This works great:
console.log(increment(3));

//had to remove brackets around {x * x} to return the number value
var square = x => x * x;
// This is not showing me what I want:
console.log(square(4));
// This is not working:
//had to fix the multiply arrow function
var multiply = (x,y) => x * y;
// Nor is this working:
//added arrow function and surrounded function with {}
var math = (x, y) => {
    let sum = x + y;
    let product = x * y;
    let difference = Math.abs(x - y);
    return [sum, product, difference];
}

 //Number 7
 //added arrow function to birthday method so that Barbar's age would increment by 1
 class Elephant {
    constructor(public age: number){}
    birthday = (age) => {
       this.age++;
    }
 }
 
 const babar = new Elephant(8);
 setTimeout(babar.birthday, 1000)
 setTimeout(function(){
    console.log(`Babar's age is ${babar.age}.`)
    }, 2000)
 // Why didn't babar's age change? Fix this by using an arrow function in the Elephant class.
 
   
//1
console.log(hello);
var hello = 'world';
//prints undefined. world is assigned to hello after the console log statement.

//2
var needle = 'haystack';
test();
function test(){
	var needle = 'magnet';
	console.log(needle);
}
//prints magnet 

//3
var brendan = 'super cool';
function print(){
	brendan = 'only okay';
	console.log(brendan);
}
console.log(brendan);
//prints super cool as the funtion print was never called

//4
var food = 'chicken';
console.log(food);
eat();
function eat(){
	food = 'half-chicken';
	console.log(food);
	var food = 'gone';
}
//will print chicken and then print half-chicken

//5
mean();
console.log(food);
var mean = function() {
	food = "chicken";
	console.log(food);
	var food = "fish";
	console.log(food);
}
console.log(food);
//type error. mean function is called before defined.

//6
console.log(genre);
var genre = "disco";
rewind();
function rewind() {
	genre = "rock";
	console.log(genre);
	var genre = "r&b";
	console.log(genre);
}
console.log(genre);
//prints undefined, rock, r&b, disco

//7
dojo = "san jose";
console.log(dojo);
learn();
function learn() {
	dojo = "seattle";
	console.log(dojo);
	var dojo = "burbank";
	console.log(dojo);
}
console.log(dojo);
//prints san jose, seattle, burbank, san jose
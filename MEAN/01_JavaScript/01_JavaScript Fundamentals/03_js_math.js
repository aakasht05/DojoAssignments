let arr1 = [0, 3, -7, 2, 15];
let arr2 = [3, 5, 1, 10, 20];
let arr3 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let arr4 = [100, 200, 300, 400, 500];
let num1 = 30;
let num2 = 29;
let num3 = 5;

function zero_negativity(arr) {
    for (i = 0; i < arr.length; i++) {
        if (arr[i] < 0) {
            return false; //contains negative number
        }
    }
    return true; //no negative number
}

function is_even(num) {
    if (num % 2 == 0) {
        return true; //even number 
    }
    return false; //odd number
}

function how_many_even(arr) {
    var count = 0;
    for (var i = 0; i < arr.length; i++) {
        if (is_even(arr[i])) {
            count++;
        }
    }
    return count;
}

function create_dummy_array(n) {
    dummy_array = [];
    for (i = 0; i <= n; i++) {
        dummy_array.push(Math.floor(Math.random() * (Math.pow(10, n) - 1) - (Math.pow(10, n)) / 10 + (Math.pow(
            10, n)) / 10));
    }
    return dummy_array;
}

function random_choice(arr) {
    return arr[Math.floor(Math.random() * arr.length)];
}



console.log(zero_negativity(arr1));
console.log(zero_negativity(arr2));

console.log(is_even(num1));
console.log(is_even(num2));

console.log(how_many_even(arr3));

console.log(create_dummy_array(8));

console.log(random_choice(arr4));

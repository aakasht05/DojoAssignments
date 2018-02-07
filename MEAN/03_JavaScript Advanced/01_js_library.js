var _ = {
    map: function (arr, cb) {
        for (let i = 0; i < arr.length; i++) {
            arr[i] = cb(arr[i]);
        }
        return arr;
    },
    reduce: function (arr, cb) {
        let sum = 0;
        for (let i = 0; i < arr.length; i++) {
            sum += cb(arr[i]);
        }
        return sum;
    },
    find: function (arr, cb) {
        for (let i = 0; i < arr.length; i++) {
            if (cb(arr[i])) {
                return arr[i];
            }
        }
    },
    filter: function (arr, cb) {
        let newArr = [];
        for (let i = 0; i < arr.length; i++) {
            if (cb(arr[i])) {
                newArr.push(arr[i]);
            }
        }
        return newArr;
    },
    reject: function (arr, cb) {
        let newArr = [];
        for (let i = 0; i < arr.length; i++) {
            if (!cb(arr[i])) {
                newArr.push(arr[i]);
            }
        }
        return newArr;

    }
}

var evens = _.filter([1, 2, 3, 4, 5, 6], function (num) {
    return num % 2 == 0;
});
console.log(evens); // if things are working right, this will return [2,4,6].

var odds = _.reject([1, 2, 3, 4, 5, 6], function (num) {
    return num % 2 == 0;
});

console.log(odds) //if things are working right, this will return [1,3,5].
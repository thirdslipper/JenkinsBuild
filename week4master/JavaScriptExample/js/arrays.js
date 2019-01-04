// All objects in JavaScript consist of key-value pairs

var obj = {0: 1, "1":2, "2":3};
console.log(obj);
var arr = [1,2,3];
console.log(arr);

// normally to access an object's key we just obj.key
console.log(obj[0]);
console.log(arr[0]);

console.log(obj["0"]);
console.log(arr["0"]);

// arr.t = 5;
// obj.t = 5;

// console.log(obj);
// console.log(arr);

// ARRAYS ARE JUST OBJECTS
// OBJECTS consist of key-value pairs
// KEYS ARE STRINGS
// values are any type.

// Array indices are STRING
// when you search an index in an array, it does string comparison
console.log(arr.length);
console.log(arr);
arr.length=5;
console.log(arr.length);
console.log(arr);

arr.length = 1;
console.log(arr);

arr.length = 7;
console.log(arr);

arr[4] = 6;
console.log(arr);
arr[9] = 5;
console.log(arr);

delete arr[0];
console.log(arr);
console.log(arr[14]);

var arr2 = [1,2,3,4,5];
console.log(arr2);
arr2.splice(1,2);
console.log(arr2);
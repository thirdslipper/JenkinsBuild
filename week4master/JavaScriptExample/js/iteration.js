/*
JavaScript types
Number
String
Symbol
Boolean
Null
Undefined

Object
*/

// iteration example
a = "ten"; //string
b = 10; //number
c = true; // boolean
d={}; //object
e = null; //null
f = ""; //string
g = (0/0); //number
h = []; // array is an array which is an object
i = function(){}; // function is a function which is an object
//j; //undefined

var list = [a,b,c,d,e,f,g,h,i];

// Standard For
// for(var k = 0; k<list.length; k++) {
//     console.log(list[k]);
// }

// Enhanced For loop
// for(element in list) {
//     // iterate through the indices of the array
//     console.log(element);
//     console.log(list[element]);
// }

// For each function on the array prototype
list.forEach(
    // for each function takes in a callback function
    // the callback function will be called for each element in the array.
    function(value, index) {
        console.log(index+" "+value);
    }
)

list.forEach(
    (value) => {
        console.log(value);
    }
)
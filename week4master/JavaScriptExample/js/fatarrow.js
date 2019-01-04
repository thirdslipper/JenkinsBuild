// function startup() {
//     console.log("We started the thing");
// }

//window.onload=startup;
//A callback function is a function we define to be called by another function

// fat arrow notation
window.onload=()=>{console.log("We started the thing.")}

// with no curly braces, the one line gets returned.

var a = (a,b) => a+b;
console.log(a(5,6));

//functions like forEach(), sort(), any of the array functions
var arr=[1,2,3,4,5];
arr.forEach((item)=>{console.log(item)});

// Fat arrow functions behave differently from normal functions
// this is because they relate differently to the "this" keyword

// read about the "this" methods
//bind()
//apply()
//call()
// Unhoisted variables
// globally defined variable
a = 5;

// Block scoped (only applicable for JavaScript 6)
let c = 6;
const E = 5;

console.log(a);
console.log(b);
console.log(c);
console.log(E);
console.log(minus);
console.log(add(5,6));

b = 5;
// Hoisted Variable
// Function scoped
// Vars are found and declared at the top of their scope.
// They are not DEFINED at the top of their scope, just declared.
var b = 6;

var minus = function(first,second) {
    return first -second;
};
console.log(minus);
console.log(minus(5,6));
console.log(minus(5));

// JavaScript has no concept of Overloading

console.log(minus(5,5,5,5,5,5,5))

// When you do not provide a parameter to a function it is undefined.

// function declarations not tied to a variable get hoisted.
function add (first, second) {
    console.log(first);
    console.log(second);
    return first+second;
}

console.log(add(5,6));
console.log(add(5));
console.log(add(5,5,5,5,5));

function add(first, second) {
    //console.log(arguments);
    if(arguments.length===1) {
        return first;
    } else {
        let sum = 0;
        for(let i=0; i<arguments.length; i++) {
            sum+=arguments[i];
        }
        return sum;
    }
}

function add(first,second) {
    if(arguments.length===1) {
        var total = first;
        function innerAdd(num) {
            if(num!==undefined){
                total+=num;
                return innerAdd;
            } else {
                return total;
            }
        }
        return innerAdd;
    } else {
        let sum =0;
        for(let i=0; i<arguments.length; i++) {
            sum+=arguments[i];
        }
        return sum;
    }
}

// I want this to return 18
console.log(add(5)(6)(4)(3)(6)());
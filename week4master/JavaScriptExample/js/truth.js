// Truthy vs Falsey values

// Truthy - A truthy value is considered to be a boolean true
// Falsey - A falsey value is considered to be a boolean false


// truthy values in js - non zero numbers, non-empty strings, true, objects
if(10) {
    console.log("10 is true");
}
if(-10){
    console.log("-10 is true");
}
if(true){
    console.log("true is true");
}

if("true") {
    console.log("\"true\" is true");
}

if("false") {
    console.log("\"false\" is true");
}

if([]) {
    console.log("empty array is true");
}

// falsey values - empty string, null, NaN, 0, false
if(''&&"") {
    console.log("empty string is true");
} else {
    console.log("empty string is false");
}


if(!null) {
    console.log("null is false");
}

if(!false){
    console.log("false is false");
}

if(!0) {
    console.log("0 is false");
}

if(!(0/0)) {
    console.log("NaN is false");
}

var a = 5;
var b = 6;

for (var c = 0; c<b; c++) {
    a= 1+a*b;
}

if (a = b) {
    console.log(a);
    console.log("success");
} else {
    console.log(a);
    console.log("failure");
}
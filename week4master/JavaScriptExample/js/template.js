// Template literals
// ES6 spec: Enables expressions and returns inside of strings
// you use the ` to write a template literal instead of ' or "

//returns in string
let oldString = "Hello, my name is Richard \n" +
" and I like\n cheese."
console.log(oldString);

let templateliteral = `I allow my strings to have
returns right in them. No special characters
are required for this. No concatenation is 
required for this. It just happens.`;
console.log(templateliteral)

let template = `
<table id = "data">
    <tr>
        <th> Name </th>
    </tr>
</table>
`;
oldString = "<table id = \"data\"><tr><th>Name</th></tr></table>"

// expressions = ${expression}

let name = "Richard";
console.log("Hi, my name is "+name);
console.log(`Hi, my name is ${name}`);

let price = 6.5;
let tax = 0.3;
console.log(`The price of your book is: ${price * (1+tax)}`);

// floating point arithmetic does not work.
console.log(.1+.1+.1);
console.log(.3+.3+.3);

console.log(.1+.1);
console.log(.2+.1);

// semi-colons aren't strictly necessary...
// but they're there whether you put them there or not.

function add() {
    return {
        h: 5
    }
}

var h = add();
console.log(h);